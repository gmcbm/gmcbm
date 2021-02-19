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
@CommandAlias("tempmute")
@CommandPermission("gmcbm.command.tempmute")
@Description("GMCBM TempMute Command")
public class TempMuteCommand extends BaseCommand {

    @Default
    @CatchUnknown
    public void onCommand(CommandIssuer sender, String[] args) {
        if (args.length < 4) {
            sender.sendMessage("/mute <Player> <Time> <Unit> <Reason...>");
            return;
        }

        String player = args[0];
        String time = args[1];
        String unit = args[2];
        List<String> argList = Arrays.asList(args);
        argList.remove(0);
        argList.remove(1);
        argList.remove(2);
        String reason = argList.toString();

        sender.sendMessage("Player: " + player + " Time: " + time + " Unit:" + unit + " Reason: " + reason);
    }
}
