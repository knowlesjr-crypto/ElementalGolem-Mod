package com.knowlesjr.elementalgolems;

import com.knowlesjr.elementalgolems.registry.ModEntities;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ElementalGolems.MODID)
public class ElementalGolems {
    public static final String MODID = "elementalgolems";

    public ElementalGolems() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModEntities.register(modEventBus);
    }
}
