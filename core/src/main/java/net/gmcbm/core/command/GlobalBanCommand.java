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

package net.gmcbm.core.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.CommandIssuer;
import co.aikar.commands.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author Ursin Filli
 * @version 1.0
 * @since 1.0
 */
@CommandAlias("gban")
@CommandPermission("gmcbm.command.gban")
@Description("GMCBM Global Ban Command")
public class GlobalBanCommand extends BaseCommand {

    @Default
    @CatchUnknown
    public void onCommand(CommandIssuer sender, String[] args) {
        if (args.length < 2) {
            sender.sendMessage("/ban <Player> <Reason...>");
            return;
        }

        String player = args[0];
        List<String> argList = Arrays.asList(args);
        argList.remove(0);
        String reason = argList.toString();

        sender.sendMessage("Player: " + player + " Reason: " + reason);
    }
}