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

package net.gmcbm.core;

import net.gmcbm.core.server.ServerRecord;
import net.gmcbm.core.utils.ApiKeyRecord;
import net.gmcbm.core.utils.PluginType;
import net.gmcbm.core.utils.SettingsRecord;
import org.apiguardian.api.API;

import javax.annotation.Nonnull;

/**
 * @author Ursin Filli
 * @version 1.0
 * @since 1.0
 */
@API(status = API.Status.MAINTAINED, since = "1.0")
public class GMCBMRecord {
    private final PluginType type;
    private final boolean debug;
    private final String version;
    private final ServerRecord server;
    private final ApiKeyRecord apiKey;
    private final SettingsRecord settings;

    /**
     * @param type     Plugin ({@link PluginType})
     * @param debug    Debug mode
     * @param version  Plugin Version
     * @param server   Server ({@link ServerRecord})
     * @param apiKey   Api Key ({@link ApiKeyRecord})
     * @param settings Settings ({@link SettingsRecord})
     */
    public GMCBMRecord(@Nonnull PluginType type, boolean debug, @Nonnull String version, @Nonnull ServerRecord server,
                       @Nonnull ApiKeyRecord apiKey, @Nonnull SettingsRecord settings) {
        this.type = type;
        this.debug = debug;
        this.version = version;
        this.server = server;
        this.apiKey = apiKey;
        this.settings = settings;
    }

    public PluginType type() {
        return type;
    }

    public boolean debug() {
        return debug;
    }

    public String version() {
        return version;
    }

    public ServerRecord server() {
        return server;
    }

    public ApiKeyRecord apiKey() {
        return apiKey;
    }

    public SettingsRecord settings() {
        return settings;
    }
}
