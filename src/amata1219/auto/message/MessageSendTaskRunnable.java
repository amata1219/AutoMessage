package amata1219.auto.message;

import java.util.List;
import org.bukkit.scheduler.BukkitRunnable;

public class MessageSendTaskRunnable extends BukkitRunnable {

    private final List<String> messages = AutoMessage.getPlugin().getConfig().getStringList("Messages");
    private int count;

    public void run() {
        String message = messages.get(count);
        AutoMessage.getPlugin().getServer().getOnlinePlayers().forEach((player) -> {
            player.sendMessage(message);
        });
        if (count >= messages.size() - 1) count = 0;
        else ++count;

    }
}