package chibill.slabs;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class SlabEventHandler  implements Listener {

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event){
		try{
		if(event.canBuild() && !(event.getBlock().getType().equals(Material.STEP) && event.getBlock().getState().getBlock().getData() == (byte)8)){
			
			if(event.getItemInHand().getItemMeta().getDisplayName().equals("Upside Down Half Slab") && event.getItemInHand().getType().equals(Material.STEP)){
				event.getBlock().getState().getBlock().setType(Material.STEP);
				event.getBlock().getState().getBlock().setData((byte)(event.getItemInHand().getData().getData()+ 8));
			}
			
		}
		if(event.canBuild() && !(event.getBlock().getType().equals(Material.WOOD_STEP) && event.getBlock().getState().getBlock().getData() == (byte)8)){
			
			if(event.getItemInHand().getItemMeta().getDisplayName().equals("Upside Down Half Slab") && event.getItemInHand().getType().equals(Material.WOOD_STEP)){
				event.getBlock().getState().getBlock().setType(Material.WOOD_STEP);
				event.getBlock().getState().getBlock().setData((byte)(event.getItemInHand().getData().getData()+ 8));
			}
			
		}
		if(event.canBuild() && !(event.getBlock().getType().equals(Material.STONE_SLAB2) && event.getBlock().getState().getBlock().getData() == (byte)8)){
			
			if(event.getItemInHand().getItemMeta().getDisplayName().equals("Upside Down Half Slab") && event.getItemInHand().getType().equals(Material.STONE_SLAB2)){
				event.getBlock().getState().getBlock().setType(Material.STONE_SLAB2);
				event.getBlock().getState().getBlock().setData((byte)(event.getItemInHand().getData().getData()+ 8));
			}
			
		}
		}catch(Exception e){
			
		}
	}
	
}
