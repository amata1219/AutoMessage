package amata1219.auto.message;

import java.util.HashMap;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public class AutoMessage extends JavaPlugin {

    private static AutoMessage plugin;
    private final HashMap<String, TabExecutor> commands = new HashMap<>();
    private BukkitTask task;

    public void onEnable() {
        plugin = this;
        saveDefaultConfig();
        commands.put("amreload", new MainCommand());
        start();
    }

    public void onDisable() {
        stop();
    }

    public void start() {
        if (task != null) task.cancel();
        task = (new MessageSendTaskRunnable()).runTaskTimer(this, 0L, (long)(this.getConfig().getInt("Interval") * 20));
    }

    public void stop() {
        if (task != null) task.cancel();
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return this.commands.get(command.getName()).onCommand(sender, command, label, args);
    }

    public static AutoMessage getPlugin() {
        return plugin;
    }

}
