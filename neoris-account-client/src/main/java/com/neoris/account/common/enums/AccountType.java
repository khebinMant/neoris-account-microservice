package com.neoris.account.common.enums;

public enum AccountType {
    AHORRO,
    CORRIENTE;

    // Método para validar si un valor es un tipo de cuenta válido
    public static boolean isValid(String type) {
        for (AccountType accountType : values()) {
            if (accountType.name().equalsIgnoreCase(type)) {
                return true;
            }
        }
        return false;
    }
}