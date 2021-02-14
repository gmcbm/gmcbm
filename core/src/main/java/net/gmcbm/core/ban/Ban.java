/*
 * MIT License
 *
 * Copyright (c) 2021 Global Minecraft Ban Manager
 *
 * Copyright (c) 2021 Ursin Filli
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

import net.gmcbm.core.item.Item;
import net.gmcbm.core.item.ItemAction;
import net.gmcbm.core.item.ItemStatus;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.Instant;
import java.util.UUID;

/**
 * @author Ursin Filli
 * @version 1.0
 * @since 1.0
 */
public class Ban extends Item {

    /**
     * Constructor of Ban Item
     *
     * @param id         Ban Identifier
     * @param player     {@link UUID} of Player
     * @param reason     Reason
     * @param issuer     Issuer {@link UUID} or null
     * @param issuerName Issuer Name
     * @param from       From {@link Instant}
     * @param until      Until {@link Instant}
     * @param status     Status ({@link ItemStatus})
     * @param action     Action ({@link ItemAction})
     */
    public Ban(@Nonnull String id, @Nonnull UUID player, @Nonnull String reason, @Nullable UUID issuer,
               @Nonnull String issuerName, @Nonnull Instant from, @Nonnull Instant until,
               @Nonnull ItemStatus status, @Nonnull ItemAction action) {
        super(id, player, reason, issuer, issuerName, from, until, status, action);
    }

    /**
     * Constructor of Ban Item
     *
     * @param player     {@link UUID} of Player
     * @param reason     Reason
     * @param issuer     Issuer {@link UUID} or null
     * @param issuerName Issuer Name
     * @param from       From {@link Instant}
     * @param until      Until {@link Instant}
     */
    public Ban(@Nonnull UUID player, @Nonnull String reason, @Nullable UUID issuer, @Nonnull String issuerName,
               @Nonnull Instant from, @Nonnull Instant until) {
        super(player, reason, issuer, issuerName, from, until);
    }
}
