package uk.co.anttheantster.defusedmcce.items.menuitems;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import uk.co.anttheantster.defusedmcce.utils.ChatColor;

public class UncommonButton {

    private Plugin plugin;
    public UncommonButton(Plugin plugin){
        this.plugin = plugin;
    }

    private String itemType = plugin.getConfig().getString("Menu.Buttons.Uncommon.Type");
    private String itemName = plugin.getConfig().getString("Menu.Buttons.Uncommon.Name");

    public ItemStack item() {
        ItemStack itm = new ItemStack(Material.getMaterial(itemType));
        ItemMeta itmMeta = itm.getItemMeta();

        itmMeta.setDisplayName(ChatColor.translate(itemName));

        itm.setItemMeta(itmMeta);

        return itm;
    }
}
