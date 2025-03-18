package uk.co.anttheantster.defusedmcce.utils.enchants;

import org.bukkit.plugin.Plugin;
import uk.co.anttheantster.defusedmcce.items.menuitems.CommonButton;
import uk.co.anttheantster.defusedmcce.items.menuitems.RareButton;
import uk.co.anttheantster.defusedmcce.items.menuitems.UncommonButton;
import uk.co.anttheantster.defusedmcce.menus.CEMenu;

import java.util.HashMap;

public class PopulateMaps {
    private Plugin plugin;

    public CEMenu menu;
    public CommonButton commonButton;
    public UncommonButton uncommonButton;
    public RareButton rareButton;

    public PopulateMaps(Plugin plugin, CEMenu menu, CommonButton commonButton, UncommonButton uncommonButton, RareButton rareButton){
        this.plugin = plugin;

        //Buttons and Menus
        this.menu = menu;
        this.commonButton = commonButton;
        this.uncommonButton = uncommonButton;
        this.rareButton = rareButton;

        //Populate Maps with all enchants for later sorting
        populateMaps();
    }

    public HashMap<String, String> enchant = new HashMap<>();
    public HashMap<String, Integer> level = new HashMap<>();
    public HashMap<String, String> rarity = new HashMap<>();

    public void populateMaps(){
        String beast = "Beast";

        try {
            addEnchant(beast, getRarity(beast), getLevel(beast));
        } catch (Exception e){
            e.printStackTrace();
            plugin.getLogger().severe("Could not populate enchantment maps! Contact support!");
            plugin.getLogger().severe("Error Code: EPM1");
        }
    }


    public void addEnchant(String ench, String type, int lvl){
        enchant.put(type, ench);

        level.put(ench, lvl);
        rarity.put(ench, type);
    }

    private String getRarity(String enchant) {
        try {
            return plugin.getConfig().getString(enchant + ".Rarity");
        } catch (NullPointerException e) {
            return null;
        }
    }
    private int getLevel(String enchant) {
        try {
            return plugin.getConfig().getInt(enchant + ".Level");
        } catch (NullPointerException e) {
            return 0;
        }
    }

}
