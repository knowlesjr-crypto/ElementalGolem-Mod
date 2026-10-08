package com.knowlesjr.elementalgolems.entity;

public enum ElementalType {
    FIRE(0xFF6B2C, "fire"),
    WATER(0x3FB4FF, "water"),
    EARTH(0x7A5B2B, "earth"),
    WIND(0xA8F0FF, "wind"),
    STORM(0xA36DFF, "storm");

    private final int color;
    private final String key;

    ElementalType(int color, String key) {
        this.color = color;
        this.key = key;
    }

    public int getColor() {
        return color;
    }

    public String getKey() {
        return key;
    }
}
