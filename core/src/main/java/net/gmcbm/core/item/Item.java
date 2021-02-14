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

package net.gmcbm.core.item;

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

    private final String id;
    private final UUID player;
    private final String reason;
    private final UUID issuer;
    private final String issuerName;
    private final Instant from;
    private final Instant until;
    private final ItemStatus status;
    private final ItemAction action;
    private final Instant timestamp;
    private final OriginType origin;

    /**
     * Constructor of {@link Item}
     *
     * @param id         Item Identifier
     * @param player     {@link UUID} of Player
     * @param reason     Reason
     * @param issuer     Issuer {@link UUID} or null
     * @param issuerName Issuer Name
     * @param from       From {@link Instant}
     * @param until      Until {@link Instant}
     * @param status     Status ({@link ItemStatus})
     * @param action     Action ({@link ItemAction})
     * @param timestamp  Timestamp ({@link Instant})
     * @param origin     Origin ({@link OriginType})
     */
    public Item(@Nonnull String id, @Nonnull UUID player, @Nonnull String reason, @Nullable UUID issuer,
                @Nonnull String issuerName, @Nonnull Instant from, @Nonnull Instant until,
                @Nonnull ItemStatus status, @Nonnull ItemAction action, @Nonnull Instant timestamp,
                @Nonnull OriginType origin) {
        this.id = Objects.requireNonNull(id);
        this.player = Objects.requireNonNull(player);
        this.reason = Objects.requireNonNull(reason);
        this.issuer = issuer;
        this.issuerName = Objects.requireNonNull(issuerName);
        this.from = Objects.requireNonNull(from);
        this.until = Objects.requireNonNull(until);
        this.status = Objects.requireNonNull(status);
        this.action = Objects.requireNonNull(action);
        this.timestamp = Objects.requireNonNull(timestamp);
        this.origin = Objects.requireNonNull(origin);
    }

    /**
     * Constructor of {@link Item}
     *
     * @param player     {@link UUID} of Player
     * @param reason     Reason
     * @param issuer     Issuer {@link UUID} or null
     * @param issuerName Issuer Name
     * @param from       From {@link Instant}
     * @param until      Until {@link Instant}
     */
    public Item(@Nonnull UUID player, @Nonnull String reason, @Nullable UUID issuer, @Nonnull String issuerName,
                @Nonnull Instant from, @Nonnull Instant until) {
        this.id = null;
        this.player = Objects.requireNonNull(player);
        this.reason = Objects.requireNonNull(reason);
        this.issuer = issuer;
        this.issuerName = Objects.requireNonNull(issuerName);
        this.from = Objects.requireNonNull(from);
        this.until = Objects.requireNonNull(until);
        this.status = ItemStatus.ACTIVE;
        this.action = ItemAction.ADD_NEW;
        this.timestamp = Instant.now();
        this.origin = OriginType.RUNTIME;
    }

    /**
     * @return Item Identifier
     */
    public String getId() {
        return id;
    }

    /**
     * @return {@link UUID} of Player
     */
    public UUID getPlayer() {
        return player;
    }

    /**
     * @return Reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @return Issuer {@link UUID} or null
     */
    public UUID getIssuer() {
        return issuer;
    }

    /**
     * @return Issuer Name
     */
    public String getIssuerName() {
        return issuerName;
    }

    /**
     * @return From {@link Instant}
     */
    public Instant getFrom() {
        return from;
    }

    /**
     * @return Until {@link Instant}
     */
    public Instant getUntil() {
        return until;
    }

    /**
     * @return Status ({@link ItemStatus})
     */
    public ItemStatus getStatus() {
        return status;
    }

    /**
     * @return Action ({@link ItemAction})
     */
    public ItemAction getAction() {
        return action;
    }

    /**
     * @return Timestamp
     */
    public Instant getTimestamp() {
        return timestamp;
    }

    /**
     * @return Origin
     */
    public OriginType getOrigin() {
        return origin;
    }
}
