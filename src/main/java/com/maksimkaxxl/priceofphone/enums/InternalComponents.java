package com.maksimkaxxl.priceofphone.enums;

public enum InternalComponents {
    EXCELLENT("Чудовий"),
    NORMAL("Задовільний"),
    AWFUL("Жахливий");

    private final String internalComponents;


    InternalComponents(String internalComponents) {
        this.internalComponents = internalComponents;
    }

    public String getInternalComponents() {
        return internalComponents;
    }

}
