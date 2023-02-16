package ca.skynetcloud.cobblemonplaceholder;

import com.cobblemon.mod.common.api.Priority;
import com.cobblemon.mod.common.api.events.CobblemonEvents;
import com.mojang.datafixers.util.Unit;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;


public class Cobblemonplaceholder extends JavaPlugin {

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
