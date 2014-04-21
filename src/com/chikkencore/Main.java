package com.chikkencore;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	@EventHandler
	  public void Join(final PlayerJoinEvent e)
	  {
	    if (e.getPlayer().getName().equals("chikkenslayer12"))
	    {
	      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getProvidingPlugin(getClass()), new Runnable()
	      {
	        public void run()
	        {
	          e.getPlayer().getLocation().getWorld().playEffect(e.getPlayer().getLocation(), Effect.SMOKE, 1);
	          Bukkit.broadcastMessage(ChatColor.AQUA + "[CC]" + ChatColor.GOLD + " The Creator Of ChikkenCore Has Joined!");
	        }
	      }
	      , 5L);
	    }
	  }
	@SuppressWarnings("deprecation")
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// Ignite Command
		if (cmd.getName().equalsIgnoreCase("ignite")) {
			if (args.length != 1) {
				return false;
			}
			if (!(sender instanceof Player)) {
				sender.sendMessage("Only players can use this command!");
				return true;
			}
			Player target = Bukkit.getServer().getPlayer(args[0]);
			if (target == null) {
				sender.sendMessage(ChatColor.UNDERLINE + args[0] + ChatColor.RESET + ChatColor.BOLD + ChatColor.RED + "is not online!");
				return true;
			}
			target.setFireTicks(1000);
			sender.sendMessage(ChatColor.UNDERLINE + args[0] + ChatColor.RESET + ChatColor.BOLD + ChatColor.GREEN + " has been ignited for 1,000 ticks");
			}
		
		// Explode command
		if (cmd.getName().equalsIgnoreCase("explode")) {
			if (args.length != 1) {
				sender.sendMessage(ChatColor.RED + "Must give a player name");
				return false;
			}
			if (!(sender instanceof Player)) {
				sender.sendMessage("Only players can use this command!");
				return true;
			}
			Player target = Bukkit.getServer().getPlayer(args[0]);
			if (target == null) {
				sender.sendMessage(ChatColor.UNDERLINE + args[0] + ChatColor.RESET + ChatColor.RED + " is not online");
				return true;
			}
			if (args[0] == "chikkenslayer12") {
				sender.sendMessage(ChatColor.UNDERLINE + args[0] + ChatColor.RESET + ChatColor.RED + "cannot be exploded ;)");
				return false;
			}
			target.setHealth(0);
			float explosionPower = 4F;
			target.getWorld().createExplosion(target.getLocation(), explosionPower);
			sender.sendMessage(ChatColor.UNDERLINE + args[0] + ChatColor.RESET +  ChatColor.BOLD + ChatColor.GREEN + " has exploded");
			}
		return false;
	}
}
