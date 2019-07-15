package crates;

import crates.command.CmdCrate;
import crates.crate.event.CrateListener;
import crates.manager.ItemManager;
import crates.manager.LocationManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

/**
 * Created by Enrique on 14-7-2019.
 * No part of this publication may be reproduced, distributed, or transmitted in any form or by any means.
 * Copyright © 2019 by Enrique
 */
public class Main extends JavaPlugin {

    public static Main instance;

    private ItemManager itemManager;
    private LocationManager locationManager;
    private File itemYml;
    private FileConfiguration fileConfiguration;

    @Override
    public void onEnable() {
        instance = this;
        itemManager = new ItemManager();
        locationManager = new LocationManager();
        saveDefaultConfig();
        if(!this.getDataFolder().exists()) {
            this.getDataFolder().mkdir();
        }
        itemYml = new File(getDataFolder(), "crateitems.yml");
        if (!itemYml.exists()) {
            try {
                itemYml.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        fileConfiguration = YamlConfiguration.loadConfiguration(itemYml);
        load();
        this.getCommand("crates").setExecutor(new CmdCrate());
        this.getServer().getPluginManager().registerEvents(new CrateListener(), this);
    }

    public void onDisable() {
        save();
    }

    public void load() {
        getItemManager().loadItems();
        getLocationManager().loadLocations();
    }

    public void save() {
        getLocationManager().saveLocations();
    }

    public LocationManager getLocationManager() {
        return locationManager;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }

    public File getItemYml() {
        return itemYml;
    }

    public FileConfiguration getFileConfiguration() {
        return fileConfiguration;
    }

    public static Main getInstance() {
        return instance;
    }
}
