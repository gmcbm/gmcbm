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

package net.gmcbm.core.request;

import javax.annotation.Nonnull;
import java.util.Optional;

/**
 * @author Ursin Filli
 * @version 1.0
 * @since 1.0
 */
public class RequestResponse {

    private final String message;
    private final RequestStatus status;
    private final Optional<Object> response;

    /**
     * Constructor of {@link RequestResponse}
     *
     * @param message Response message
     * @param status  Status ({@link RequestStatus})
     */
    public RequestResponse(@Nonnull String message, @Nonnull RequestStatus status) {
        this.message = message;
        this.status = status;
        this.response = Optional.empty();
    }

    /**
     * Constructor of {@link RequestResponse}
     *
     * @param message  Response message
     * @param status   Status ({@link RequestStatus})
     * @param response Response {@link Optional}
     */
    public RequestResponse(@Nonnull String message, @Nonnull RequestStatus status,
                           @Nonnull Optional<Object> response) {
        this.message = message;
        this.status = status;
        this.response = response;
    }

    /**
     * @return Response message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @return status ({@link RequestStatus})
     */
    public RequestStatus getStatus() {
        return status;
    }

    /**
     * @return Response {@link Optional}
     */
    public Optional<Object> getResponse() {
        return response;
    }
}
