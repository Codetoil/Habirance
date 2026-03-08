plugins {
	`multiloader-loader`
	id("org.quiltmc.loom")
}

repositories {
	maven("https://libraries.minecraft.net") { name = "Mojang" }
	mavenCentral()
	exclusiveContent {
		forRepositories(
			maven("https://maven.parchmentmc.org") { name = "ParchmentMC" }
		)
		filter { includeGroup("org.parchmentmc.data") }
	}
	maven("https://maven.quiltmc.org/repository/release/") { name = "QuiltMC" }
	maven("https://maven.fabricmc.net/") { name = "FabricMC" }
	maven("https://dl.cloudsmith.io/public/geckolib3/geckolib/maven/")
	maven("https://maven.terraformersmc.com/releases/")
	maven("https://maven.ryanliptak.com/")
	maven("https://maven.shedaniel.me/")
	maven("https://maven.minecraftforge.net/")
}

dependencies {
	minecraft("com.mojang:minecraft:${commonMod.minecraft_version}")
	mappings(loom.layered {
		officialMojangMappings()
		commonMod.propOrNull("parchment_mappings")?.let { parchmentVersion ->
			if (parchmentVersion != "") parchment("org.parchmentmc.data:parchment-${commonMod.minecraft_version}:$parchmentVersion@zip")
		}
	})

	modImplementation("net.fabricmc:fabric-loader:${commonMod.prop("fabric_loader_version")}")
	modApi("net.fabricmc.fabric-api:fabric-api:${commonMod.prop("fabric_api_version")}")

	modImplementation("com.github.glitchfiend:TerraBlender-fabric:${commonMod.minecraft_version}-${commonMod.prop("terrablender_version")}")

	if (stonecutter.eval(stonecutter.current.version, ">=1.20.6")) {
		modImplementation("software.bernie.geckolib:geckolib-fabric-${commonMod.minecraft_version}:${commonMod.prop("geckolib_version")}")
	} else {
		modImplementation("software.bernie.geckolib:geckolib-fabric-${commonMod.minecraft_version}:${commonMod.prop("geckolib_version")}")
		implementation("com.eliotlash.mclib:mclib:20")
	}

	modRuntimeOnly("squeek.appleskin:appleskin-fabric:${commonMod.prop("appleskin_version_fabric")}") {
		exclude("modmenu")
	}

	include("net.fabricmc:sponge-mixin:${commonMod.prop("fabric_mixin_version")}")
	annotationProcessor("io.github.llamalad7:mixinextras-fabric:${commonMod.prop("mixinextras_version")}")
	include("io.github.llamalad7:mixinextras-fabric:${commonMod.prop("mixinextras_version")}")
}

loom {
	accessWidenerPath =
		common.project.file("../../src/main/resources/accesswideners/${commonMod.minecraft_version}-${mod.id}.accesswidener")

	runs {
		getByName("client") {
			client()
			configName = "Fabric Client"
			ideConfigGenerated(true)
		}
		getByName("server") {
			server()
			configName = "Fabric Server"
			ideConfigGenerated(true)
		}
	}
}

fabricApi {
	configureDataGeneration() {
		client = true
	}
}

tasks.named<ProcessResources>("processResources") {
	val awFile = project(":common").file("src/main/resources/accesswideners/${commonMod.minecraft_version}-${mod.id}.accesswidener")

	from(awFile.parentFile) {
		include(awFile.name)
		rename(awFile.name, "${mod.id}.accesswidener")
		into("")
	}
}