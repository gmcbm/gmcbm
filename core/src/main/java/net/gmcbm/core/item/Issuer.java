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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;
import java.util.UUID;

/**
 * @author Ursin Filli
 * @version 1.0
 * @since 1.0
 */
public class Issuer {

    private final UUID id;
    private final String name;

    /**
     * Constructor.
     *
     * @param id   Issuer {@link UUID} or null
     * @param name Issuer Name
     */
    public Issuer(@Nullable UUID id, @Nonnull String name) {
        this.id = id;
        this.name = Objects.requireNonNull(name);
    }

    /**
     * @return Issuer {@link UUID} or null
     */
    public @Nullable
    UUID getId() {
        return id;
    }

    /**
     * @return Issuer Name
     */
    public @Nonnull
    String getName() {
        return name;
    }
}
