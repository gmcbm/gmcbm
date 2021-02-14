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

package net.gmcbm.core;

import net.gmcbm.core.utils.PluginType;

/**
 * @author Ursin Filli
 * @version 1.0
 * @since 1.0
 */
public class GMCBM {

    private final PluginType type;
    private final boolean debug;

    /**
     * GMCBM Constructor
     *
     * @param type  Plugin ({@link PluginType})
     * @param debug Debug mode
     */
    public GMCBM(PluginType type, boolean debug) {
        this.type = type;
        this.debug = debug;
    }

    /**
     * @return Plugin ({@link PluginType})
     */
    public PluginType getType() {
        return type;
    }

    /**
     * @return Debug mode
     */
    public boolean isDebug() {
        return debug;
    }
}
