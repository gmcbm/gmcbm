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

package net.gmcbm.bungee.listeners;

import net.gmcbm.bungee.Main;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import javax.annotation.Nonnull;

/**
 * @author Ursin Filli
 * @version 1.0
 * @since 1.0
 */
public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(@Nonnull PostLoginEvent event) {
        ProxiedPlayer player = event.getPlayer();
        if (player.hasPermission("gmcbm.update.notify") && Main.getInstance().getUpdateChecker().isUpdateAvailable()) {
            player.sendMessage(new TextComponent(Main.getInstance().getUpdateChecker().getFormattedUpdateNotifyText()));
        }
    }
}
