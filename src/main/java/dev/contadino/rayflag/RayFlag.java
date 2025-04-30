package dev.contadino.rayflag;

import org.bukkit.plugin.java.JavaPlugin;

public final class RayFlag extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getServer().getPluginManager().registerEvents(new OresListener(), this);

        getCommand("raycheck").setExecutor(new CheckFlag());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
