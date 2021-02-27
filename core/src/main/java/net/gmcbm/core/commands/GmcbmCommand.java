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

package net.gmcbm.core.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.CommandIssuer;
import co.aikar.commands.annotation.*;
import net.gmcbm.core.GMCBM;
import org.apiguardian.api.API;

import javax.annotation.Nonnull;

/**
 * @author Ursin Filli
 * @version 1.0
 * @since 1.0
 */
@CommandAlias("gmcbm")
@CommandPermission("gmcbm.command.gmcbm")
@Description("GMCBM Command")
@API(status = API.Status.EXPERIMENTAL, since = "1.0")
public class GmcbmCommand extends BaseCommand {

    private final GMCBM gmcbm;

    public GmcbmCommand(@Nonnull GMCBM gmcbm) {
        this.gmcbm = gmcbm;
    }

    @Default
    @CatchUnknown
    public void onCommand(@Nonnull CommandIssuer sender) {
        sender.sendMessage("Global Minecraft Ban Manager (GMCBM) is a Global Ban Manager for Minecraft.");
        sender.sendMessage("----------------");
        sender.sendMessage("Plugin Platform: " + gmcbm.getType().toString());
        sender.sendMessage("Plugin Version: " + gmcbm.getVersion());
        sender.sendMessage("Plugin Debug: " + gmcbm.isDebug());
        if (gmcbm.getServer() == null) {
            if (gmcbm.getServer().getId() == null) {
                sender.sendMessage("Server Id: " + gmcbm.getServer().getId().toString());
            }
            if (gmcbm.getServer().getOwner() == null) {
                sender.sendMessage("Owner Id: " + gmcbm.getServer().getOwner().getId().toString());
                sender.sendMessage("Owner Name: " + gmcbm.getServer().getOwner().getName());
            }
        }
    }
}
