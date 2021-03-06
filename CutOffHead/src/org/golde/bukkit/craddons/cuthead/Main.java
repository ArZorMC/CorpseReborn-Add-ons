package org.golde.bukkit.craddons.cuthead;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.golde.bukkit.corpsereborn.CorpseAPI.events.CorpseSpawnEvent;
import org.golde.bukkit.corpsereborn.nms.Corpses.CorpseData;

public class Main extends JavaPlugin implements Listener{

	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, this);
		getLogger().info("CRCutOffHead is starting.");
	}

	public void onDisable() {
		getLogger().info("CRCutOffHead is stopping.");
	}

	@EventHandler
	public void corpseSpawn(CorpseSpawnEvent e) {
		CorpseData data = e.getCorpse();
		data.getLootInventory().addItem(playerSkull(data.getPlayer().getName()));
	}

	private ItemStack playerSkull(String name) {
		@SuppressWarnings("deprecation")
		ItemStack item = new ItemStack(397, 1, (short) 3);
		SkullMeta meta = (SkullMeta) item.getItemMeta();
		meta.setOwner(name);
		meta.setDisplayName(ChatColor.RESET + name + "'s head");
		item.setItemMeta(meta);
		return item;
	}

}