package com.neoris.account.common.resources;


import com.neoris.account.common.exceptions.AccountException;
import com.neoris.account.common.logs.accountLogger;

import java.util.MissingResourceException;

/**
 * account properties
 *
 * @author Kevin
 * @version 1.0
 */
public class accountProperties {
    public static final ResourceResolver MESSAGE_RESOLVER = new ResourceResolver("com.neoris.account.client.resources.account");

    private accountProperties() {}

    /**
     * Get string
     *
     * @param key Property key
     * @return Property value
     */
    public static String getString(String key) {
        try {
            return MESSAGE_RESOLVER.getString(key);
        } catch (MissingResourceException e) {
            accountLogger.LOG.error("Error getting property with string value", e);
        }
        return "!%s!".formatted(key);
    }

    /**
     * Get integer property
     *
     * @param key Property key
     * @return Property value
     */
    public static Integer getInteger(String key) {
        try {
            return MESSAGE_RESOLVER.getInteger(key);
        } catch (MissingResourceException e) {
            accountLogger.LOG.error("Error getting property with integer value", e);
        }
        return -1;
    }

    /**
     * Get Long property
     *
     * @param key Property key
     * @return Property value
     */
    public static Long getLong(String key) {
        try {
            return MESSAGE_RESOLVER.getLong(key);
        } catch (MissingResourceException e) {
            accountLogger.LOG.error("Error getting property with long value", e);
        }
        return -1L;
    }

    /**
     * Get Boolean property
     *
     * @param key Property key
     * @return Property value
     * @throws AccountException Exception
     */
    public static Boolean getBoolean(String key)  throws AccountException {
        try {
            return MESSAGE_RESOLVER.getBoolean(key);
        } catch (MissingResourceException e) {
            throw new AccountException("Error getting property with boolean value", e);
        }
    }

    /**
     * Get String
     *
     * @param key Property key
     * @param parameters Object
     * @return Property value
     * @throws accountLogger Exception
     */
    public static String getString(String key, String... parameters) {
        try {
            return MESSAGE_RESOLVER.getString(key,parameters);
        } catch (MissingResourceException e) {
            accountLogger.LOG.error("Error getting property with string value", e);
        }
        return "!%s!".formatted(key);
    }

}
