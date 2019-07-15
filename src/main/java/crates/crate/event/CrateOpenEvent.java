package crates.crate.event;

import crates.crate.type.Rarity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Created by Enrique on 15-7-2019.
 * No part of this publication may be reproduced, distributed, or transmitted in any form or by any means.
 * Copyright © 2019 by Enrique
 */
public class CrateOpenEvent extends Event {

    private Player player;
    private Rarity rarity;

    public CrateOpenEvent(Player player, Rarity rarity) {
        this.player = player;
        this.rarity = rarity;
    }

    private static final HandlerList handlers = new HandlerList();

    public HandlerList getHandlers() {
        return handlers;
    }

    public Player getPlayer() {
        return player;
    }

    public Rarity getRarity() {
        return rarity;
    }
}
