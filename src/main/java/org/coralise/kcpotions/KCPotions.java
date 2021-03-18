package org.coralise.kcpotions;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Hello world!
 *
 */
public class KCPotions extends JavaPlugin {

    static KCPotions plugin;

    public static JavaPlugin getPlugin(){
        return plugin;
    }
    
    @Override
    public void onEnable(){
        plugin = this;

        this.saveDefaultConfig();

        AbstractCommand.registerCommands(this);
        getServer().getPluginManager().registerEvents(new PotionDrinkEvent(), this);
    }

}
