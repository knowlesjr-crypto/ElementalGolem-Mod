package com.knowlesjr.elementalgolems.event;

import com.knowlesjr.elementalgolems.ElementalGolems;
import com.knowlesjr.elementalgolems.entity.ElementalGolemRenderer;
import com.knowlesjr.elementalgolems.registry.ModEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ElementalGolems.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.ELEMENTAL_GOLEM.get(), ElementalGolemRenderer::new);
    }
}
