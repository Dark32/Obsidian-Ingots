package net.uberkat.obsidian.common;

import net.minecraft.src.Block;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

/**
 * Item class for handling multiple machine block IDs.
 * 0: Enrichment Chamber
 * 1: Platinum Compressor
 * 2: Combiner
 * 3: Crusher
 * 4: Theoretical Elementizer
 * @author AidanBrady
 *
 */
public class ItemMachine extends ItemBlock
{
	public Block metaBlock;
	
	public ItemMachine(int id, Block block)
	{
		super(id);
		metaBlock = block;
		setHasSubtypes(true);
	}
	
	public int getMetadata(int i)
	{
		return i;
	}
	
	public int getIconFromDamage(int i)
	{
		return metaBlock.getBlockTextureFromSideAndMetadata(2, i);
	}
	
	public String getItemNameIS(ItemStack itemstack)
	{
		String name = "";
		switch(itemstack.getItemDamage())
		{
			case 0:
				name = "EnrichmentChamber";
				break;
			case 1:
				name = "PlatinumCompressor";
				break;
			case 2:
				name = "Combiner";
				break;
			case 3:
				name = "Crusher";
				break;
			case 4:
				name = "TheoreticalElementizer";
				break;
			default:
				name = "Unknown";
				break;
		}
		return getItemName() + "." + name;
	}
}
