package org.constants;

import java.util.Arrays;

public enum InputType {
    INT("Integer"), BIG_INT("Big Integer"), STR("String"), CHAR("Character"), FLOAT("Floating-Point"), DOUBLE("Double"), BYTE(
            "Byte"), SHORT("Short");

    private final String typeInfo;

    private InputType(String info) {
        this.typeInfo = info;
    }

    public String getTypeInfo() {
        return this.typeInfo + " Type";
    }
}
