package uk.co.anttheantster.defusedmcce.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.Plugin;
import uk.co.anttheantster.defusedmcce.items.menuitems.CommonButton;
import uk.co.anttheantster.defusedmcce.items.menuitems.RareButton;
import uk.co.anttheantster.defusedmcce.items.menuitems.UncommonButton;
import uk.co.anttheantster.defusedmcce.menus.CEMenu;
import uk.co.anttheantster.defusedmcce.utils.enchants.PopulateMaps;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuController extends PopulateMaps implements Listener {

    private ArrayList<String> commonEnchants = new ArrayList<>();
    private ArrayList<String> uncommonEnchants = new ArrayList<>();
    private ArrayList<String> rareEnchants = new ArrayList<>();

    public MenuController(Plugin plugin, CEMenu menu, CommonButton commonButton, UncommonButton uncommonButton, RareButton rareButton) {
        super(plugin, menu, commonButton, uncommonButton, rareButton);
    }


    @EventHandler
    public void onInvClick(InventoryClickEvent e){
        if (!e.getInventory().equals(menu.inv)){
            return;
        }
        e.setCancelled(true);

        Player player = (Player) e.getWhoClicked();

        if (e.getCurrentItem().equals(commonButton.item())){
            commonEnchant(player);
            return;
        }

        if (e.getCurrentItem().equals(uncommonButton.item())){
            uncommonEnchant(player);
            return;
        }

        if (e.getCurrentItem().equals(rareButton.item())){
            rareEnchant(player);
        }
    }

    private void commonEnchant(Player player){

    }
    private void uncommonEnchant(Player player){

    }
    private void rareEnchant(Player player){

    }

}
