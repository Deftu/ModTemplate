package dev.deftu.modtemplate

//#if FABRIC
import net.fabricmc.api.ModInitializer
//#elseif FORGE
//#if MC >= 1.15.2
//$$ import net.minecraftforge.fml.common.Mod
//$$ import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
//$$ import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
//#else
//$$ import net.minecraftforge.fml.common.Mod
//$$ import net.minecraftforge.fml.common.Mod.EventHandler
//$$ import net.minecraftforge.fml.common.event.FMLInitializationEvent
//#endif
//#elseif NEOFORGE
//$$ import net.neoforged.bus.api.IEventBus
//$$ import net.neoforged.fml.common.Mod
//$$ import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent
//#endif

//#if FORGE-LIKE
//#if MC >= 1.15.2
//$$ @Mod(ModTemplate.ID)
//#else
//$$ @Mod(modid = ModTemplate.ID)
//#endif
//#endif
object ModTemplate
    //#if FABRIC
    : ModInitializer
    //#endif
{

    const val NAME = "@MOD_NAME@"
    const val ID = "@MOD_ID@"
    const val VERSION = "@MOD_VERSION@"

    //#if FORGE && MC >= 1.15.2
    //$$ init {
    //$$     FMLJavaModLoadingContext.get().modEventBus.addListener(this::onClientSetup)
    //$$ }
    //#elseif NEOFORGE
    //$$ constructor(modEventBus: IEventBus) {
    //$$     modEventBus.addListener(this::onClientSetup)
    //$$ }
    //#endif

    //#if FABRIC
    override
    //#endif
    fun onInitialize(
        //#if FORGE-LIKE
        //#if MC >= 1.15.2
        //$$ event: FMLClientSetupEvent
        //#else
        //$$ event: FMLInitializationEvent
        //#endif
        //#endif
    ) {
        // Your common (both client & server) logic goes here...
    }

}
