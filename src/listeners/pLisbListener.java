package listeners;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.entity.ChestedHorse;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import enums.Msg;
import enums.Protections;
import main.IllegalStack;
import main.fListener;
import timers.fTimer;

public class pLisbListener {

	Plugin plugin;
	int debug = 0;
	HashMap<UUID,Long> messageDelay = new HashMap<>();

	
	public pLisbListener(IllegalStack illegalStack, String version) {
		plugin = illegalStack;
		
		//ProtocolLibrary.getProtocolManager().addPacketListener(new BookCrashExploitCheck(plugin));
		if(Protections.BlockBadItemsFromCreativeTab.isEnabled() ) {
			ProtocolLibrary.getProtocolManager().addPacketListener(
					new PacketAdapter(plugin, PacketType.Play.Client.SET_CREATIVE_SLOT) { 

						@Override
						public void onPacketReceiving(PacketEvent event) {
							if(!Protections.BlockBadItemsFromCreativeTab.isEnabled() || event.getPlayer().isOp())
								return;

							try {
								ItemStack stack = event.getPacket().getItemModifier().readSafely(0);

								if(stack != null && stack.hasItemMeta()) {
									stack = new ItemStack(Material.AIR);
									event.getPlayer().updateInventory();
									event.setCancelled(true);
									Msg.StaffMsgCreativeBlock.getValue(event.getPlayer().getName());
									return;
								}
							} catch (IndexOutOfBoundsException ex) {
								System.out.println("[IllegalStack] - an error receiving a SET_CREATIVE_SLOT packet has occured, you are probably using paper and have BlockBadItemsFromCreativeTab turned on.   This setting is needed very rarely, and ONLY if you have regular non-op players with access to /gmc.");  
							}                     

						} 

					});

		}

		if(Protections.DisableChestsOnMobs.isEnabled() ) {
			ProtocolLibrary.getProtocolManager().addPacketListener(
					new PacketAdapter(plugin, PacketType.Play.Client.USE_ENTITY) 
					{ 

						@Override
						public void onPacketReceiving(PacketEvent event) 
						{
							
							if(IllegalStack.hasChestedAnimals()) 
							{
								try {
									
									Entity entity = (Entity)event.getPacket().getEntityModifier(event.getPlayer().getWorld()).read(0);
									if(entity instanceof ChestedHorse && ((ChestedHorse)entity).isTamed()) {
										ItemStack is = event.getPlayer().getInventory().getItemInMainHand();
										if(is == null || is.getType() != Material.CHEST)
											is = event.getPlayer().getInventory().getItemInOffHand();

										if(is == null || is.getType() != Material.CHEST)
											return;

										exploitMessage(event.getPlayer(), entity);

										event.setCancelled(true);
										event.setPacket(new PacketContainer(0));
										((ChestedHorse) entity).setCarryingChest(true);
										((ChestedHorse) entity).setCarryingChest(false);
										fTimer.getPunish().put(event.getPlayer(), entity);
										



									}

								} catch (IndexOutOfBoundsException ex) {
									System.out.println("[IllegalStack] - an error receiving a USE_ENTITY packet has occured, ");
									ex.printStackTrace();
								}
							} else {

								try {
									Entity entity = (Entity)event.getPacket().getEntityModifier(event.getPlayer().getWorld()).read(0);
									if(entity instanceof Horse && ((Horse)entity).isTamed()) {
										ItemStack is = event.getPlayer().getInventory().getItemInHand();
										if(!fListener.getInstance().is18() && (is == null || is.getType() != Material.CHEST))
											is = event.getPlayer().getInventory().getItemInOffHand();

										if(is == null || is.getType() != Material.CHEST)
											return;

										exploitMessage(event.getPlayer(), entity);

										event.setCancelled(true);
										//event.setPacket(new PacketContainer(0));
									//	((Horse) entity).setCarryingChest(true);
										//((Horse) entity).setCarryingChest(false);

										fTimer.getPunish().put(event.getPlayer(), entity);



									}

								} catch (IndexOutOfBoundsException ex) {
									System.out.println("[IllegalStack] - an error receiving a USE_ENTITY packet has occured, ");
									ex.printStackTrace();
								}                     
							}
							
						} 

					});

		}

	}

	private void exploitMessage(Player p, Entity ent) {
		if(!messageDelay.containsKey(p.getUniqueId()))
			messageDelay.put(p.getUniqueId(), 0l);

		if(System.currentTimeMillis() > messageDelay.get(p.getUniqueId()))
		{
			p.sendMessage(Msg.PlayerDisabledHorseChestMsg.getValue());
			fListener.getLog().append(Msg.ChestPrevented.getValue(p,ent));
			messageDelay.put(p.getUniqueId(), System.currentTimeMillis() + 2000l);
		}
	}
}
