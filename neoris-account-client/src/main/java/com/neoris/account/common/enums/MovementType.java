package com.neoris.account.common.enums;

public enum MovementType {
    RETIRO("RETIRO"), DEPOSITO("DEPOSITO");

    public final String value;

    MovementType(String value) {
        this.value = value;
    }
}
