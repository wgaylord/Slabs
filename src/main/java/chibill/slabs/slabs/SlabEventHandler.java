package chibill.slabs.slabs;

import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import chibill.slabs.Main;

public class SlabEventHandler  implements Listener {


	
	public SlabEventHandler() {
		
	}

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event){
		if(Main.isSlab(event.getBlockPlaced().getState().getData())){
			if((event.getItemInHand().getEnchantmentLevel(Enchantment.DURABILITY)==1) && (event.getItemInHand().getItemMeta().getDisplayName() == "Upside down slab")){
				SetInverted(event.getBlockPlaced());
			}
		}
		
	}
	
	public void SetInverted(Block b){
		int dat = b.getData() & 0x7;
		dat |= 8;
		b.setData((byte) dat);
	}
	
}
