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

package net.gmcbm.core.server;

import lombok.Getter;

import org.apiguardian.api.API;

import javax.annotation.Nullable;
import java.util.UUID;

/**
 * @author Ursin Filli
 * @version 1.0
 * @since 1.0
 */
@API(status = API.Status.MAINTAINED, since = "1.0")
public class Server {

    /**
     * Server Identifier ({@link UUID})
     */
    @Getter
    private final @Nullable
    UUID id;

    /**
     * Owner ({@link Owner})
     */
    @Getter
    private final @Nullable
    Owner owner;

    /**
     * Constructor.
     *
     * @param id    Server Identifier ({@link UUID})
     * @param owner Owner ({@link Owner})
     */
    public Server(@Nullable UUID id, @Nullable Owner owner) {
        this.id = id;
        this.owner = owner;
    }
}
