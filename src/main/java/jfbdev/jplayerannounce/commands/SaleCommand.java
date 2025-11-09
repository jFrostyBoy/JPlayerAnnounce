package jfbdev.jplayerannounce.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class SaleCommand implements CommandExecutor {

    private final JavaPlugin plugin;
    private final HashMap<UUID, Long> cooldownSale;

    public SaleCommand(JavaPlugin plugin) {
        this.plugin = plugin;
        this.cooldownSale = new HashMap<>();
    }

    @Deprecated
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        String prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("prefix", ""));

        String soundName = plugin.getConfig().getString("sale.sound.name", "BLOCK_ANVIL_PLACE");
        float volume = (float) plugin.getConfig().getDouble("sale.sound.volume", 1.0);
        float pitch = (float) plugin.getConfig().getDouble("sale.sound.pitch", 2.0);

        if (!(sender instanceof Player player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + plugin.getConfig().getString("messages.only-players", "")));
            return true;
        }

        if (!player.hasPermission("jplayerannounce.sell")) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + plugin.getConfig().getString("messages.no-permission", "")));
            return true;
        }

        if (args.length == 0) {
            player.sendMessage(org.bukkit.ChatColor.translateAlternateColorCodes('&', prefix + plugin.getConfig().getString("sale.usage", "")));
            return true;
        }

        long cooldownTime = plugin.getConfig().getLong("sale.cooldown", 60) * 1000;
        UUID playerUUID = player.getUniqueId();
        long currentTime = System.currentTimeMillis();
        long lastUsed = cooldownSale.getOrDefault(playerUUID, 0L);

        if (lastUsed != 0 && currentTime < lastUsed + cooldownTime) {
            long timeLeft = (lastUsed + cooldownTime - currentTime) / 1000;
            String cooldownMessage = plugin.getConfig().getString("sale.cooldown-message", "");
            cooldownMessage = cooldownMessage.replace("%cooldown%", String.valueOf(timeLeft));
            player.sendMessage(org.bukkit.ChatColor.translateAlternateColorCodes('&', prefix + cooldownMessage));
            return true;
        }

        cooldownSale.put(playerUUID, currentTime);
        List<String> formatLines = plugin.getConfig().getStringList("sale.format");
        StringBuilder message = new StringBuilder();
        for (String arg : args) {
            message.append(arg).append(" ");
        }

        String finalMessageContent = message.toString().trim();
        List<String> coloredLines = new ArrayList<>();
        for (String line : formatLines) {
            String processed = line
                    .replace("%player%", player.getName())
                    .replace("%message%", finalMessageContent);
            processed = org.bukkit.ChatColor.translateAlternateColorCodes('&', processed);
            if (!processed.isEmpty()) {
                coloredLines.add(processed);
            }
        }

        String finalMessage = String.join("\n", coloredLines);
        plugin.getServer().broadcastMessage(finalMessage);

        Sound sound = Sound.valueOf(soundName.toUpperCase());
        for (Player online : Bukkit.getOnlinePlayers()) {
            online.playSound(online.getLocation(), sound, volume, pitch);
            return true;
        }
        return true;
    }
}