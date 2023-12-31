package org.michael.test;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class TestCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {


        if(commandSender instanceof Player){
            // if first arguments is euqal to 'hello' then we'll send hello back
            if(args.length > 0){
                Player player = (Player) commandSender;
                if (args[0].equalsIgnoreCase("hello")){
                    ((Player) commandSender).sendMessage("Hello my friend");
                    ItemStack netheriteHelmet = createEnchantedItem(Material.NETHERITE_HELMET);
                    ItemStack netheriteChestplate = createEnchantedItem(Material.NETHERITE_CHESTPLATE);
                    ItemStack netheriteLeggings = createEnchantedItem(Material.NETHERITE_LEGGINGS);
                    ItemStack netheriteBoots = createEnchantedItem(Material.NETHERITE_BOOTS);
                    ItemStack netheriteSword = createEnchantedItem(Material.NETHERITE_SWORD);
                    ItemStack netheritePickaxe = createEnchantedItem(Material.NETHERITE_PICKAXE);
                    ItemStack netheriteAxe = createEnchantedItem(Material.NETHERITE_AXE);

                    player.getInventory().addItem((netheriteSword));
                    player.getInventory().addItem(netheriteBoots);
                    player.getInventory().addItem(netheriteHelmet);
                    player.getInventory().addItem(netheriteChestplate);
                    player.getInventory().addItem(netheriteLeggings);
                    player.getInventory().addItem(netheriteAxe);
                    player.getInventory().addItem(netheritePickaxe);

//                    player.getInventory().addItem(netheriteHelmet, netheriteChestplate, netheriteLeggings, netheriteBoots);

                }
            }
        }else{
            System.out.println("Hello, you have messaged the console");
        }
        return false;
    }
    private ItemStack createEnchantedItem(Material material) {
        ItemStack item = new ItemStack(material);
        item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 400);
        item.addUnsafeEnchantment(Enchantment.THORNS, 200);
        // Add more enchantments as needed

        // Add specific enchantments for the Netherite sword
        if (material == Material.NETHERITE_SWORD) {
            item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 500); // Sharpness V
        }

        // Add specific enchantments for the Netherite pickaxe
        if (material == Material.NETHERITE_PICKAXE) {
            item.addUnsafeEnchantment(Enchantment.DIG_SPEED, 500); // Efficiency V
            item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 300); // Fortune III
        }

        // Add specific enchantments for the Netherite axe
        if (material == Material.NETHERITE_AXE) {
            item.addUnsafeEnchantment(Enchantment.DIG_SPEED, 500); // Efficiency V
            item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 300); // Sharpness III (Axes can have this enchantment, but it affects attack damage, not block breaking)
            item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 300); // Fortune III
        }

        return item;
    }

}
