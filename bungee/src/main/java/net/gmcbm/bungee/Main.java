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

package net.gmcbm.bungee;

import co.aikar.commands.BungeeCommandManager;
import net.gmcbm.bungee.utils.UpdateChecker;
import net.gmcbm.core.GMCBM;
import net.gmcbm.core.commands.*;
import net.gmcbm.core.server.Server;
import net.gmcbm.core.utils.PluginType;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import org.bstats.bungeecord.Metrics;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.File;
import java.util.UUID;

public final class Main extends Plugin {

    private static final int SPIGOT_PLUGIN_ID = 0;
    private static final int METRICS_PLUGIN_ID = 4812;

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

        if (!getProxy().getConfig().isOnlineMode()) {
            getLogger().severe("Offline Mode not Supported!");
            onDisable();
            return;
        }

        gmcbm = new GMCBM(PluginType.BUNGEE, getConfig().getBoolean("debug", false),
                getDescription().getVersion(), new Server(getServerId()));
        updateChecker = new UpdateChecker(SPIGOT_PLUGIN_ID, this);

        registerCommands();

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
        getProxy().getPluginManager().unregisterCommands(this);
        getProxy().getPluginManager().unregisterListeners(this);
    }

    private void registerCommands() {
        BungeeCommandManager commandManager;
        commandManager = new BungeeCommandManager(this);

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
        } catch (IllegalArgumentException exception) {
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

    private @Nonnull
    Configuration getConfig() {
        Configuration configuration = new Configuration();
        try {
            configuration = ConfigurationProvider.getProvider(YamlConfiguration.class)
                    .load(new File(getDataFolder(), "config.yml"));
        } catch (Exception exception) {
            getLogger().warning(exception.toString());
            onDisable();
        }
        return configuration;
    }
}
