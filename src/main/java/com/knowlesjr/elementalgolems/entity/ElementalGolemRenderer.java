package com.knowlesjr.elementalgolems.entity;

import com.knowlesjr.elementalgolems.ElementalGolems;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.IronGolemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.IronGolem;

public class ElementalGolemRenderer extends IronGolemRenderer {
    public ElementalGolemRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(IronGolem entity) {
        if (entity instanceof ElementalGolemBoss boss) {
            return switch (boss.getElementalType()) {
                case FIRE -> new ResourceLocation(ElementalGolems.MODID, "textures/entity/fire_elemental_golem.png");
                case WATER -> new ResourceLocation(ElementalGolems.MODID, "textures/entity/water_elemental_golem.png");
                case EARTH -> new ResourceLocation(ElementalGolems.MODID, "textures/entity/earth_elemental_golem.png");
                case WIND -> new ResourceLocation(ElementalGolems.MODID, "textures/entity/wind_elemental_golem.png");
                case STORM -> new ResourceLocation(ElementalGolems.MODID, "textures/entity/storm_elemental_golem.png");
            };
        }

        return super.getTextureLocation(entity);
    }
}
