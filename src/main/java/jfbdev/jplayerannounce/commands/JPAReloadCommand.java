package jfbdev.jplayerannounce.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class JPAReloadCommand implements CommandExecutor {

    private final JavaPlugin plugin;
    public JPAReloadCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        String prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("prefix", ""));

        if (sender instanceof Player player) {
            if (!player.hasPermission("jplayerannounce.reload")) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + plugin.getConfig().getString("messages.no-permission", "")));
                return true;
            }
        }

        plugin.reloadConfig();
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + plugin.getConfig().getString("messages.reload", "")));
        return true;
    }
}
