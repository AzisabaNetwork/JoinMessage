package net.azisaba.joinmessage;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
    private final JoinMessage plugin;

    public JoinListener(JoinMessage plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Bukkit.getScheduler().runTaskLater(plugin, () -> plugin.getConfig().getStringList("messages").forEach(msg -> {
            event.getPlayer().sendMessage(replaceVariables(msg, event.getPlayer()));
        }), 20L);
    }

    private String replaceVariables(String message, Player player) {
        return message.replace("%player%", player.getName());
    }
}
