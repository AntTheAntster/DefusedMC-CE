package uk.co.anttheantster.defusedmcce;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import uk.co.anttheantster.defusedmcce.commands.OpenMenu;
import uk.co.anttheantster.defusedmcce.items.menuitems.CommonButton;
import uk.co.anttheantster.defusedmcce.items.menuitems.RareButton;
import uk.co.anttheantster.defusedmcce.items.menuitems.UncommonButton;
import uk.co.anttheantster.defusedmcce.listeners.MenuController;
import uk.co.anttheantster.defusedmcce.menus.CEMenu;
import uk.co.anttheantster.defusedmcce.utils.enchants.PopulateMaps;

public class DefusedMCCE extends JavaPlugin {

    private CEMenu menu;
    private PopulateMaps populateMaps;

    private CommonButton commonButton;
    private UncommonButton uncommonButton;
    private RareButton rareButton;

    private OpenMenu openMenu;

    private PluginManager pm = getServer().getPluginManager();

    @Override
    public void onEnable() {
        setup();
    }

    private void setup() {
        //Setup
        getLogger().info("Initializing Config");
        saveDefaultConfig();

        getLogger().info("Registering Classes");
        registerClasses();

        getLogger().info("Registering Listeners");
        registerListeners();

        //getLogger().info("Initializing Enchants");

        getLogger().info("Populating Maps");
        populateMaps.populateMaps();

    }

    private void registerClasses() {
        //Utils
        menu = new CEMenu(this, commonButton, uncommonButton, rareButton);


        //Buttons
        commonButton = new CommonButton(this);
        uncommonButton = new UncommonButton(this);
        rareButton = new RareButton(this);

        //Commands
        openMenu = new OpenMenu(menu);

        populateMaps = new PopulateMaps(this, menu, commonButton, uncommonButton, rareButton);
    }

    private void registerListeners() {
        pm.registerEvents(new MenuController(), this);
    }
}
