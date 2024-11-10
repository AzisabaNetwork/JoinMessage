package net.azisaba.joinmessage;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.Collections;
import java.util.List;

public class JoinMessageReloadCommand implements TabExecutor {
    private final JoinMessage plugin;

    public JoinMessageReloadCommand(JoinMessage plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        plugin.reloadConfig();
        commandSender.sendMessage("Reloaded JoinMessage configuration!");
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return Collections.emptyList();
    }
}
