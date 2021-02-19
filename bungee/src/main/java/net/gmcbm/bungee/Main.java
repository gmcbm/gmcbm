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
import net.gmcbm.core.GMCBM;
import net.gmcbm.core.command.*;
import net.gmcbm.core.server.Server;
import net.gmcbm.core.utils.PluginType;
import net.md_5.bungee.api.plugin.Plugin;

import java.util.UUID;

public final class Main extends Plugin {

    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        registerCommands();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerCommands() {
        BungeeCommandManager commandManager;
        commandManager = new BungeeCommandManager(this);
//        commandManager.enableUnstableAPI("help");

        commandManager.registerCommand(new BanCommand());
        commandManager.registerCommand(new CheckCommand());
        commandManager.registerCommand(new DelBanCommand());
        commandManager.registerCommand(new DelMuteCommand());
        commandManager.registerCommand(new DelWarnCommand());
        commandManager.registerCommand(new GmcbmCommand());
        commandManager.registerCommand(new MuteCommand());
        commandManager.registerCommand(new TempBanCommand());
        commandManager.registerCommand(new TempMuteCommand());
        commandManager.registerCommand(new UnBanCommand());
        commandManager.registerCommand(new UnMuteCommand());
        commandManager.registerCommand(new WarnCommand());
    }

    public GMCBM gmcbm() {
        return new GMCBM(PluginType.BUNGEE, true, "", new Server(UUID.randomUUID()));
    }

    public boolean isDebug() {
        return gmcbm().isDebug();
    }
}
