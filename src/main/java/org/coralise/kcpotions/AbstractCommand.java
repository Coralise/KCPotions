package org.coralise.kcpotions;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class AbstractCommand implements CommandExecutor, TabCompleter {

    static JavaPlugin plugin;
    String permission;
    boolean canConsoleUse;
    String[] aliases;

    AbstractCommand(String permission, boolean canConsoleUse, String... aliases){
        this.permission = permission;
        this.canConsoleUse = canConsoleUse;
        this.aliases = aliases;

        for(String o : aliases){
            plugin.getCommand(o).setExecutor(this);
        }
    }

    public boolean isValid(CommandSender sender){

        if(!canConsoleUse && !(sender instanceof Player)){
            sender.sendMessage("§cSorry! Console can't use this command.");
            return false;
        }

        if(sender instanceof Player && !sender.hasPermission(permission)){
            sender.sendMessage("§cYou don't have permission to use this command.");
            return false;
        }

        return true;

    }

    public static void registerCommands(JavaPlugin plugin){

        AbstractCommand.plugin = plugin;

        new GivePotionCommand();
        new SetTeleport();

    }
    
}
