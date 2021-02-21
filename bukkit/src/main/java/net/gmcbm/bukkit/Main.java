/*
 * MIT License
 *
 * Copyright (c) 2021 The GMCBM Authors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package net.gmcbm.bukkit;

import co.aikar.commands.PaperCommandManager;
import net.gmcbm.bukkit.utils.UpdateChecker;
import net.gmcbm.bukkit.utils.Utils;
import net.gmcbm.core.GMCBM;
import net.gmcbm.core.commands.*;
import net.gmcbm.core.server.Server;
import net.gmcbm.core.utils.ApiKey;
import net.gmcbm.core.utils.PluginType;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.UUID;

public final class Main extends JavaPlugin {

    private static final int SPIGOT_PLUGIN_ID = 0;
    private static final int METRICS_PLUGIN_ID = 10428;

    private static Main instance;
    private GMCBM gmcbm;
    private UpdateChecker updateChecker;

    public static @Nonnull
    Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        if (!getServer().getOnlineMode()) {
            getLogger().severe("Offline Mode not Supported!");
            getLogger().severe("If u use BungeeCord use the BungeeCord Plugin!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        gmcbm = new GMCBM(PluginType.BUKKIT, getConfig().getBoolean("debug", false),
                getDescription().getVersion(), new Server(getServerId()), new ApiKey(null));
        updateChecker = new UpdateChecker(SPIGOT_PLUGIN_ID, this);

        saveDefaultConfig();
        registerCommands();
        Utils.registerListener("net.gmcbm.bukkit.listeners", this);

        if (getConfig().getBoolean("metrics")) {
            Metrics metrics = new Metrics(this, METRICS_PLUGIN_ID);
            metrics.addCustomChart(
                    new Metrics.SimplePie("language", () -> getConfig().getString("language", "en")));
        }

        if (getConfig().getBoolean("update-check")) {
            updateChecker.checkUpdate();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerCommands() {
        PaperCommandManager commandManager;
        commandManager = new PaperCommandManager(this);

        commandManager.registerCommand(new BanCommand());
        commandManager.registerCommand(new CheckCommand());
        commandManager.registerCommand(new DelBanCommand());
        commandManager.registerCommand(new DelMuteCommand());
        commandManager.registerCommand(new DelWarnCommand());
        commandManager.registerCommand(new GmcbmCommand(gmcbm));
        commandManager.registerCommand(new MuteCommand());
        commandManager.registerCommand(new TempBanCommand());
        commandManager.registerCommand(new TempMuteCommand());
        commandManager.registerCommand(new UnBanCommand());
        commandManager.registerCommand(new UnMuteCommand());
        commandManager.registerCommand(new WarnCommand());
    }

    private @Nullable
    UUID getServerId() {
        try {
            return UUID.fromString(getConfig().getString("server-id", "default-server"));
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public @Nonnull
    GMCBM getGmcbm() {
        return gmcbm;
    }

    public boolean isDebug() {
        return gmcbm.isDebug();
    }

    public @Nonnull
    UpdateChecker getUpdateChecker() {
        return updateChecker;
    }
}
