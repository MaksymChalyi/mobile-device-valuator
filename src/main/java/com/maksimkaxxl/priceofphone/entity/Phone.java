package com.maksimkaxxl.priceofphone.entity;

import com.maksimkaxxl.priceofphone.enums.InternalComponents;
import com.maksimkaxxl.priceofphone.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Phone {

    PhoneType type;
    Integer age;
    Integer brokenScreen;
    InternalComponents internalComponents;
    Integer speakerPollution;
}
