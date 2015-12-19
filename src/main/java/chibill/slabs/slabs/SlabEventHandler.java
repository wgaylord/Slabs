package chibill.slabs.slabs;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class SlabEventHandler  implements Listener {

	Material[] Slabs;
	
	public SlabEventHandler(Material[] slabs){
		Slabs = slabs;
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event){
		
	}
	
}
