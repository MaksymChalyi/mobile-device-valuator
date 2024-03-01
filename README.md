**Project: Price of Phone**

This project is a Spring Boot application that calculates the price of a used phone based on its various characteristics.

**Features:**

* Calculates the price of a phone based on its type, age, broken screen status, internal components state, and speaker pollution.
* Applies discounts for different conditions of the phone.
* Sets minimum prices for different phone types.

**Dependencies:**

* Spring Boot Starter Web
* Lombok (optional)
* Spring Boot Starter Test (for testing)
* Jackson Databind

**Running the application:**

1. Make sure you have Java 17 and Maven installed.
2. Clone the project repository.
3. Open a terminal in the project directory and run `mvn spring-boot:run`.
4. The application will start on port 8080 by default. You can access the API endpoint `/calculate-phone-price` to calculate the price of a phone.

**API endpoint:**

* **POST /calculate-phone-price**
    * **Request body:** JSON object representing a `Phone` object with the following properties:
        * `type`: The type of the phone (SMARTPHONE, FLIP_PHONE, BUTTON)
        * `age`: The age of the phone in years
        * `brokenScreen`: The percentage of the screen that is broken (0-100)
        * `internalComponents`: The state of the phone's internal components (EXCELLENT, NORMAL, AWFUL)
        * `speakerPollution`: The level of dirtiness of the phone's speaker (0-100)
    * **Response:** JSON object with a single property `phonePrice` representing the calculated price of the phone.

**Example usage:**

```json
POST /calculate-phone-price

{
  "type": "SMARTPHONE",
  "age": 2,
  "brokenScreen": 20,
  "internalComponents": "NORMAL",
  "speakerPollution": 50
}
```

**Response:**

```json
{
  "phonePrice": "2880.80"
}
```
