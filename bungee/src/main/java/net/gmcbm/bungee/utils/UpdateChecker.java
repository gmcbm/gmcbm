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

package net.gmcbm.bungee.utils;

import net.md_5.bungee.api.plugin.Plugin;

import javax.annotation.Nonnull;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * @author Ursin Filli
 * @version 1.0
 * @since 1.0
 */
public class UpdateChecker {

    private final int id;
    private final Plugin plugin;
    private boolean updateAvailable;
    private String updateNotifyText;

    /**
     * Constructor.
     *
     * @param id     Spigot Plugin Id
     * @param plugin Instance of {@link Plugin}
     */
    public UpdateChecker(int id, @Nonnull Plugin plugin) {
        this.id = id;
        this.plugin = Objects.requireNonNull(plugin);
        this.updateAvailable = false;
        this.updateNotifyText = "An update for %PLUGIN_NAME% is available";
    }

    /**
     * @return result of UpdateCheck
     */
    public boolean isUpdateAvailable() {
        return updateAvailable;
    }

    /**
     * Checks for Update on Spigot
     */
    public void checkUpdate() {
        new Thread(() -> {
            try {
                URLConnection connection = new URL(
                        "https://api.spigotmc.org/legacy/update.php?resource=" + id).openConnection();
                checkVersion(connection);
            } catch (IOException exception) {
                plugin.getLogger().warning(String.valueOf(exception));
            }
        }).start();
    }

    private void checkVersion(@Nonnull URLConnection connection) throws IOException {
        InputStreamReader reader = new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(reader);
        String oldVersion = plugin.getDescription().getVersion();
        String newVersion = br.readLine();
        if (!newVersion.equals(oldVersion)) {
            updateAvailable = true;
            plugin.getLogger().info(getFormattedUpdateNotifyText());
        }
        br.close();
        reader.close();
    }

    /**
     * Placeholders:
     * %PLUGIN_NAME% - Plugin Name
     *
     * @param updateNotifyText UpdateNotifyText
     */
    public void setUpdateNotifyText(@Nonnull String updateNotifyText) {
        this.updateNotifyText = updateNotifyText;
    }

    /**
     * @return Formatted UpdateNotifyText
     */
    public @Nonnull
    String getFormattedUpdateNotifyText() {
        return updateNotifyText.replace("%PLUGIN_NAME%", plugin.getDescription().getName());
    }
}
