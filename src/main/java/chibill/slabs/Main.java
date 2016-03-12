package chibill.slabs;


import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import chibill.slabs.slabs.SlabEventHandler;


//Not safe untested

public class Main extends JavaPlugin {

		@Override
	    public void onEnable() {
			Listener SlabEventHandler = new SlabEventHandler();
			getServer().getPluginManager().registerEvents(SlabEventHandler , this);
	    }
	 
	    @Override
	    public void onDisable() {
	        
	    }
	
	    @Override
	    	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    		if(cmd.getName().equalsIgnoreCase("slab") && sender.hasPermission("Slab.slab")){
	    			if((sender instanceof Player)){
	    			ItemStack item = sender.getServer().getPlayer(sender.getName()).getItemInHand();
	    			if(item.getType().equals(Material.STEP) | item.getType().equals(Material.WOOD_STEP) | item.getType().equals(Material.STONE_SLAB2)| item.getType().equals(Material.PURPUR_SLAB)){
	    				sender.getServer().getPlayer(sender.getName()).getInventory().remove(item);
	    				ItemMeta meta = item.getItemMeta();
	    				meta.setDisplayName("Upside down slab");
	    				item.setItemMeta(meta);
	    				sender.getServer().getPlayer(sender.getName()).getInventory().addItem(item);
	    				sender.sendMessage("Your requested slab is now in your hand");
	    			}else{
	    				if(((Player) sender).getGameMode() != GameMode.SURVIVAL){
	    				ItemStack item1 = new ItemStack(Material.STEP);
	    				ItemMeta meta = item1.getItemMeta();
	    				meta.setDisplayName("Upside down slab");
	    				item1.setItemMeta(meta);
	    				sender.getServer().getPlayer(sender.getName()).getInventory().addItem(item1);
	    				sender.sendMessage("Your requested slab has been added inventory.");
	    				}else{
	    					sender.sendMessage("You must have a slab in your hand to get anuUpside down salb in Survival");
	    				}}
	    			}else{
	    				sender.sendMessage("This command can only be ran from ingame.");
	    			}
	    			return true;
	    		}else{
	    			return false;
	    		}
	    	}
	    	
}