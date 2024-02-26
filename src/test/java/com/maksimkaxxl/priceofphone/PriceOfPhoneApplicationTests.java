package com.maksimkaxxl.priceofphone;

import com.maksimkaxxl.priceofphone.entity.Phone;
import com.maksimkaxxl.priceofphone.enums.PhoneType;
import com.maksimkaxxl.priceofphone.service.PhonePriceCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PriceOfPhoneApplicationTests {

    @Autowired
    private PhonePriceCalculator calculator;

    @Test
    void contextLoads() {
    }


//    @Test
//    void applyAgeDiscountTest() {
//
//        var phone = new Phone(PhoneType.SMARTPHONE, 2, 20, 2, 10);
//        var price = calculator.applyAgeDiscount(phone, 4000);
//        Assertions.assertEquals(3200, price);
//
//    }




}
