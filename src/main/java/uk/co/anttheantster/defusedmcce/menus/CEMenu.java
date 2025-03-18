package uk.co.anttheantster.defusedmcce.menus;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;
import uk.co.anttheantster.defusedmcce.items.menuitems.CommonButton;
import uk.co.anttheantster.defusedmcce.items.menuitems.RareButton;
import uk.co.anttheantster.defusedmcce.items.menuitems.UncommonButton;
import uk.co.anttheantster.defusedmcce.utils.Messages;

public class CEMenu {
    private Plugin plugin;
    private CommonButton commonButton;
    private UncommonButton uncommonButton;
    private RareButton rareButton;
    public CEMenu(Plugin plugin, CommonButton commonButton, UncommonButton uncommonButton, RareButton rareButton) {
        this.plugin = plugin;
        this.commonButton = commonButton;
        this.uncommonButton = uncommonButton;
        this.rareButton = rareButton;
    }

    public Inventory inv;

    public Inventory inventory(Player player) {
        if (!player.hasPermission("defusedmcce.ce")) {
            player.sendMessage(Messages.noPermission);
            return null;
        }

        inv = Bukkit.createInventory(player, 27, "Custom Enchants");
        populateInventory();

        return inv;
    }

    private void populateInventory() {
        inv.setItem(plugin.getConfig().getInt("Menu.Buttons.Common.Slot"), commonButton.item());
        inv.setItem(plugin.getConfig().getInt("Menu.Buttons.Uncommon.Slot"), uncommonButton.item());
        inv.setItem(plugin.getConfig().getInt("Menu.Buttons.Rare.Slot"), rareButton.item());

        //Filler Blocks
    }


}
