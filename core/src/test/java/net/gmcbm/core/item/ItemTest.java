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

package net.gmcbm.core.item;

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
class ItemTest {

    @Test
    void testCoverage() {
        Item item = new Item("Id", UUID.fromString("b0e70a1a-57bb-478b-acc2-c4b4dc678b07"), "Reason", new Issuer(null, "Issuer"), Instant.MIN, Instant.MAX,
                ItemStatus.ACTIVE, ItemAction.GET, Instant.MAX, OriginType.LOCAL_DATABASE, new Server(UUID.fromString("74a730c5-06e3-4cce-88a8-5f18c2b883e2")));

        Assertions.assertEquals("Id", item.getId(), "Coverage");
        Assertions.assertEquals(UUID.fromString("b0e70a1a-57bb-478b-acc2-c4b4dc678b07"), item.getPlayer(), "Coverage");
        Assertions.assertEquals("Reason", item.getReason(), "Coverage");
        Assertions.assertNull(item.getIssuer().getId(), "Coverage");
        Assertions.assertEquals("Issuer", item.getIssuer().getName(), "Coverage");
        Assertions.assertEquals(Instant.MIN, item.getFrom(), "Coverage");
        Assertions.assertEquals(Instant.MAX, item.getUntil(), "Coverage");
        Assertions.assertEquals(ItemStatus.ACTIVE, item.getStatus(), "Coverage");
        Assertions.assertEquals(ItemAction.GET, item.getAction(), "Coverage");
        Assertions.assertEquals(Instant.MAX, item.getTimestamp(), "Coverage");
        Assertions.assertEquals(OriginType.LOCAL_DATABASE, item.getOrigin(), "Coverage");
        Assertions.assertEquals(UUID.fromString("74a730c5-06e3-4cce-88a8-5f18c2b883e2"), item.getServer().getId(), "Coverage");

        new Item(UUID.fromString("5ddc9229-6ec2-44db-9ad5-5fef6134bc0f"), "Reason", new Issuer(null, "Issuer"), Instant.MIN, Instant.MAX,
                new Server(UUID.fromString("74a730c5-06e3-4cce-88a8-5f18c2b883e2")));
    }
}