package chibill.slabs;


import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import chibill.slabs.slabs.SlabEventHandler;

public class Main extends JavaPlugin {

	Logger logger = this.getLogger();
	@Override
	public void onEnable() {
		Material[] Slabs = FindSlabs();
		SlabEventHandler handler = new SlabEventHandler(Slabs);
		this.getServer().getPluginManager().registerEvents(handler , this);
	}

	@Override
	public void onDisable() {
	
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("slab") && (sender instanceof Player)){
			
			return true;
		}else{
			return false;
		}
	}

	@SuppressWarnings("deprecation")
	private Material[] FindSlabs(){
		Material[] Out = new Material[10];
		int x = 0;
		Material[] Enum = Material.STEP.getDeclaringClass().getEnumConstants();
		for(int temp = 0; temp < (Enum.length-1); temp++ ){
			Material mat = Enum[temp];
			try{
				mat.getNewData((byte)0).getClass().getMethod("isInverted", null);
				try{
					mat.getNewData((byte)0).getClass().getMethod("getFacing", null);
				}catch(Exception e){
					Out[x] = mat;
					x++;
					logger.log(Level.FINER,mat.name() +" Is a Slab");
				}
			}catch(Exception e){
				logger.log(Level.FINER,mat.name() +" Is not a Slab");
			}
		}
		return Out;
	}

}
