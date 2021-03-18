package org.coralise.kcpotions;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

public abstract class Potions {

    static ItemStack drinkMePotion;

    static Location drinkMePotionLocation;

    public static ItemStack getDrinkMePotion(int amount){

        if(drinkMePotion != null){ 
            drinkMePotion.setAmount(amount);
            return drinkMePotion;
        }

        drinkMePotion = new ItemStack(Material.POTION, amount);

        ItemMeta meta = drinkMePotion.getItemMeta();
        PotionMeta pmeta = (PotionMeta) meta;
        PotionData pdata = new PotionData(PotionType.WATER);
        pmeta.setBasePotionData(pdata);
        meta.setDisplayName("§b§lDrink §f§lMe!");
        meta.setLocalizedName("kcp drink me potion");
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("§7It says §3Drink Me§7... ");
        lore.add("§7'Wonder what that means?");
        lore.add("§7Curious... Very curious...");
        meta.setLore(lore);

        drinkMePotion.setItemMeta(meta);

        return drinkMePotion;

    }
    
}
