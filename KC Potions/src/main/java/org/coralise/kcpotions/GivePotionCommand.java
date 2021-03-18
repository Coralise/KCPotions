package org.coralise.kcpotions;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GivePotionCommand extends AbstractCommand {

    GivePotionCommand() {
        super("kcpotions.givepotion", false, "givepotion", "gp");
    }

    ItemStack potion;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!isValid(sender)) return false;

        int amount = 1;
        String strPotion = "";

        if(args.length < 2){
            sender.sendMessage("§e/gp <potion> <player> [amount] - Gives player a potion. 1 if no amount is given.");
            return false;
        }

        Player player = Bukkit.getPlayer(args[1]);

        if(player == null){
            sender.sendMessage("§cPlayer " + args[1] + " is nowhere to be found!");
            return false;
        }

        if(args.length > 2) amount = Integer.parseInt(args[2]);

        switch(args[0]){

            case "DrinkMePotion":
                potion = Potions.getDrinkMePotion(amount);
                strPotion = "§b§lDrink Me Potion§f";
                break;

        }

        player.getInventory().addItem(potion);

        sender.sendMessage("§a[KCP] §fGiven " + strPotion + " x§a" + amount + "§f to §a" + player.getName() + ".");

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        
        ArrayList<String> tc = new ArrayList<String>();

        if(args.length == 1){
            tc.add("DrinkMePotion");
            return tc;
        }

        if(args.length == 3){
            tc.add("[amount]");
            return tc;
        }

        return null;

    }
    
}
