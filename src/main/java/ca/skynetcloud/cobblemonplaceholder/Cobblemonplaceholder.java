package ca.skynetcloud.cobblemonplaceholder;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;


public class Cobblemonplaceholder extends JavaPlugin {

    public Logger logger;
    public void onEnable() {
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") == null) {
            System.out.println("PlaceholderAPI not found, disabling CobblemonPlaceholder.");
            this.getServer().getPluginManager().disablePlugin((Plugin)this);
        }
        else {
            new CobblemonExpansion().register();
        }
    }

}
