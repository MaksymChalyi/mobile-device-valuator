package com.maksimkaxxl.priceofphone.enums;

public enum PhoneType {


    SMARTPHONE("Смартфон"),
    FLIP_PHONE("Розкладушка"),
    BUTTON("Кнопковий");

    private final String phoneType;


    PhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public String getPhoneType() {
        return phoneType;
    }
}
