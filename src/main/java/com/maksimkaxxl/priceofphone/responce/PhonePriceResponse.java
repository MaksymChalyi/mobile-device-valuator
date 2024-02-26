package com.maksimkaxxl.priceofphone.responce;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PhonePriceResponse {

    @JsonProperty("phonePrice")
    private String  phonePrice;

    public PhonePriceResponse(String phonePrice) {
        this.phonePrice = phonePrice;
    }

    public String getPhonePrice() {
        return phonePrice;
    }

    public void setPhonePrice(String phonePrice) {
        this.phonePrice = phonePrice;
    }
}
