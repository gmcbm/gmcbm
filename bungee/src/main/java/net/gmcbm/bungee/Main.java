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
import lombok.Getter;
import net.gmcbm.bungee.utils.UpdateChecker;
import net.gmcbm.bungee.utils.Utils;
import net.gmcbm.core.GMCBMRecord;
import net.gmcbm.core.commands.*;
import net.gmcbm.core.server.OwnerRecord;
import net.gmcbm.core.server.ServerRecord;
import net.gmcbm.core.utils.ApiKeyRecord;
import net.gmcbm.core.utils.LocalDbType;
import net.gmcbm.core.utils.PluginType;
import net.gmcbm.core.utils.SettingsRecord;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import org.bstats.bungeecord.Metrics;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.UUID;

public final class Main extends Plugin {

    private static final int SPIGOT_PLUGIN_ID = 0;
    private static final int METRICS_PLUGIN_ID = 10425;

    @Getter
    private static Main instance;

    @Getter
    private GMCBMRecord gmcbm;

    @Getter
    private UpdateChecker updateChecker;

    @Override
    public void onEnable() {
        instance = this;

        if (!getProxy().getConfig().isOnlineMode()) {
            getLogger().severe("Offline Mode not Supported!");
            onDisable();
            return;
        }

        gmcbm = new GMCBMRecord(PluginType.BUNGEE, getConfig().getBoolean("debug", false),
                getDescription().getVersion(), new ServerRecord(getServerId(), new OwnerRecord(null, null)), new ApiKeyRecord(null),
                new SettingsRecord(false, false, false, LocalDbType.SQLITE));
        updateChecker = new UpdateChecker(SPIGOT_PLUGIN_ID, this);

        saveDefaultConfig();
        registerCommands();
        Utils.registerListener("net.gmcbm.bungee.listeners", this);

        if (getConfig().getBoolean("metrics")) {
            Metrics metrics = new Metrics(this, METRICS_PLUGIN_ID);
//            metrics.addCustomChart(
//                    new Metrics.SimplePie("language", () -> getConfig().getString("language", "en")));
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

    public boolean isDebug() {
        return gmcbm.debug();
    }

    private @Nonnull
    Configuration getConfig() {
        Configuration configuration = new Configuration();
        try {
            configuration = ConfigurationProvider.getProvider(YamlConfiguration.class)
                    .load(new File(getDataFolder(), "config.yml"));
        } catch (IOException exception) {
            getLogger().warning(String.valueOf(exception));
            onDisable();
        }
        return configuration;
    }

    private void saveDefaultConfig() {
        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }

        File file = new File(getDataFolder(), "config.yml");
        if (!file.exists()) {
            try (InputStream in = getResourceAsStream("config.yml")) {
                Files.copy(in, file.toPath());
            } catch (IOException exception) {
                getLogger().warning(String.valueOf(exception));
            }
        }
    }
}
