package crates.crate.event;

import crates.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

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

    }
}
