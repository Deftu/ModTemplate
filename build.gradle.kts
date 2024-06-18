import dev.deftu.gradle.utils.MinecraftVersion

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

if (mcData.isForgeLike && mcData.version >= MinecraftVersion.VERSION_1_15_2) {
    toolkitLoomHelper.useKotlinForForge()
}

dependencies {
    modImplementation("dev.deftu:textile-$mcData:0.3.1")
    modImplementation("dev.deftu:omnicore-$mcData:0.5.0")

    if (mcData.isFabric) {
        modImplementation("net.fabricmc.fabric-api:fabric-api:${mcData.dependencies.fabric.fabricApiVersion}")
        modImplementation("net.fabricmc:fabric-language-kotlin:${mcData.dependencies.fabric.fabricLanguageKotlinVersion}")
    }
}
