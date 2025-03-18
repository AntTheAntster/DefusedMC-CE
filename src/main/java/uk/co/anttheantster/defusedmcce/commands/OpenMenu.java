package uk.co.anttheantster.defusedmcce.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import uk.co.anttheantster.defusedmcce.items.menuitems.CommonButton;
import uk.co.anttheantster.defusedmcce.items.menuitems.RareButton;
import uk.co.anttheantster.defusedmcce.items.menuitems.UncommonButton;
import uk.co.anttheantster.defusedmcce.menus.CEMenu;

public class OpenMenu implements CommandExecutor {
    private CEMenu menu;
    public OpenMenu(CEMenu menu) {
        this.menu = menu;

    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)){
            return false;
        }
        Player player = (Player) commandSender;

        player.openInventory(menu.inventory(player));

        return false;
    }
}
