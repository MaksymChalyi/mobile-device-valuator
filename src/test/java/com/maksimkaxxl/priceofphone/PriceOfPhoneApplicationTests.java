package com.maksimkaxxl.priceofphone;

import com.maksimkaxxl.priceofphone.entity.Phone;
import com.maksimkaxxl.priceofphone.enums.InternalComponents;
import com.maksimkaxxl.priceofphone.enums.PhoneType;
import com.maksimkaxxl.priceofphone.service.PhonePriceCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PriceOfPhoneApplicationTests {

    private PhonePriceCalculator calculator;

    @BeforeEach
    void setUp() {
         calculator = new PhonePriceCalculator();
    }


    @Test
    void testCalculatePriceSmartphone() {
        Phone phone = new Phone(PhoneType.SMARTPHONE, 0, 0, InternalComponents.EXCELLENT, 0);
        assertEquals("3240,00", calculator.calculatePrice(phone));
    }

    @Test
    void testCalculatePriceFlipPhone() {
        Phone phone = new Phone(PhoneType.FLIP_PHONE, 0, 0, InternalComponents.EXCELLENT, 0);
        assertEquals("1620,00", calculator.calculatePrice(phone));
    }

    @Test
    void testCalculatePriceButtonPhone() {
        Phone phone = new Phone(PhoneType.BUTTON, 0, 0, InternalComponents.EXCELLENT, 0);
        assertEquals("810,00", calculator.calculatePrice(phone));
    }

    @Test
    void testApplyAgeDiscount() {
        Phone phone = new Phone(PhoneType.SMARTPHONE, 2, 0, InternalComponents.EXCELLENT, 0);
        assertEquals("2592,00", calculator.calculatePrice(phone));
    }

    @Test
    void testApplyScreenDamageDiscount() {
        Phone phone = new Phone(PhoneType.SMARTPHONE, 0, 50, InternalComponents.EXCELLENT, 0);
        assertEquals("2880,00", calculator.calculatePrice(phone));
    }

    @Test
    void testApplyComponentsStateDiscount() {
        Phone phone = new Phone(PhoneType.SMARTPHONE, 0, 0, InternalComponents.AWFUL, 0);
        assertEquals("2430,00", calculator.calculatePrice(phone));
    }

    @Test
    void testApplySpeakersDirtinessDiscount() {
        Phone phone = new Phone(PhoneType.SMARTPHONE, 0, 0, InternalComponents.EXCELLENT, 50);
        assertEquals("3060,00", calculator.calculatePrice(phone));
    }

    @Test
    void testApplyPriceLimits() {
        Phone phone = new Phone(PhoneType.BUTTON, 0, 0, InternalComponents.EXCELLENT, 0);
        assertEquals("810,00", calculator.calculatePrice(phone));
    }


}
