package crates.manager;

import crates.Main;
import crates.crate.type.Rarity;
import crates.util.LocationSerializer;
import org.bukkit.Location;

import java.util.HashMap;

/**
 * Created by Enrique on 15-7-2019.
 * No part of this publication may be reproduced, distributed, or transmitted in any form or by any means.
 * Copyright © 2019 by Enrique
 */
public class LocationManager {

    private HashMap<Rarity, Location> crateLocations = new HashMap<>();

    public void loadLocations() {
        for(String s : Main.getInstance().getConfig().getConfigurationSection("locations").getKeys(false)) {
            this.crateLocations.put(Rarity.valueOf(s), LocationSerializer.deserialize(Main.getInstance().getConfig().getString(s)));
        }
    }

    public void saveLocations() {
        Main.getInstance().getConfig().set("locations.", null);
        for(Rarity rarity : this.crateLocations.keySet()) {
            Main.getInstance().getConfig().set("locations." + rarity.toString().toUpperCase(), LocationSerializer.serialize(this.crateLocations.get(rarity)) );
        }
        Main.getInstance().saveConfig();
    }

    public HashMap<Rarity, Location> getCrateLocations() {
        return crateLocations;
    }

    public Rarity getKey(Location location) {
        for(Rarity rarity : this.crateLocations.keySet()) {
            if(location.equals(this.crateLocations.get(rarity))) {
                return rarity;
            }
        }
        return null;
    }
}
