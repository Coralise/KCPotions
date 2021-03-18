package org.coralise.kcpotions;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

public class PotionDrinkEvent implements Listener {

    static KCPotions m = (KCPotions) KCPotions.getPlugin();

    static Location drinkMePotionLoc = m.getConfig().getLocation("drinkme-tploc");

    @EventHandler
    public void onPotionDrink(PlayerItemConsumeEvent event){
        
        ItemStack item = event.getItem();
        Location loc = new Location(Bukkit.getWorld("world"), 0, 90, 0);

        if(!item.getItemMeta().getLocalizedName().startsWith("kcp")) return;

        Player player = event.getPlayer();

        switch(item.getItemMeta().getLocalizedName()){

            case "kcp drink me potion":
                loc = drinkMePotionLoc;
                break;

        }

        player.teleport(loc);
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, SoundCategory.PLAYERS, 1, 0);

        Bukkit.getScheduler().runTaskLater(m, () -> { player.getInventory().removeItem(new ItemStack(Material.GLASS_BOTTLE, 1)); }, 1);

    }
    
}
