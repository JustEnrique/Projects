package crates.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import crates.Main;
import crates.util.Utils;

/**
 * Created by Enrique on 14-7-2019.
 * No part of this publication may be reproduced, distributed, or transmitted in any form or by any means.
 * Copyright © 2019 by Enrique
 */

public class CmdCrate implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length != 1) {
            if (!(sender instanceof Player) || sender.isOp()) {
                sender.sendMessage(Utils.color("&c&l✖ Oeps! &7Dat is geen geldige crates.command, gebruik /crates reload om de file te reloaden."));
                return true;
            }
            sender.sendMessage(Utils.color("&c&l✖ Oeps! &7Dat is geen geldige crates.command."));
            return true;
        }
        if (args[0].equalsIgnoreCase("reload")) {
            YamlConfiguration.loadConfiguration(Main.getInstance().getItemYml());
            sender.sendMessage(Utils.color("a✔Gelukt! &7File gereload."));
        }
        return false;
    }
}
