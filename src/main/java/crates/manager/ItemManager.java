package crates.manager;

import crates.crate.item.CrateItem;
import crates.crate.type.Rarity;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import crates.util.ItemBuilder;
import crates.Main;
import crates.util.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Enrique on 14-7-2019.
 * No part of this publication may be reproduced, distributed, or transmitted in any form or by any means.
 * Copyright © 2019 by Enrique
 */
public class ItemManager {

    /*
    crates:
    vote:
     '1':
      name: "&6&lBag of Coins &8\u279F &fRight Click"
      lore:
      -
      -
      -
      -
      amount: 1
      material: "skull_item"
      skullowner: ""
      chance: 10.0
      commands:
      - "/kitpvp coins bag {name} 50"
     */

    private HashMap<Rarity, List<CrateItem>> cahcedCrates = new HashMap<>();

    public void loadItems() {
        if (Main.getInstance().getFileConfiguration().getConfigurationSection("items") == null) return;
        for (String s : Main.getInstance().getFileConfiguration().getConfigurationSection("items").getKeys(false)) {
            String path = "items." + s;
            for (String a : Main.getInstance().getFileConfiguration().getConfigurationSection(path).getKeys(false)) {
                int id = Integer.parseInt(a);
                String name = Main.getInstance().getFileConfiguration().getString(path + "." + a + ".name");
                System.out.println(name);
                List<String> list = Main.getInstance().getFileConfiguration().getStringList(path + "." + a + ".lore");
                list = color(list);
                System.out.println(list);
                Rarity rarity = Rarity.valueOf(s.toUpperCase());
                System.out.println(rarity);
                String[] lore = list.toArray(new String[0]);
                CrateItem item = new CrateItem(
                        id, rarity, name, lore,
                        Main.getInstance().getFileConfiguration().getInt(path + "." + a + ".amount"),
                        Material.matchMaterial(Main.getInstance().getFileConfiguration().getString(path + "." + a + ".material").toUpperCase()),
                        Main.getInstance().getFileConfiguration().getDouble(path + "." + a + ".chance"),
                        Main.getInstance().getFileConfiguration().getBoolean(path + "." + a + ".glow", false),
                        Main.getInstance().getFileConfiguration().getString(path + "." + a + ".skullowner", ""),
                        Main.getInstance().getFileConfiguration().getStringList(path + "." + a + ".commands"),
                        Main.getInstance().getFileConfiguration().getStringList(path + "." + a + ".enchants"),
                        Main.getInstance().getFileConfiguration().getInt(path + "." + a + ".byte"));
                System.out.println(item);
                ItemBuilder itemStack = new ItemBuilder(item.getMaterial(), item.getAmount());
                itemStack.setDurability((byte) Main.getInstance().getFileConfiguration().getInt(path + "." + a + ".byte"));
                itemStack.setName(item.getName());
                itemStack.setLore(item.getLore());
                for (String ench : Main.getInstance().getFileConfiguration().getStringList(path + "." + a + ".enchants")) {
                    String[] enchant = ench.split(" ");
                    itemStack.addEnchant(Enchantment.getByName(enchant[0]), Integer.parseInt(enchant[1]));
                }
                item.setStack(itemStack.toItemStack());
                cahcedCrates.putIfAbsent(rarity, new ArrayList<>());
                cahcedCrates.get(rarity).add(item);
                System.out.println("Added new item");
                System.out.println(cahcedCrates.values());
            }
        }
    }


    private List<String> color(List<String> lore) {
        List<String> clore = new ArrayList<>();
        for (String s : lore) {
            clore.add(Utils.color(s));
        }
        return clore;
    }
}
