package chibill.slabs;


import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import chibill.slabs.SlabEventHandler;


//Not safe untested

public class Main extends JavaPlugin {

	public static ItemStack item;
	public static ItemMeta meta;
		@Override
	    public void onEnable() {
			item = new ItemStack(Material.STEP);
			meta = item.getItemMeta();
			meta.setDisplayName("Upside Down Half Slab");
			Listener SlabEventHandler = new SlabEventHandler();
			getServer().getPluginManager().registerEvents(SlabEventHandler , this);
	    }
	 
	    @Override
	    public void onDisable() {
	        
	    }
	
	    @Override
	    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    	
	    	if(cmd.getName().equalsIgnoreCase("slab") && (sender instanceof Player)){
	    		ItemStack item = sender.getServer().getPlayer(sender.getName()).getItemInHand();
	    		if(item.getType().equals(Material.STEP) | item.getType().equals(Material.WOOD_STEP) | item.getType().equals(Material.STONE_SLAB2)){
	    		sender.getServer().getPlayer(sender.getName()).setItemInHand(item);}else{
	    			sender.getServer().getPlayer(sender.getName()).setItemInHand(this.item);
	    		}
	    		sender.getServer().getPlayer(sender.getName()).getItemInHand().setItemMeta(meta);
	    	
	    		return true;
	    	}return false;
	    	
	    }
	    
}
