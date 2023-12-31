package org.michael.test;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PermissionsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            if(player.hasPermission("testPlugin.use")){
                player.sendMessage(ChatColor.GREEN + "You have permission to use this");
            }else{
                player.sendMessage(ChatColor.RED +  "you don't have permission to use this");
            }
        }


        return false;
    }
}
