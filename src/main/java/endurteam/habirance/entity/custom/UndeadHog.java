package endurteam.habirance.entity.custom;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Dynamic;
import endurteam.habirance.entity.ModEntityTypes;
import endurteam.habirance.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.behavior.*;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.NearestVisibleLivingEntities;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zoglin;
import net.minecraft.world.entity.schedule.Activity;
import net.minecraft.world.level.Level;

import java.util.Optional;

public class UndeadHog extends Zoglin{

    public UndeadHog(EntityType<? extends Zoglin> p_34204_, Level p_34205_) {
        super(p_34204_, p_34205_);
    }

    protected boolean isSunSensitive() {
        return true;
    }

    protected Brain.Provider<UndeadHog> hogBrainProvider() {
        return Brain.provider(MEMORY_TYPES, SENSOR_TYPES);
    }

    @SuppressWarnings("NullableProblems")
    protected Brain<?> makeBrain(Dynamic<?> pDynamic) {
        Brain<UndeadHog> brain = this.hogBrainProvider().makeBrain(pDynamic);
        initCoreActivity(brain);
        initIdleActivity(brain);
        initFightActivity(brain);
        brain.setCoreActivities(ImmutableSet.of(Activity.CORE));
        brain.setDefaultActivity(Activity.IDLE);
        brain.useDefaultActivity();
        return brain;
    }

    private static void initCoreActivity(Brain<UndeadHog> brain) {
        brain.addActivity(Activity.CORE, 0, ImmutableList.of(new LookAtTargetSink(45, 90), new MoveToTargetSink()));
    }

    private static void initIdleActivity(Brain<UndeadHog> brain) {
        brain.addActivity(Activity.IDLE, 10, ImmutableList.of(new StartAttacking<>(UndeadHog::findNearestValidAttackTarget), new RunSometimes<>(new SetEntityLookTarget(8.0F), UniformInt.of(30, 60)), new RunOne<>(ImmutableList.of(Pair.of(new RandomStroll(0.4F), 2), Pair.of(new SetWalkTargetFromLookTarget(0.4F, 3), 2), Pair.of(new DoNothing(30, 60), 1)))));
    }

    @SuppressWarnings("unchecked")
    private static void initFightActivity(Brain<UndeadHog> brain) {
        brain.addActivityAndRemoveMemoryWhenStopped(Activity.FIGHT, 10, ImmutableList.<net.minecraft.world.entity.ai.behavior.Behavior<net.minecraft.world.entity.Mob>>of(new SetWalkTargetFromAttackTargetIfTargetOutOfReach(1.0F), (net.minecraft.world.entity.ai.behavior.Behavior<net.minecraft.world.entity.Mob>)(net.minecraft.world.entity.ai.behavior.Behavior<?>)new RunIf<>(Zoglin::isAdult, new MeleeAttack(40)), (net.minecraft.world.entity.ai.behavior.Behavior<net.minecraft.world.entity.Mob>)(net.minecraft.world.entity.ai.behavior.Behavior<?>) new RunIf<>(Zoglin::isBaby, new MeleeAttack(15)), new StopAttackingIfTargetInvalid<>()), MemoryModuleType.ATTACK_TARGET);
    }

    private Optional<? extends LivingEntity> findNearestValidAttackTarget() {
        return this.getBrain().getMemory(MemoryModuleType.NEAREST_VISIBLE_LIVING_ENTITIES).orElse(NearestVisibleLivingEntities.empty()).findClosest(this::isTargetable);
    }


    private boolean isFullStaleArmor(LivingEntity entity){
        return entity.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.STALE_CAP.get() && entity.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.STALE_TUNIC.get() && entity.getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.STALE_PANTS.get() && entity.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.STALE_BOOTS.get();
    }

    private boolean isTargetable(LivingEntity entity) {
        EntityType<?> entitytype = entity.getType();
        return !isFullStaleArmor(entity) && entitytype != ModEntityTypes.UNDEAD_HOG.get() && entitytype != EntityType.CREEPER && Sensor.isEntityAttackable(this, entity);
    }



    public static AttributeSupplier setAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 40.0).add(Attributes.MOVEMENT_SPEED, 0.3).add(Attributes.KNOCKBACK_RESISTANCE, 0.6).add(Attributes.ATTACK_KNOCKBACK, 1.0).add(Attributes.ATTACK_DAMAGE, 6.0).build();
    }

    @Override
    public void aiStep() {

        if (this.isAlive()) {
            boolean flag = isSunSensitive() && this.isSunBurnTick();
            if (flag) {
                this.setSecondsOnFire(8);
            }
        }

        super.aiStep();
    }
}
