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

package net.gmcbm.core.test;

import co.aikar.commands.CommandIssuer;
import co.aikar.commands.CommandManager;
import co.aikar.commands.MessageType;
import co.aikar.locales.MessageKey;

import javax.annotation.Nonnull;
import java.util.UUID;

/**
 * @author Ursin Filli
 * @version 1.0
 * @since 1.0
 */
public class TestCommandIssuer implements CommandIssuer {

    @Override
    public <T> T getIssuer() {
        return null;
    }

    @Override
    public CommandManager getManager() {
        return null;
    }

    @Override
    public boolean isPlayer() {
        return false;
    }

    @Override
    public @Nonnull
    UUID getUniqueId() {
        return UUID.fromString("e1e1a9fa-2581-48e6-9525-b99b450de14c");
    }

    @Override
    public boolean hasPermission(String permission) {
        return false;
    }

    @Override
    public void sendMessageInternal(String message) {
        // Testing
    }

    @Override
    public void sendMessage(String message) {
        // Testing
    }

    @Override
    public void sendError(MessageKey key, String... replacements) {
        // Testing
    }

    @Override
    public void sendSyntax(MessageKey key, String... replacements) {
        // Testing
    }

    @Override
    public void sendInfo(MessageKey key, String... replacements) {
        // Testing
    }

    @Override
    public void sendMessage(MessageType type, MessageKey key, String... replacements) {
        // Testing
    }
}
