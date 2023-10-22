package org.papiricoh.townycompanies;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class TownyCompanies extends JavaPlugin {
    public static Economy econ = null;

    @Override
    public void onEnable() {
        setupEconomy();
        if(econ == null) {
            getLogger().severe("ERROR: Vault Not installed");
            getServer().getPluginManager().disablePlugin(this);
        }else {

        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
}
