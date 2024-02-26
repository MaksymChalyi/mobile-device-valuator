package com.maksimkaxxl.priceofphone.controller;

import com.maksimkaxxl.priceofphone.entity.Phone;
import com.maksimkaxxl.priceofphone.exception.InvalidPhoneParameterException;
import com.maksimkaxxl.priceofphone.responce.PhonePriceResponse;
import com.maksimkaxxl.priceofphone.service.PhonePriceCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhoneController {

    private final PhonePriceCalculator phonePriceCalculator;

    @Autowired
    public PhoneController(PhonePriceCalculator phonePriceCalculator) {
        this.phonePriceCalculator = phonePriceCalculator;
    }

    @PostMapping("/calculate-phone-price")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<?> calculatePhonePrice(@RequestBody Phone phone) {
        try {
            var price = String.valueOf(phonePriceCalculator.calculatePrice(phone));
            var response = new PhonePriceResponse(price);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (InvalidPhoneParameterException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }


}
