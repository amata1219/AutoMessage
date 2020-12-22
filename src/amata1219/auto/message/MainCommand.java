package amata1219.auto.message;

import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

public class MainCommand implements TabExecutor {

    public List<String> onTabComplete(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
        return null;
    }

    public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
        AutoMessage plugin = AutoMessage.getPlugin();
        plugin.reloadConfig();
        plugin.start();
        arg0.sendMessage(ChatColor.AQUA + "コンフィグを再読み込みしました。");
        return true;
    }
}