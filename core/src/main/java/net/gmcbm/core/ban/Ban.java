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
