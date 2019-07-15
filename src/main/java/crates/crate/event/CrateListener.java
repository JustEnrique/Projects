package crates.crate.event;

import crates.Main;
import crates.crate.type.Rarity;
import net.minecraft.server.v1_12_R1.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_12_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Enrique on 15-7-2019.
 * No part of this publication may be reproduced, distributed, or transmitted in any form or by any means.
 * Copyright © 2019 by Enrique
 */
public class CrateListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            for(Location location : Main.getInstance().getLocationManager().getCrateLocations().values()) {
                if (event.getClickedBlock().getLocation().equals(location)) {
                    Bukkit.getPluginManager().callEvent(new CrateOpenEvent(player, Main.getInstance().getLocationManager().getKey(event.getClickedBlock().getLocation())));
                    break;
                }
            }
        }
    }


    @EventHandler
    public void onCrateOpen(CrateOpenEvent e) {
        Player p = e.getPlayer();
        Rarity rarity = e.getRarity();
        Location loc = Main.getInstance().getLocationManager().getCrateLocations().get(rarity);

        EntityItem item = new EntityItem(((CraftWorld) loc.getWorld()).getHandle());
        item.setLocation(loc.getX(), loc.getY(), loc.getZ(), 0, 0);
        item.setItemStack(CraftItemStack.asNMSCopy(new ItemStack(Material.LEATHER_HELMET, 1)));

        PacketPlayOutSpawnEntity spawnItem = new PacketPlayOutSpawnEntity(item, 2, 100);
        PacketPlayOutEntityMetadata data = new PacketPlayOutEntityMetadata(item.getId(), item.getDataWatcher(), true);

        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(spawnItem);
        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(data);
    }
}
