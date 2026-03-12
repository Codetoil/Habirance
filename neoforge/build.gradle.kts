plugins {
	`multiloader-loader`
	id("net.neoforged.moddev")
}

repositories {
	mavenCentral()
	maven("https://maven.fabricmc.net/") { name = "FabricMC" }
	maven("https://dl.cloudsmith.io/public/geckolib3/geckolib/maven/")
	maven("https://maven.terraformersmc.com/releases/")
	maven("https://maven.ryanliptak.com/")
	maven("https://maven.shedaniel.me/")
	maven("https://maven.minecraftforge.net/")
}

neoForge {
	enable {
		version = commonMod.prop("neoforge_version")
	}
}

dependencies {
	implementation("com.github.glitchfiend:TerraBlender-neoforge:${commonMod.minecraft_version}-${commonMod.prop("terrablender_version")}")

	implementation("software.bernie.geckolib:geckolib-neoforge-${commonMod.minecraft_version}:${commonMod.prop("geckolib_version")}")
	if (stonecutter.eval(stonecutter.current.version, ">=1.21.5"))
	{
		interfaceInjectionData("software.bernie.geckolib:geckolib-neoforge-${commonMod.minecraft_version}:${commonMod.prop("geckolib_version")}")
	}

	runtimeOnly("squeek.appleskin:appleskin-neoforge:${commonMod.prop("appleskin_version_neoforge")}") {
		exclude("modmenu")
	}

	jarJar("net.fabricmc:sponge-mixin:${commonMod.prop("fabric_mixin_version")}") {
		version {
			strictly("[${commonMod.prop("fabric_mixin_version")},)")
			prefer(commonMod.prop("fabric_mixin_version"))
		}
	}
	jarJar("io.github.llamalad7:mixinextras-neoforge:${commonMod.prop("mixinextras_version")}") {
		version {
			strictly("[${commonMod.prop("mixinextras_version")},)")
			prefer(commonMod.prop("mixinextras_version"))
		}
	}
}

neoForge {
	val at = project.file("build/resources/main/META-INF/accesstransformer.cfg");

	accessTransformers.from(at.absolutePath)
	validateAccessTransformers = true

	runs {
		register("client") {
			client()
			ideName = "NeoForge Client (${project.path})"
		}
		if (stonecutter.eval(stonecutter.current.version, ">=1.21.4")) {
			register("clientData") {
				clientData()
				ideName = "NeoForge Client Data (${project.path})"
			}
			register("serverData") {
				serverData()
				ideName = "NeoForge Server Data (${project.path})"
			}
		} else {
			register("data") {
				data()
				ideName = "NeoForge Data (${project.path})"
			}
		}
		register("server") {
			server()
			ideName = "NeoForge Server (${project.path})"
		}
	}

	parchment {
		commonMod.propOrNull("parchment_mappings")?.let {
			mappingsVersion = it
			minecraftVersion = if (it != "") commonMod.minecraft_version else ""
		}
	}

	mods {
		register(commonMod.id) {
			sourceSet(sourceSets.main.get())
		}
	}
}

sourceSets.main {
	resources.srcDir("src/generated/resources")
}

tasks {
	processResources {
		exclude("${mod.id}.accesswidener")

		val atFile = project(":common").file("src/main/resources/accesstransformers/accesstransformer-${commonMod.minecraft_version}.cfg")

		from(atFile.parentFile) {
			include(atFile.name)
			rename(atFile.name, "META-INF/accesstransformer.cfg")
			into("")
		}
	}
}

tasks.named("createMinecraftArtifacts") {
	dependsOn(":neoforge:${commonMod.propOrNull("minecraft_version")}:processResources")
}