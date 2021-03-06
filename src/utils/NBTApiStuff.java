package utils;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTCompoundList;
import de.tr7zw.nbtapi.NBTEntity;
import de.tr7zw.nbtapi.NBTItem;
import de.tr7zw.nbtapi.NBTListCompound;
import enums.Msg;
import main.fListener;

public class NBTApiStuff {
	
	public static ItemStack checkTimestampLegacy(ItemStack item) {
		
		//Old backwards compatiable version
		NBTItem nbti = new NBTItem(item);



			if(System.currentTimeMillis() >= nbti.getLong("TimeStamp")) {
				nbti.removeKey("TimeStamp");
				nbti.setLong("TimeStamp", System.currentTimeMillis() + 4500L);
				
			} else {
				
				//looped item?
				return null;  //return null if the item is looping
			}
		
		return nbti.getItem();  //return the item with an updated timestamp.
	}
	
	public static ItemStack addNBTTagLegacy(ItemStack item, String value) {
		
		NBTItem nbti = new NBTItem(item);
		if(!nbti.hasKey(value)) { 
			nbti.setString(value, value);
			
			return nbti.getItem();
		}
		return null;
	}
	
	public static ItemStack updateTimeStampLegacy(ItemStack item) {
		NBTItem nbti = new NBTItem(item);
		if(!nbti.hasKey("TimeStamp")) { 
			nbti.setLong("TimeStamp", (System.currentTimeMillis() + 4500L));
			
			return nbti.getItem();
		}
		return null;
	}

	public static void getEntityTags(Entity ent) {
		
		NBTEntity nbtent = new NBTEntity(ent);
		System.out.println("checking nbt?");
		
		NamespacedKey key = new NamespacedKey(NamespacedKey.MINECRAFT, "gossips");
		PersistentDataContainer data = ent.getPersistentDataContainer();
		
		
	
		
		
		
		NBTCompound tag = nbtent.getCompound("Offers");
		System.out.println("offers-> " + tag.asNBTString() + " - " + tag.getType("Recipes"));
		for(NBTListCompound s:nbtent.getCompound("Offers").getCompoundList("Recipes")) {
		
			if(s.getInteger("specialPrice") < -8) {
				System.out.println("Old Price: " + s.getInteger("specialPrice"));
				s.setInteger("specialPrice", -8);
				System.out.println("Updated Price " + s.getInteger("specialPrice"));
			}
			
		
		}
				
				//System.out.println("Tag: " + z);
		//for(NBTListCompound s:nbtent.getCompoundList("Gossips"))
			//System.out.println("gval: " + s);
		//for(String s:nbtent.getKeys())
			//System.out.println("Key: " + s);
		//System.out.println("debug1: " + nbtent.getCompound("minor_positive").asNBTString());
		//System.out.println("Debug2: " + nbtent.getCompound("minor_positive").getString("type"));
	}
	public static boolean hasNbtTagLegacy(ItemStack item, String tag) {
		NBTItem nbti = new NBTItem(item);
		return nbti.hasKey(tag); 
	}

	public static int isBadShulkerLegacy(ItemStack is) {
		/*	
		System.out.println("Scanning " + is.getType().name() + " for bad nbt data.");
		NBTItem nbti2 = new NBTItem(is);
		for(String key:nbti2.getKeys())
		{
			
			NBTCompoundList nbtList = nbti2.getCompoundList(key);
			if(nbtList == null)
				System.out.println("couldn't get a compound list from key: " + key);
			else {
				System.out.println("found tag list: " + nbtList.getName() + " " + nbtList.size());
			}
			
			if(nbti2.getType(key) == NBTType.NBTTagList)
			{
				System.out.println("Key is: " + key + " Type is: " + nbti2.getType(key));
				NBTTagList nestedList = nbti2.getObject(key,  NBTTagList.class);
				if(nestedList != null) {
					System.out.println("Found a nested tag list " + nestedList.size());
				
				} else {
					nbti2.removeKey(key);
					System.out.println("Removed invalid NBT Tag");
				}
			}
		}
		*/
		
		if(is.getType().name().contains("SHULKER_BOX"))
		{
			NBTItem nbti = new NBTItem(is);
			NBTCompound tag = nbti.getCompound("BlockEntityTag");
			if(tag == null)
				return 0;
			NBTCompoundList itemTag = tag.getCompoundList("Items");
			if(itemTag == null) 
				return 0;

			if(itemTag.size() > 27)
				return itemTag.size();

			

		}

		return 0;
	}

	public static void checkForBadCustomDataLegacy(ItemStack is, Player p, boolean sendToPlayer) {
		
		NBTItem nbti = new NBTItem(is);
		NBTCompoundList itemTag = nbti.getCompoundList("AttributeModifiers");
		if(itemTag == null) {
			return;
		}
		if(itemTag.size() > 0) {
			NBTCompoundList clear = itemTag;
			clear.clear();
			nbti.setObject("AttributModifiers", clear);
			
			if(sendToPlayer)
				p.sendMessage(Msg.CustomAttribsRemoved.getValue(p, is, "Custom Attribute Data"));
			else
				fListener.getLog().append(Msg.CustomAttribsRemoved.getValue(p, is, "Custom Attribute Data"));
			p.getInventory().remove(is);
			p.getInventory().addItem(nbti.getItem());
		}
	}
	
	public static boolean isProCosmeticsLegacy(ItemStack is) {
		NBTItem nbti = new NBTItem(is);
		return nbti.hasKey("PROCOSMETICS"); 
			
		
	}

	
}