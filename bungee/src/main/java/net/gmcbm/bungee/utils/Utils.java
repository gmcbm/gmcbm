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

import com.google.common.reflect.ClassPath;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Ursin Filli
 * @version 1.0
 * @since 1.0
 */
public final class Utils {

    private Utils() {
        throw new IllegalStateException("Utility class");
    }

    public static void registerListener(@Nonnull String packageName, @Nonnull Plugin plugin) {
        PluginManager pluginManager = plugin.getProxy().getPluginManager();
        try {
            for (ClassPath.ClassInfo classInfo : ClassPath.from(ClassLoader.getSystemClassLoader())
                    .getTopLevelClasses(packageName)) {
                Class<Listener> clazz = (Class<Listener>) Class.forName(classInfo.getName());
                if (Listener.class.isAssignableFrom(clazz)) {
                    pluginManager.registerListener(plugin, clazz.getDeclaredConstructor().newInstance());
                }
            }
        } catch (IOException | ClassNotFoundException | NoSuchMethodException |
                IllegalAccessException | InvocationTargetException | InstantiationException exception) {
            plugin.getLogger().warning(String.valueOf(exception));
        }
    }
}