package pastelito.qsettimer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TimerCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("addtimer")) {
            if (args.length != 1) {
                sender.sendMessage("Usage: /addtimer <seconds>");
                return true;
            }

            int timeSeconds;
            try {
                timeSeconds = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                sender.sendMessage("Invalid time format. Please use an integer number of seconds.");
                return true;
            }

            if (!(sender instanceof Player)) {
                sender.sendMessage("This command can only be used by players.");
                return true;
            }

            Player player = (Player) sender;
            TimerBar timerBar = new TimerBar(player, timeSeconds);
            timerBar.start();
            return true;
        }

        return false;
    }

}