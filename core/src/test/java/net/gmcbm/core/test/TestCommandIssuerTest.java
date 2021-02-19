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

import co.aikar.commands.CommandManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * @author Ursin Filli
 * @version 1.0
 * @since 1.0
 */
class TestCommandIssuerTest {

    TestCommandIssuer testCommandIssuer = new TestCommandIssuer();

    @Test
    void testGetIssuer() {
        Object result = testCommandIssuer.getIssuer();
        Assertions.assertNull(result, "Coverage");
    }

    @Test
    void testGetManager() {
        CommandManager result = testCommandIssuer.getManager();
        Assertions.assertNull(result, "Coverage");
    }

    @Test
    void testIsPlayer() {
        boolean result = testCommandIssuer.isPlayer();
        Assertions.assertFalse(result, "Coverage");
    }

    @Test
    void testGetUniqueId() {
        UUID result = testCommandIssuer.getUniqueId();
        Assertions.assertEquals(UUID.fromString("e1e1a9fa-2581-48e6-9525-b99b450de14c"), result, "Coverage");
    }

    @Test
    void testHasPermission() {
        boolean result = testCommandIssuer.hasPermission("permission");
        Assertions.assertFalse(result, "Coverage");
    }

    @Test
    void testSendMessageInternal() {
        testCommandIssuer.sendMessageInternal("message");
        Assertions.assertNull(testCommandIssuer.getIssuer(), "Coverage");
    }

    @Test
    void testSendMessage() {
        testCommandIssuer.sendMessage("message");
        Assertions.assertNull(testCommandIssuer.getIssuer(), "Coverage");
    }

    @Test
    void testSendError() {
        testCommandIssuer.sendError(null, "replacements");
        Assertions.assertNull(testCommandIssuer.getIssuer(), "Coverage");
    }

    @Test
    void testSendSyntax() {
        testCommandIssuer.sendSyntax(null, "replacements");
        Assertions.assertNull(testCommandIssuer.getIssuer(), "Coverage");
    }

    @Test
    void testSendInfo() {
        testCommandIssuer.sendInfo(null, "replacements");
        Assertions.assertNull(testCommandIssuer.getIssuer(), "Coverage");
    }

    @Test
    void testSendMessage2() {
        testCommandIssuer.sendMessage(null, null, "replacements");
        Assertions.assertNull(testCommandIssuer.getIssuer(), "Coverage");
    }
}
