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
import net.gmcbm.core.utils.Utils;
import org.apiguardian.api.API;

import javax.annotation.Nonnull;
import java.util.UUID;

/**
 * @author Ursin Filli
 * @version 1.0
 * @since 1.0
 */
@CommandAlias("ban")
@CommandPermission("gmcbm.command.ban")
@Description("GMCBM Ban Command")
@API(status = API.Status.EXPERIMENTAL, since = "1.0")
public class BanCommand extends BaseCommand {

    @Default
    @CatchUnknown
    public void onCommand(@Nonnull CommandIssuer sender, @Nonnull String[] args) {
        if (args.length < 2) {
            sender.sendMessage("/ban <Player> <Reason...>");
            return;
        }

        String player = args[0];
        UUID uuid = Utils.getUUID(player);
        if (uuid == null) {
            sender.sendMessage("Player not Found");
            return;
        }

        StringBuilder reason = new StringBuilder();
        for (int i = 1; i < args.length; i++) {
            reason.append(args[i]).append(" ");
        }

        sender.sendMessage("Player: " + player + " Reason: " + reason);
    }
}
