package enums;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Container;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public enum Msg {
    PluginPrefix("[IllegalStack] -"),
    ChestRemoved("removed a chest from a ~entity~ @"),
    ChestPrevented("prevented ~player~ from putting a chest on a ~entity~ @"),
    StaffChestPunishment("punished ~player~ for continuing to try to put chests on a creature.  A ~entity~ was removed, the player's inventory has been cleared and the player has been kicked from the server. @"),
	BookRemoved("found a book with characters that do NOT match the specified character set and removed it.. Author was: ~author~"),
	TooManyPages("found a book with too many pages and removed it from the inventory of ~name~"),
	SignRemoved("Found a sign not matching the allowed character set in the world @"),
	SignRemovedOnPlace("detected a sign placed by ~name~ that contained characters not in the allowed character set.  Possible dupe machine exploit! @"),
	SignKickPlayerMsg("Placing signs with unicode characters is NOT permitted."),
	ShulkerClick("Removed a shulker box from inside another shulker box clicked by: ~name~"),
	ItemFrameRemoveOnExtend("removed an item frame containing - ~contents~ on the back of a retracting piston @"),
	ItemFrameRemoveOnRetract("removed an item frame containing - ~contents~ pulled by a sticky piston"),
	PistonRetractionDupe("Stopped Rail/Carpet Dupe & Removed Piston @ ~removedblocks~"),
	NetherPortalBlock("Blocked an entity from entering or leaving the nether: ~name~ @"),
	EndPortalBlock("Blocked an entity from entering or leaving the end: ~name~ @"),
	MinecartGlitch1("Located and removed a minecart glitched inside another block : ~blocktype~ @"),
	MinecartGlitch2("Stopped a minecart from being glitched into a block @"),
	ZeroTickGlitch("Stopped Zero tick crop growth glitch and removed (~removedblocks~) @"),
	NamedItemRemovalHopper("Found an item named ~item~ in a hopper, it has been removed @"),
	NamedItemRemovalPlayer("Found an item named: ~item~ in ~name~'s inventory, it has been removed. @"),
	ItemTypeRemovedPlayer("Found a blacklisted item type: ~item~ in ~name~'s inventory, it has been removed"),
	SilkTouchBookBlocked("Stopped  ~name~ from breaking ~block~ using a silk touch book @"),
	
	PistonHeadRemoval("A piston head was exploded.. removing an orphan piston base @"),
	IllegalStackLogin("Illegal stack of items removed: ~item~ (~amount~) from player: ~name~ at login."),
	IllegalStackOffhand("Removed an illegal stack of items from the off hand of ~name~, ~item~ ( ~amount~)"),
	IllegalStackPlayerBody("Illegal stack of items removed: ~item~ (~amount~) from ~name~'s body during item scan." ),
	IllegalStackItemScan("Illegal stack of items removed: ~item~ (~amount~) from player: ~name~ at item scan." ),
	IllegalStackOnClick("Illegal stack of items removed: ~item~ (~amount~) from player: ~name~ on click in inventory." ),
	IllegalStackShorten("Fixed an illegal stack of: ~item~ (~amount~) triggered by player: ~name~."),
	IllegalStackUnstack("Unstacked an illegal stack of: ~item~ (~amount~) triggered by player: ~name~.  ~lost~ items were unable to fit and lost."),
	InvalidPotionRemoved("Removed invalid potion from ~name~ had the following effects: ~effects~"),
	UnbreakableItemCleared("Removed Unbreakable flag from ~item~ found on player ~name~"),
	CustomAttribsRemoved("Removed Custom Attributes on ~item~ held by ~name~ (~attributes~)"),
	GlideActivateMaxBuild("Prevented ~name~ from activating an elytra while above the max build height. @"),
	GlideAboveMaxBuild("Player ~name~ was using an elytra above the max build height, disabling glide. @"),
	CorrectedPlayerLocation("(possible pearl glitch into block) Corrected an enderpearl teleport location for ~player~ @"),
	StoppedPushableArmorStand("Prevented an armor stand from being lifted straight up via a piston @"),
	StoppedPushableEntity("Prevented an entity (armor stand/end crystal) from being pushed into another entity @"),
	RemovedRenamedItem("Removed a renamed item ~item~ from the inventory of ~name~"),
	BlockedTripwireDupe("Player ~name~ attempted to place a tripwire hook on a trap door, it has been removed (PreventTripwireDupe = true)"),
	
	PlayerTrappedPortalMsg("&cSorry ~name~ but that portal appears to not have a valid exit!  You would be trapped if you went through it!"),
	PlayerCommandSleepMsg("&cSorry but all commands are disabled while sleeping!"),
	PlayerDisabledBookMsg("&cSorry but player book editing is disabled on this server!"),
	PlayerKickMsgFishing("&cAuto Clicker Fishing is not allowed on this server!"),
	PlayerKickMsgFishMod("&cAttention! it looks like you may be using an Auto Fishing Mod...  Please change the spot you're fishing to avoid getting kicked!"),
	PlayerSwimExploitMsg("&cThat villager is too busy swimming to trade with you right now!"),
	PlayerCMIShulkerNest("&cSorry you can not put a shulker into another shulker!"),
	PlayerDisabledHorseChestMsg("&cSorry, chests on horses, llamas, mules etc are disabled!"),
	PlayerKickForChestMsg("&cYou were warned about chests on mobs, stop trying."),
	
	PlayerNearbyNotification("a nearby exploit was detected ~prot~"),
	PlayerNetherBlock("&cSorry ~name~ players are not allowed on top of the nether!"),
	PlayerEnchantBlocked("&cSorry ~name~ Enchanting this item is not permitted."),
	PlayerRepairBlocked("&cSorry ~name~ Repairing this item is not permitted."),
	
	StaffMsgEndGatewayVehicleRemoved("player ~name~ attempted to take a ~vehicle~ through an end gateway, it has been removed."),
	StaffMsgBlockedPortalLogin("broke a trapped nether portal @"),
	StaffMsgBlockedPortal("~player~ was prevented from going through a blocked/trapped nether portal @"),
	StaffMsgDropperExploit("Detected a hopper/dropper loop exploit and removed a dispenser/dropper @"),
	StaffMsgSpawnerReset("A ~type~ spawner was reset to a pig spawner when broken by ~name~ @"),
	StaffMsgCreativeBlock("~name~ was prevented from loading in an illegal item via the creative saved toolbar."),
	StaffMsgNetherBlock("~name~ was prevented from accessing the top of the nether @"),
	StaffMsgNetherFix("~name~ has been teleported down from above the nether ceiling @"),
	StaffMsgNetherCart("Stopped ~name~ riding in a vehicle above the nether ceiling @"),
	StaffMsgBookRemoved("Removed a writable book from player: ~name~ because player book creation is disabled!"),
	StaffProtectionToggleMsg("Protection: ~protection~ has been turned ~status~ by ~name~"),
	StaffInvalidProtectionMsg("&cYou must supply a valid protection name to add values to:"),
	StaffOptionUpdated("&aOption successfully updated!"),
	StaffSingleWordsOnly("&cThat protection does not support multiple word arguments!"),
	StaffStringUpdated("&aValue updated with string value: ~value~"),
	StaffEnchantBypass("&cPlease left click with the item in hand you wish to add to the EnchantedItemWhitelist, left click with nothing in hand or use /istack cancel to cancel."),
	StaffEnchantBypassCancel("&cEnchantedItemWhitelist add item mode DISABLED."),
	StaffEnchantBypassAdded("&aAdded ~itemdata~ to the EnchantedItemWhitelist!" ),
	StaffSpamFishingNotice("&a~player~ is spam fishing! ~casts~ casts without a 2 second break! @"),
	StaffAutoFishingNotice("&a~player~ appears to be using an autofishing mod..  ~count~ caught within 0.3 blocks of each other @"),
	StaffBadShulkerRemoved("Removed a hacked shulker box with an excessive amount of items in it (~size~) from ~name~ @"),
	StaffBadShulkerInWorld("Removed a dropped shulker box with an excessive amount of items in it (~size~) from the world: @"),
	StaffNoItem("You must be holding an item in your main hand to force fix it's enchantment!"),
	StaffNoEnchants("This item has no enchants to fix!"),
	StaffEnchantFixed("Corrected ~amount~ enchants on ~item~"),
	StaffNoNBTAPI("NBT-Api was not found on your server and is needed for ~prot~ since it is enabled!  Please download and install it from:  https://www.spigotmc.org/resources/nbt-api.7939/"),
	StaffEnchantNotFixed("IllegalStack did not detect any invalid enchantments on this item."),
	StaffEndPortalProtected("Prevented the end portal from being broken using a dispenser @"),
	StaffMsgNoPerm("You do not have permission to use that IllegalStack feature, node required: ~perm~"),
	DestroyedEnchantedItem("Destroyed an Illegally Enchanted Item ~item~ ~enchant~.(~lvl) found on player: ~player~"),
	IllegalEnchantLevel("&aFixed Enchantment Level ~enchant~.(~lvl~) on ~item~ found on player: ~player~"),
	IllegalEnchantType("&aCould not fix Enchantment ~enchant~.(~lvl~) on ~item~ found on player: ~player~ this enchantment is not valid for this item type!"), 
	
	//@  Location of offense
	//~name~ name of player or entity
	//~contents~ contents of an item frame
	//~removedblocks~ blocked removed
	//~author~    book author
	//~blockType  block type
	//~item~
	
	
	;
	
	
	private String value;
	
	
	Msg(String val) {
		
		this.setValue(val);
		
	}


	public String getValue(String variable) {
		
		String val = value;
		val = val.replace("~perm~", variable);
		val = val.replace("~prot~", variable);
		val = val.replace("~author~", variable);
		val = val.replace("~name~", variable);
		val = val.replace("~contents~", variable);
		val = val.replace("~removedblocks~", variable);
		val = val.replace("@", "@" + variable);
		val = val.replace("~value~", variable);
		return ChatColor.translateAlternateColorCodes('&', val);
	}


	public void setValue(String value) {
		this.value = value;
	}


	public String getValue(Location location, String types) {
		
		String val = value;
		val = val.replace("@", "@ " + location.toString());
		val = val.replace("~removedblocks~", types);
		val = val.replace("~contents~", types);
		val = val.replace("~item~", types);
		val = val.replace("~name~", types);
		
		return ChatColor.translateAlternateColorCodes('&', val);
	}


	public String getValue(Player player, String displayName) {
		
		String val = value;
		val = val.replace("@", "@ " + player.getLocation().toString());
		val = val.replace("~item~", displayName);
		val = val.replace("~name~", player.getName());
		val = val.replace("~block~", displayName);
		val = val.replace("~effects~", displayName);
		
		return ChatColor.translateAlternateColorCodes('&', val);
	}
	public String getValue(HumanEntity le, String value) {
		String val = value;
		val = val.replace("~author~", value);
		val = val.replace("~name~", le.getName());
		
		return val;
	}

	public String getValue(Player p, Location loc) {
		String val = value;
		
		val = val.replace("~player~", p.getName());
		val = val.replace("@", "@ " + loc.toString());
		return val;
	}
	public String getValue(Player p, Integer count, Location loc)
	{
		String val = value;
		
		val = val.replace("~player~", p.getName());
		val = val.replace("@", "@ " + loc.toString());
		val = val.replace("~count~", count.toString());
		return val;
	}
	public String getValue(Player p, Entity ent) {
		String val = value;
		
		val = val.replace("~name~", p.getName());
		val = val.replace("~player~", p.getName());
		val = val.replace("~entity~", ent.getName());
		val = val.replace("~vehicle~", ent.getType().name());
		val = val.replace("@", "@ " + ent.getLocation().toString());
		return val;
	}
	public String getValue(Container c, ItemStack is, Enchantment en)
	{
		String val = value;
		val = val.replace("~item~", is.getType().name());
		val = val.replace("~enchant~", en.getName());
		val = val.replace("~lvl~", is.getEnchantmentLevel(en) + "");
		val = val.replace("~player~", c.getType().name());
		val = val.replace("@", "@ " + c.getLocation().toString());
		return val;
		
	}

	public String getValue(Player p, ItemStack is, Enchantment en)
	{
		String val = value;
		val = val.replace("~item~", is.getType().name());
		val = val.replace("~enchant~", en.getName());
		val = val.replace("~lvl~", is.getEnchantmentLevel(en) + "");
		val = val.replace("~player~", p.getName());
		val = val.replace("@", "@ " + p.getLocation().toString());
		return val;
		
	}
	public String getValue(Player p, EntityType et) {
		String val = value;
		
		val = val.replace("@", "@ " + p.getLocation().toString());
		val = val.replace("~type~", et.name());
		val = val.replace("~name~", p.getName());
		
		return ChatColor.translateAlternateColorCodes('&', val);
	}

	public String getValue(Container c, ItemStack is) {
		
		
		String val = value;
		
		val = val.replace("@", "@ " + c.getLocation().toString());
		val = val.replace("~item~", is.getType().name());
		val = val.replace("~name~", c.getType().name());
		val = val.replace("~amount~", "" +is.getAmount());
		
		return ChatColor.translateAlternateColorCodes('&', val);
	}

	public String getValue(Player p, ItemStack is) {
		
		
		String val = value;
		
		val = val.replace("@", "@ " + p.getLocation().toString());
		val = val.replace("~item~", is.getType().name());
		val = val.replace("~name~", p.getName());
		val = val.replace("~amount~", "" +is.getAmount());
		
		return ChatColor.translateAlternateColorCodes('&', val);
	}

	public String getValue(Player p, ItemStack is, String list) {
		
		
		String val = value;
		
		val = val.replace("@", "@ " + p.getLocation().toString());
		val = val.replace("~item~", is.getType().name());
		val = val.replace("~name~", p.getName());
		val = val.replace("~amount~", "" +is.getAmount());
		val = val.replace("~attributes~", list);
		
		return ChatColor.translateAlternateColorCodes('&', val);
	}
	public String getConfigVal() {
		return ChatColor.translateAlternateColorCodes('&', value);
	}
	public String getValue() {
		
		return value;
	}


	public String getValue(Protections p, String name,String status) {
		String val = value;
		
		
		val = val.replace("~protection~", p.name());
		val = val.replace("~name~", name);
		val = val.replace("~status~", "" + status);
		
		return ChatColor.translateAlternateColorCodes('&', val);
	}

	public String getValue(Player p, int size) {
		String val = value;
		
		val = val.replace("@", "@ " + p.getLocation().toString());
		val = val.replace("~size~", "" + size);
		val = val.replace("~name~", p.getName());
		
		
		return ChatColor.translateAlternateColorCodes('&', val);	
	}
	public String getValue(Location loc, int size) {
		String val = value;
		
		val = val.replace("@", "@ " + loc.toString());
		val = val.replace("~size~", "" + size);
		
		
		
		return ChatColor.translateAlternateColorCodes('&', val);	
	}
	public String getValue(Player p, ItemStack is, int lostItems) {
		String val = value;
		
		val = val.replace("@", "@ " + p.getLocation().toString());
		val = val.replace("~item~", is.getType().name());
		val = val.replace("~name~", p.getName());
		val = val.replace("~amount~", "" +is.getAmount());
		val = val.replace("~lost~", "" +lostItems);
		
		return ChatColor.translateAlternateColorCodes('&', val);	}
	
}
