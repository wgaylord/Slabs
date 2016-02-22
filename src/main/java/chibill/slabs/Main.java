package chibill.slabs;


import java.util.logging.Logger;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.java.JavaPlugin;

import chibill.slabs.slabs.SlabEventHandler;

public class Main extends JavaPlugin {

	Logger logger = this.getLogger();
	@Override
	public void onEnable() {
		SlabEventHandler handler = new SlabEventHandler();
		this.getServer().getPluginManager().registerEvents(handler , this);
	}

	@Override
	public void onDisable() {
	
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("slab") && sender.hasPermission("Slab.slab")){
			if((sender instanceof Player)){
			ItemStack item = sender.getServer().getPlayer(sender.getName()).getItemInHand();
			if(isSlab(item.getData())){
				sender.getServer().getPlayer(sender.getName()).getInventory().remove(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("Upside down slab");
				meta.addEnchant(Enchantment.DURABILITY, 1, false);
				item.setItemMeta(meta);
				sender.getServer().getPlayer(sender.getName()).getInventory().addItem(item);
				sender.sendMessage("Your requested slab is now in your hand");
			}else{
				if(((Player) sender).getGameMode() != GameMode.SURVIVAL){
				ItemStack item1 = new ItemStack(Material.STEP);
				ItemMeta meta = item1.getItemMeta();
				meta.setDisplayName("Upside down slab");
				meta.addEnchant(Enchantment.DURABILITY, 1, false);
				item1.setItemMeta(meta);
				sender.getServer().getPlayer(sender.getName()).getInventory().addItem(item1);
				sender.sendMessage("Your requested slab has been added inventory.");
				}else{
					sender.sendMessage("You must have a slab in your hand to get an Upside DOwn salb in Survival");
				}}
			}else{
				sender.sendMessage("This command can only be ran from ingame.");
			}
			return true;
		}else{
			return false;
		}
	}

	public static boolean isSlab(MaterialData mat){
			try{
				mat.getClass().getMethod("isInverted", null);
				try{
					mat.getClass().getMethod("getFacing", null);
				}catch(Exception e){
					
					return true;
				}
			}catch(Exception e){
				
			}
		return false;
	}

}
