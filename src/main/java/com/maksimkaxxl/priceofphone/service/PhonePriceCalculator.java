package com.maksimkaxxl.priceofphone.service;

import com.maksimkaxxl.priceofphone.entity.Phone;
import com.maksimkaxxl.priceofphone.enums.PhoneType;
import org.springframework.stereotype.Service;

@Service
public class PhonePriceCalculator {

    public static final double MAX_DISCOUNT_OF_SCREEN_DAMAGE = 30.0;
    public static final double MAX_DISCOUNT_OF_COMPONENTS_STATE = 25.0;
    public static final double MAX_DISCOUNT_OF_SPEAKER_POLLUTION = 20.0;

    public String calculatePrice(Phone phone) {
        double price = getBasePrice(phone.getType());

        price = applyAgeDiscount(phone, price);
        price = applyScreenDamageDiscount(phone, price);
        price = applyComponentsStateDiscount(phone, price);
        price = applySpeakersDirtinessDiscount(phone, price);

        price = applyPriceLimits(phone.getType(), price);

        return String.format("%.2f", price);
    }

    private double getBasePrice(PhoneType type) {
        switch (type) {
            case SMARTPHONE:
                return 4000;
            case FLIP_PHONE:
                return 2000;
            case BUTTON:
                return 1000;
            default:
                return 0;
        }
    }

    private double applyAgeDiscount(Phone phone, double price) {
        return price - (price / 100 * phone.getAge() * 10);
    }

    private double applyScreenDamageDiscount(Phone phone, double price) {
//        var procent = phone.getBrokenScreen() / 100 * MAX_DISCOUNT_OF_SCREEN_DAMAGE;
        double procent;
        if (phone.getBrokenScreen() >= 0 && phone.getBrokenScreen() <= 33) {
            procent = 10;
        } else if (phone.getBrokenScreen() >= 34 && phone.getBrokenScreen() <= 66) {
            procent = 20;
        } else {
            procent = MAX_DISCOUNT_OF_SCREEN_DAMAGE;
        }


        return price - (price / 100 * procent);
    }

    private double applyComponentsStateDiscount(Phone phone, double price) {

//        var procent = phone.getInternalComponents() / 100 * MAX_DISCOUNT_OF_COMPONENTS_STATE;
        var procent = switch (phone.getInternalComponents()) {
            case EXCELLENT -> 0;
            case NORMAL -> 15;
            case AWFUL -> MAX_DISCOUNT_OF_COMPONENTS_STATE;
        };

        return price - (price / 100 * procent);
    }


    private double applySpeakersDirtinessDiscount(Phone phone, double price) {
//        var procent = MAX_DISCOUNT_OF_SPEAKER_POLLUTION - (phone.getSpeakerPollution() / 100 * MAX_DISCOUNT_OF_SPEAKER_POLLUTION);
        double procent;
        if (phone.getSpeakerPollution() >= 0 && phone.getSpeakerPollution() <= 33) {
            procent = 10;
        } else if (phone.getSpeakerPollution() >= 34 && phone.getSpeakerPollution() <= 66) {
            procent = 15;
        } else {
            procent = MAX_DISCOUNT_OF_SPEAKER_POLLUTION;
        }



        return price - (price / 100 * procent);
    }


    private double applyPriceLimits(PhoneType type, double price) {
        switch (type) {
            case BUTTON:
                return Math.max(price, 700); // Мінімальна ціна для кнопкового телефону
            case FLIP_PHONE:
                return Math.max(price, 1000); // Мінімальна ціна для розкладушки
            case SMARTPHONE:
                return Math.max(price, 1500); // Мінімальна ціна для смартфона
            default:
                return price;
        }
    }
}
