package net.azisaba.joinmessage;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class JoinMessage extends JavaPlugin {
    @Override
    public void onEnable() {
        saveDefaultConfig();
        Objects.requireNonNull(getCommand("joinmessagereload")).setExecutor(new JoinMessageReloadCommand(this));
        getServer().getPluginManager().registerEvents(new JoinListener(this), this);
    }
}
