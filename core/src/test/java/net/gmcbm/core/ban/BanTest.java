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

package net.gmcbm.core.ban;

import net.gmcbm.core.item.Issuer;
import net.gmcbm.core.item.ItemAction;
import net.gmcbm.core.item.ItemStatus;
import net.gmcbm.core.item.OriginType;
import net.gmcbm.core.server.Server;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.UUID;

/**
 * @author Ursin Filli
 * @version 1.0
 * @since 1.0
 */
class BanTest {

    @Test
    void testCoverage() {
        Ban ban = new Ban("Id", UUID.fromString("b0e70a1a-57bb-478b-acc2-c4b4dc678b07"), "Reason", new Issuer(null, "Issuer"), Instant.MIN, Instant.MAX,
                ItemStatus.ACTIVE, ItemAction.GET, Instant.MAX, OriginType.LOCAL_DATABASE, new Server(UUID.fromString("74a730c5-06e3-4cce-88a8-5f18c2b883e2")));

        Assertions.assertEquals("Id", ban.getId(), "Coverage");

        new Ban(UUID.fromString("5ddc9229-6ec2-44db-9ad5-5fef6134bc0f"), "Reason", new Issuer(null, "Issuer"), Instant.MIN, Instant.MAX,
                new Server(UUID.fromString("74a730c5-06e3-4cce-88a8-5f18c2b883e2")));
    }
}