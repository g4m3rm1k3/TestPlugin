package org.michael.test;

import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            // Set a player's maximum health to 2048
            player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(80);

            player.sendMessage("Your health has been restored by M1k3yMcG4m3r");
            player.setHealth(80);
            player.giveExp(2000);
        }


        return false;
    }
}
