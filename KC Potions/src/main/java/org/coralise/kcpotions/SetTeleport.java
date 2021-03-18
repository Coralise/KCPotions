package org.coralise.kcpotions;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetTeleport extends AbstractCommand {

    SetTeleport() {
        super("kcpotions.setteleport", false, "potionssetteleport", "potionssettp", "pstp");
    }

    KCPotions m = (KCPotions) KCPotions.getPlugin();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!isValid(sender)) return false;

        if(args.length != 1){
            sender.sendMessage("§e/pstp <potion> - Sets your current location as the teleport location of potion.");
            return false;
        }

        Player player = (Player) sender;

        Location newLoc = player.getLocation();

        switch(args[0]){

            case "DrinkMePotion":
                PotionDrinkEvent.drinkMePotionLoc = newLoc;
                m.getConfig().set("drinkme-tploc", newLoc);
                m.saveConfig();
                sender.sendMessage("§a[KCP] §fSuccessfully updated §bDrink Me Potion§f's teleport location to your current location.");
                break;

            default:
                sender.sendMessage("§cInvalid potion option.");
                return false;

        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        ArrayList<String> tc = new ArrayList<String>();

        if(args.length == 1){
            tc.add("DrinkMePotion");
            return tc;
        }

        return null;

    }
    
}
