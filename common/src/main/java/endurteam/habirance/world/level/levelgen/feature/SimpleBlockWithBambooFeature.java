/**
 *     Habirance
 *     Copyright (C) 2022-2026  Team Endur
 *
 *     This file is part of Habirance
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package endurteam.habirance.world.level.levelgen.feature;

import com.mojang.serialization.Codec;
import endurteam.habirance.world.level.levelgen.feature.configurations.SimpleBlockWithBambooConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.BambooStalkBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BambooLeaves;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class SimpleBlockWithBambooFeature extends Feature<SimpleBlockWithBambooConfiguration>
{
    private static final BlockState BAMBOO_TRUNK = Blocks.BAMBOO.defaultBlockState()
            .setValue(BambooStalkBlock.AGE, 1).setValue(BambooStalkBlock.LEAVES, BambooLeaves.NONE)
            .setValue(BambooStalkBlock.STAGE, 0);
    private static final BlockState BAMBOO_FINAL_LARGE =
            BAMBOO_TRUNK.setValue(BambooStalkBlock.LEAVES, BambooLeaves.LARGE)
                    .setValue(BambooStalkBlock.STAGE, 1);
    private static final BlockState BAMBOO_TOP_LARGE =
            BAMBOO_TRUNK.setValue(BambooStalkBlock.LEAVES, BambooLeaves.LARGE);
    private static final BlockState BAMBOO_TOP_SMALL =
            BAMBOO_TRUNK.setValue(BambooStalkBlock.LEAVES, BambooLeaves.SMALL);

    public SimpleBlockWithBambooFeature(Codec<SimpleBlockWithBambooConfiguration> codec) {
        super(codec);
    }

    /**
     * Places the given feature at the given location.
     * During world generation, features are provided with a 3x3 region of chunks, centered on the chunk being generated,
     * that they can safely generate into.
     * @param context A context object with a reference to the level and the position the feature is being placed at
     */
    public boolean place(FeaturePlaceContext<SimpleBlockWithBambooConfiguration> context) {
        SimpleBlockWithBambooConfiguration configuration = context.config();
        WorldGenLevel worldgenlevel = context.level();
        BlockPos blockpos = context.origin();
        RandomSource randomsource = context.random();
        BlockState blockstate = configuration.toPlace().getState(context.random(), blockpos);
        if (blockstate.canSurvive(worldgenlevel, blockpos) && randomsource.nextFloat() < configuration.probability()) {
            if (blockstate.getBlock() instanceof DoublePlantBlock) {
                if (!worldgenlevel.isEmptyBlock(blockpos.above())) {
                    return false;
                }

                DoublePlantBlock.placeAt(worldgenlevel, blockstate, blockpos, 2);
            } else if (blockstate.getBlock() instanceof BambooStalkBlock) {
                placeBamboo(blockpos, worldgenlevel, randomsource);
            } else {
                if (Direction.stream().noneMatch((dir) -> worldgenlevel.isEmptyBlock(blockpos.relative(dir))))
                {
                    return false;
                }
                worldgenlevel.setBlock(blockpos, blockstate, 2);
            }

            return true;
        } else {
            return false;
        }
    }

    public void placeBamboo(BlockPos blockpos, WorldGenLevel worldgenlevel,
                            RandomSource randomsource) {
        BlockPos.MutableBlockPos blockpos$mutableblockpos = blockpos.mutable();
        int j = randomsource.nextInt(12) + 5;
        for(int l1 = 0; l1 < j && worldgenlevel.isEmptyBlock(blockpos$mutableblockpos); ++l1) {
            worldgenlevel.setBlock(blockpos$mutableblockpos, BAMBOO_TRUNK, 2);
            blockpos$mutableblockpos.move(Direction.UP, 1);
        }

        if (blockpos$mutableblockpos.getY() - blockpos.getY() >= 3) {
            worldgenlevel.setBlock(blockpos$mutableblockpos, BAMBOO_FINAL_LARGE, 2);
            worldgenlevel.setBlock(blockpos$mutableblockpos.move(Direction.DOWN, 1), BAMBOO_TOP_LARGE, 2);
            worldgenlevel.setBlock(blockpos$mutableblockpos.move(Direction.DOWN, 1), BAMBOO_TOP_SMALL, 2);
        }
    }
}