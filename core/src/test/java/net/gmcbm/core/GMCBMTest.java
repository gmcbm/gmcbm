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

import net.gmcbm.core.server.OwnerRecord;
import net.gmcbm.core.server.ServerRecord;
import net.gmcbm.core.utils.ApiKeyRecord;
import net.gmcbm.core.utils.LocalDbType;
import net.gmcbm.core.utils.PluginType;
import net.gmcbm.core.utils.SettingsRecord;
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
        GMCBMRecord gmcbm = new GMCBMRecord(PluginType.BUKKIT, false, "1.0.0", new ServerRecord(null, new OwnerRecord(null, null)), new ApiKeyRecord(null),
                new SettingsRecord(false, false, false, LocalDbType.SQLITE));

        Assertions.assertEquals(PluginType.BUKKIT, gmcbm.type(), "Coverage");
        Assertions.assertFalse(gmcbm.debug(), "Coverage");
        Assertions.assertEquals("1.0.0", gmcbm.version(), "Coverage");
        Assertions.assertNull(gmcbm.server().id(), "Coverage");
        Assertions.assertNull(gmcbm.server().owner().id(), "Coverage");
        Assertions.assertNull(gmcbm.server().owner().name(), "Coverage");
        Assertions.assertNull(gmcbm.apiKey().id(), "Coverage");
        Assertions.assertFalse(gmcbm.settings().webEnabled(), "Coverage");
        Assertions.assertFalse(gmcbm.settings().syncEnabled(), "Coverage");
        Assertions.assertFalse(gmcbm.settings().allowWebOfflineJoin(), "Coverage");
        Assertions.assertEquals(LocalDbType.SQLITE, gmcbm.settings().localDbType(), "Coverage");
    }
}