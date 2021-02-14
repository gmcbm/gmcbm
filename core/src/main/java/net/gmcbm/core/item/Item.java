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

    /**
     * Constructor of Item
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
     */
    public Item(@Nonnull String id, @Nonnull UUID player, @Nonnull String reason, @Nullable UUID issuer,
                @Nonnull String issuerName, @Nonnull Instant from, @Nonnull Instant until,
                @Nonnull ItemStatus status, @Nonnull ItemAction action) {
        this.id = Objects.requireNonNull(id);
        this.player = Objects.requireNonNull(player);
        this.reason = Objects.requireNonNull(reason);
        this.issuer = issuer;
        this.issuerName = Objects.requireNonNull(issuerName);
        this.from = Objects.requireNonNull(from);
        this.until = Objects.requireNonNull(until);
        this.status = Objects.requireNonNull(status);
        this.action = Objects.requireNonNull(action);
    }

    /**
     * Constructor of Item
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
        this.action = ItemAction.ADD;
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
}
