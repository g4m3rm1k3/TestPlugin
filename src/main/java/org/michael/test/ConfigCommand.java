package org.michael.test;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Objects;

public class ConfigCommand implements CommandExecutor {

    private TestPlugin main;
    public ConfigCommand(TestPlugin main){
        this.main = main;
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            player.sendMessage(Objects.requireNonNull(main.getConfig().getString("Word")));
            player.sendMessage(main.getConfig().getInt("Number") + "");
            if(main.getConfig().getBoolean("Boolean")){
                player.sendMessage("This feature is enabled");
            }
            for (String string : main.getConfig().getStringList("String-list")){
                player.sendMessage(string);
            }
            if (strings.length == 1) {
                main.getConfig().set("Word", strings[0]);
                main.saveConfig();

            }
            if(strings.length == 2 ){
                main.getConfig().set("Word", strings[0]);

                List<String> list = main.getConfig().getStringList("String-list");
                list.add(strings[1]);
                main.getConfig().set("String-list", list);
                main.saveConfig();

            }

        }
        return false;
    }
}
