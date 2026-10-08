package com.knowlesjr.elementalgolems.registry;

import com.knowlesjr.elementalgolems.ElementalGolems;
import com.knowlesjr.elementalgolems.entity.ElementalGolemBoss;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ElementalGolems.MODID);

    public static final RegistryObject<EntityType<ElementalGolemBoss>> ELEMENTAL_GOLEM = ENTITY_TYPES.register(
            "elemental_golem",
            () -> EntityType.Builder.<ElementalGolemBoss>of(ElementalGolemBoss::new, MobCategory.MONSTER)
                    .sized(2.2F, 3.4F)
                    .fireImmune()
                    .build("elemental_golem")
    );

    public static void register(IEventBus modEventBus) {
        ENTITY_TYPES.register(modEventBus);
    }
}
