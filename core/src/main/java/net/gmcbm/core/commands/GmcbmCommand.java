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
        sender.sendMessage("§7<------- §8| §c§lGlobal Minecraft Ban Manager §8| §7------->");
        sender.sendMessage(" ");
        sender.sendMessage("§8> §7Global Minecraft Ban Manager (GMCBM) is a secure and reliable global ban manager for Minecraft");
        sender.sendMessage(" ");
        sender.sendMessage("§8> §7Here are just some information you may need if you have found a bug or you are opening a support ticket.");
        sender.sendMessage("§8> §7Plugin Platform: §a" + gmcbm.getType().toString());
        sender.sendMessage("§8> §7Plugin Version: §a" + gmcbm.getVersion());
        sender.sendMessage("§8> §7Plugin Debug: §a" + gmcbm.isDebug());
        if (gmcbm.getServer().getId() != null) {
            sender.sendMessage("§8> §7Server ID: §a" + gmcbm.getServer().getId().toString());
        }
        if (gmcbm.getServer().getOwner().id() != null) {
            sender.sendMessage("§8> §7Owner Id: §a" + gmcbm.getServer().getOwner().id().toString());
        }
        if (gmcbm.getServer().getOwner().name() != null) {
            sender.sendMessage("§8> §7Owner Name: §a" + gmcbm.getServer().getOwner().name());
        }
        sender.sendMessage(" ");
        sender.sendMessage("§7<------- §8| §c§lGlobal Minecraft Ban Manager §8| §7------->");
    }
}
