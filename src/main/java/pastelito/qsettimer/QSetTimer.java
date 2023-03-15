package pastelito.qsettimer;

import org.bukkit.plugin.java.JavaPlugin;

public final class QSetTimer extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("QSetTimer has been enabled!");
        getCommand("addtimer").setExecutor(new TimerCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info("QSetTimer has been disabled!");
    }

}