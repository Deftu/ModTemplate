import dev.deftu.gradle.utils.MinecraftVersion
import dev.deftu.gradle.utils.includeOrShade

plugins {
    java
    kotlin("jvm")
    id("dev.deftu.gradle.multiversion")
    id("dev.deftu.gradle.tools")
    id("dev.deftu.gradle.tools.resources")
    id("dev.deftu.gradle.tools.bloom")
    id("dev.deftu.gradle.tools.minecraft.loom")
    id("dev.deftu.gradle.tools.minecraft.releases")
}

toolkitLoomHelper {
    if (!mcData.isNeoForge) {
        useMixinRefMap(modData.id)
    }

    if (mcData.isForge) {
        useTweaker("org.spongepowered.asm.launch.MixinTweaker")
        useForgeMixin(modData.id)
    }

    if (mcData.isForgeLike && mcData.version >= MinecraftVersion.VERSION_1_16_5) {
        useKotlinForForge()
    }
}

dependencies {
    modImplementation("dev.deftu:textile-$mcData:0.3.1")
    modImplementation("dev.deftu:omnicore-$mcData:0.5.0")

    if (mcData.isFabric) {
        modImplementation("net.fabricmc.fabric-api:fabric-api:${mcData.dependencies.fabric.fabricApiVersion}")
        modImplementation("net.fabricmc:fabric-language-kotlin:${mcData.dependencies.fabric.fabricLanguageKotlinVersion}")
    } else if (mcData.version <= MinecraftVersion.VERSION_1_12_2) {
        implementation(includeOrShade(kotlin("stdlib-jdk8"))!!)
        implementation(includeOrShade("org.jetbrains.kotlin:kotlin-reflect:1.6.10")!!)

        modImplementation(includeOrShade("org.spongepowered:mixin:0.7.11-SNAPSHOT")!!)
    }
}

tasks {
    withType<Jar> {
        val buildDir = rootProject.layout.buildDirectory.asFile.get()
        val jarsDir = buildDir.resolve("jars")
        destinationDirectory.set(jarsDir)
    }
}
