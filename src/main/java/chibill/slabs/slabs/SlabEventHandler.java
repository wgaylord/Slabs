package chibill.slabs.slabs;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class SlabEventHandler  implements Listener {
	
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event){
		try{
		if(event.getBlock().getType().equals(Material.STEP) | event.getBlock().getType().equals(Material.WOOD_STEP) | event.getBlock().getType().equals(Material.STONE_SLAB2)| event.getBlock().getType().equals(Material.PURPUR_SLAB)){
			
			if((event.getItemInHand().getItemMeta().getDisplayName().hashCode() == "Upside down slab".hashCode())){
				if(event.getBlockReplacedState().getType() != event.getBlockPlaced().getType()){
				event.getBlock().getState().getBlock().setData((byte)(event.getItemInHand().getData().getData()+ 8));
			}}
		}catch(Exception e){}
		
	}
	
}
