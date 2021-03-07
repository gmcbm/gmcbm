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

package net.gmcbm.core;

import net.gmcbm.core.server.Owner;
import net.gmcbm.core.server.Server;
import net.gmcbm.core.utils.ApiKey;
import net.gmcbm.core.utils.LocalDbType;
import net.gmcbm.core.utils.PluginType;
import net.gmcbm.core.utils.Settings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ursin Filli
 * @version 1.0
 * @since 1.0
 */
class GMCBMTest {

    @Test
    void testCoverage() {
        GMCBM gmcbm = new GMCBM(PluginType.BUKKIT, false, "1.0.0", new Server(null, new Owner(null, null)), new ApiKey(null),
                new Settings(false, false, false, LocalDbType.SQLITE));

        Assertions.assertEquals(PluginType.BUKKIT, gmcbm.getType(), "Coverage");
        Assertions.assertFalse(gmcbm.isDebug(), "Coverage");
        Assertions.assertEquals("1.0.0", gmcbm.getVersion(), "Coverage");
        Assertions.assertNull(gmcbm.getServer().getId(), "Coverage");
        Assertions.assertNull(gmcbm.getServer().getOwner().getId(), "Coverage");
        Assertions.assertNull(gmcbm.getServer().getOwner().getName(), "Coverage");
        Assertions.assertNull(gmcbm.getApiKey().getId(), "Coverage");
        Assertions.assertFalse(gmcbm.getSettings().isWebEnabled(), "Coverage");
        Assertions.assertFalse(gmcbm.getSettings().isSyncEnabled(), "Coverage");
        Assertions.assertFalse(gmcbm.getSettings().isAllowWebOfflineJoin(), "Coverage");
        Assertions.assertEquals(gmcbm.getSettings().getLocalDbType(), LocalDbType.SQLITE, "Coverage");
    }
}