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

import lombok.Getter;
import net.gmcbm.core.server.Server;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

/**
 * @author Ursin Filli
 * @version 1.0
 * @since 1.0
 */
public class Item {

    /**
     * Item Identifier
     */
    @Getter
    private final @Nullable
    String id;

    /**
     * Player ({@link UUID})
     */
    @Getter
    private final @Nonnull
    UUID player;

    /**
     * Reason
     */
    @Getter
    private final @Nonnull
    String reason;

    /**
     * Issuer ({@link Issuer})
     */
    @Getter
    private final @Nonnull
    Issuer issuer;

    /**
     * From ({@link Instant})
     */
    @Getter
    private final @Nonnull
    Instant from;

    /**
     * Until ({@link Instant})
     */
    @Getter
    private final @Nonnull
    Instant until;

    /**
     * Status ({@link ItemStatus})
     */
    @Getter
    private final @Nonnull
    ItemStatus status;

    /**
     * Action ({@link ItemAction})
     */
    @Getter
    private final @Nonnull
    ItemAction action;

    /**
     * Timestamp ({@link Instant})
     */
    @Getter
    private final @Nonnull
    Instant timestamp;

    /**
     * Origin ({@link OriginType})
     */
    @Getter
    private final @Nonnull
    OriginType origin;

    /**
     * Server ({@link Server})
     */
    @Getter
    private final @Nonnull
    Server server;

    /**
     * Constructor.
     *
     * @param id        Item Identifier
     * @param player    {@link UUID} of Player
     * @param reason    Reason
     * @param issuer    Issuer ({@link Issuer})
     * @param from      From {@link Instant}
     * @param until     Until {@link Instant}
     * @param status    Status ({@link ItemStatus})
     * @param action    Action ({@link ItemAction})
     * @param timestamp Timestamp ({@link Instant})
     * @param origin    Origin ({@link OriginType})
     * @param server    Server ({@link Server})
     */
    public Item(@Nonnull String id, @Nonnull UUID player, @Nonnull String reason, @Nonnull Issuer issuer,
                @Nonnull Instant from, @Nonnull Instant until, @Nonnull ItemStatus status, @Nonnull ItemAction action,
                @Nonnull Instant timestamp, @Nonnull OriginType origin, @Nonnull Server server) {
        this.id = Objects.requireNonNull(id);
        this.player = Objects.requireNonNull(player);
        this.reason = Objects.requireNonNull(reason);
        this.issuer = Objects.requireNonNull(issuer);
        this.from = Objects.requireNonNull(from);
        this.until = Objects.requireNonNull(until);
        this.status = Objects.requireNonNull(status);
        this.action = Objects.requireNonNull(action);
        this.timestamp = Objects.requireNonNull(timestamp);
        this.origin = Objects.requireNonNull(origin);
        this.server = Objects.requireNonNull(server);
    }

    /**
     * Constructor.
     *
     * @param player {@link UUID} of Player
     * @param reason Reason
     * @param issuer Issuer ({@link Issuer})
     * @param from   From {@link Instant}
     * @param until  Until {@link Instant}
     * @param server Server ({@link Server})
     */
    public Item(@Nonnull UUID player, @Nonnull String reason, @Nonnull Issuer issuer,
                @Nonnull Instant from, @Nonnull Instant until, @Nonnull Server server) {
        this.id = null;
        this.player = Objects.requireNonNull(player);
        this.reason = Objects.requireNonNull(reason);
        this.issuer = Objects.requireNonNull(issuer);
        this.from = Objects.requireNonNull(from);
        this.until = Objects.requireNonNull(until);
        this.status = ItemStatus.ACTIVE;
        this.action = ItemAction.ADD_NEW;
        this.timestamp = Instant.now();
        this.origin = OriginType.RUNTIME;
        this.server = Objects.requireNonNull(server);
    }
}
