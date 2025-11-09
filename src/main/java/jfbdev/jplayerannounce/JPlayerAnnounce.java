package jfbdev.jplayerannounce;

import jfbdev.jplayerannounce.commands.BroadCastCommand;
import jfbdev.jplayerannounce.commands.BuyCommand;
import jfbdev.jplayerannounce.commands.JPAReloadCommand;
import jfbdev.jplayerannounce.commands.SaleCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class JPlayerAnnounce extends JavaPlugin {

    @Override
    public void onEnable() {

        saveDefaultConfig();
        Objects.requireNonNull(getCommand("broadcast")).setExecutor(new BroadCastCommand(this));
        Objects.requireNonNull(getCommand("jpareload")).setExecutor(new JPAReloadCommand(this));
        Objects.requireNonNull(getCommand("buy")).setExecutor(new BuyCommand(this));
        Objects.requireNonNull(getCommand("sale")).setExecutor(new SaleCommand(this));

    }
}