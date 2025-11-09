package dev.deftu.modtemplate.mixins.client;

import dev.deftu.modtemplate.ModTemplateConstants;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class Mixin_ExampleInjection {
    @Inject(method = "<init>", at = @At("RETURN"))
    private void modtemplate$hello(CallbackInfo ci) {
        System.out.println("Hello " + ModTemplateConstants.NAME + "!");
    }
}
