/*
 * MIT License
 *
 * Copyright (c) 2021 Global Minecraft Ban Manager
 *
 * Copyright (c) 2021 Ursin Filli
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

package net.gmcbm.bungeecord;

import net.gmcbm.core.GMCBM;
import net.gmcbm.core.server.Server;
import net.gmcbm.core.utils.PluginType;
import net.md_5.bungee.api.plugin.Plugin;

import java.util.UUID;

public final class Main extends Plugin {

    // Instance
    private static Main instance;
    // Debug Option
    private final boolean debug = true;
    private GMCBM gmcbm;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        this.gmcbm = new GMCBM(PluginType.SPIGOT, debug, new Server(UUID.randomUUID()));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public GMCBM getGmcbm() {
        return gmcbm;
    }

    public boolean isDebug() {
        return debug;
    }
}
