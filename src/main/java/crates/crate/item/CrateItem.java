package crates.crate.item;

import crates.crate.type.Rarity;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.List;

/**
 * Created by Enrique on 14-7-2019.
 * No part of this publication may be reproduced, distributed, or transmitted in any form or by any means.
 * Copyright © 2019 by Enrique
 */
public class CrateItem {

    private final int id;
    private final Rarity rarity;
    private final String name;
    private final String[] lore;
    private final int amount;
    private final Material material;
    private final double chance;
    private final boolean glow;
    private final String skullOwner;
    private ItemStack stack;
    private final List<String> commands;
    private final List<String> enchants;
    private final int durabilityByte;

    public CrateItem(int id, Rarity rarity, String name, String[] lore, int amount, Material material, double chance, boolean glow, String skullOwner, ItemStack stack, List<String> commands, List<String> enchants, int durabilityByte) {
        this.id = id;
        this.rarity = rarity;
        this.name = name;
        this.lore = lore;
        this.amount = amount;
        this.material = material;
        this.chance = chance;
        this.glow = glow;
        this.skullOwner = skullOwner;
        this.stack = stack;
        this.commands = commands;
        this.enchants = enchants;
        this.durabilityByte = durabilityByte;
    }

    public CrateItem(int id, Rarity rarity, String name, String[] lore, int amount, Material material, double chance, boolean glow, String skullOwner, List<String> commands, List<String> enchants, int durabilityByte) {
        this.id = id;
        this.rarity = rarity;
        this.name = name;
        this.lore = lore;
        this.amount = amount;
        this.material = material;
        this.chance = chance;
        this.glow = glow;
        this.skullOwner = skullOwner;
        this.commands = commands;
        this.enchants = enchants;
        this.durabilityByte = durabilityByte;
    }

    public int getId() {
        return id;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public String getName() {
        return name;
    }

    public String[] getLore() {
        return lore;
    }

    public int getAmount() {
        return amount;
    }

    public Material getMaterial() {
        return material;
    }

    public double getChance() {
        return chance;
    }

    public boolean isGlow() {
        return glow;
    }

    public String getSkullOwner() {
        return skullOwner;
    }

    public ItemStack getStack() {
        return stack;
    }

    public List<String> getCommands() {
        return commands;
    }

    public List<String> getEnchants() {
        return enchants;
    }

    public int getDurabilityByte() {
        return durabilityByte;
    }

    public void setStack(ItemStack stack) {
        this.stack = stack;
    }
}
