package pastelito.qsettimer;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TimerBar {

    private final int timeSeconds;
    private final BossBar bossBar;

    public TimerBar(Player player, int timeSeconds) {
        this.timeSeconds = timeSeconds;
        this.bossBar = Bukkit.createBossBar(formatTime(timeSeconds), BarColor.BLUE, BarStyle.SEGMENTED_10);
        bossBar.setVisible(true);
        bossBar.addPlayer(player);
    }

    public void start() {
        new BukkitRunnable() {
            int timeRemaining = timeSeconds;

            @Override
            public void run() {
                timeRemaining--;
                bossBar.setTitle(formatTime(timeRemaining));
                bossBar.setProgress((double) timeRemaining / timeSeconds);

                if (timeRemaining <= 0) {
                    bossBar.removeAll();
                    cancel();
                }
            }
        }.runTaskTimer(QSetTimer.getPlugin(QSetTimer.class), 0L, 20L);
    }

    private String formatTime(int seconds) {
        int minutes = seconds / 60;
        seconds = seconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

}