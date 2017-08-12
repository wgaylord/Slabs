package chibill.slabs;


import java.util.logging.Logger;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
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
		if(cmd.getName().equalsIgnoreCase("slab-version")){
			sender.sendMessage("Slabs by Chibill");
			sender.sendMessage("Version: "+this.getDescription().getVersion());
		}
		if(cmd.getName().equalsIgnoreCase("slab")){
			if((sender instanceof Player)){
			ItemStack item = ((Player) sender).getItemInHand();
			if(isSlab(item.getData())){
				((Player) sender).getInventory().remove(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("Upside Down Slab");
				meta.addEnchant(Enchantment.DURABILITY, 1, false);
				item.setItemMeta(meta);
				((Player) sender).getInventory().addItem(item);
				sender.sendMessage("Your requested slab is now in your hand");
			}else{
				if(((Player) sender).getGameMode() != GameMode.SURVIVAL){
				ItemStack item1 = new ItemStack(Material.STEP);
				ItemMeta meta = item1.getItemMeta();
				meta.setDisplayName("Upside Down Slab");
				meta.addEnchant(Enchantment.DURABILITY, 1, false);
				item1.setItemMeta(meta);
				((Player) sender).getInventory().addItem(item1);
				sender.sendMessage("Your requested slab has been added inventory.");
				}else{if(sender.hasPermission("Slab.survival")){
					sender.sendMessage("You must have a slab in your hand to get an Upside Down salb in Survival");
				}}}
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
				mat.getClass().getMethod("isInverted", null); //Finds slabs and stairs
				try{
					mat.getClass().getMethod("getFacing", null); //weeds the stairs out
				}catch(NoSuchMethodException e){
					//System.out.println(e.getMessage());
					// Tells us it is slab and not a stair
					return true;
				}
			}catch(NoSuchMethodException e){
				//System.out.println(e.getMessage());
			}
		return false;
	}

}
