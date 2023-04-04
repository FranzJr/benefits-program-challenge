### Happy Fit 🙂
📃Happy Fit is a company that provides a benefits program which gives great discounts in certain e-commerce sites for all its subscribers.
This program consists of the following benefits:
- ☑️ When a customer pays with a Visa card, the program will provide the following benefits:
If the client buys 10 different products 🛒 or more, a 15% discount will be applied on the final amount to pay. 
In a different case if he buys 7 - 9 different products, a 10% discount will be applied on the final amount to pay
otherwise a 5% discount is applied on the final amount.
- ☑️ When a customer pays with a Mastercard card, the program will provide the following benefits:
If the client total amount 💵 to pay equals $100 or more, then a 17% discount will be applied on it. 
In a different case if the amount is in range of $75 - $99, a 12% discount will be applied. Otherwise, 
an 8% discount is applied no matter the amount.

🏁 Your job for this challenge is to make a refactor of the code already done to process the discounts conditions described above.
The goal is to reduce complexity and make it more SOLID. 
- ❗Feel free to apply any patterns you consider might fit. 
- ❗Make any changes you consider will also improve performance. 
- ❗Incorporate exception handling with at least one custom exception.
- ❗Refactor to allow creation of small testable units.
- ❗Write a simple Javadoc with essential information for one or more of the newly created methods or classes.

#### Result

- Patterns :: Here I apply Strategy pattern, where PaymentType interface define a set of methods that earch payment type must to implement, the VisaPaymentType and MasterCardPaymentType implement this interface and we have for each a different implementation of discount method, also from SOLID I use S from single responsibility, from pattern and SOLID allows easier maintenance because is possible to add new payment types without modifying existing code
- Performance :: To improve the performance using streams instead of loops for better efficiency and readability, caching the total number of products in the order to avoid recalculating many times, using bigdecimal to avoud precision issues when use double values. Exception :: I create a OrderPaymentTypeException, is thrown when a paymnet type is not supported
- TESTING :: I created also JUnit tests for payOrder() with different scenarios
- JavaDoc :: For each class the necessary Java document was added so that it can be understood

#### Detailed Info

##### Class
- Order
- PaymentType
- MasterCardPaymentType
- VisaPaymentType
- Product
- ProductFactory

##### Exceptions
- OrderPaymentTypeException

##### Test
- OrderTest
- ProductGeneratorTest; To test this also need PayOrderSimulator, ProductGenerator


##### Run test
```json
mvn clean test
```

- Expected result

```java
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running coe.unosquare.benefits.order.OrderTest
[INFO] Tests run: 7, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.063 s - in coe.unosquare.benefits.order.OrderTest
[INFO] Running coe.unosquare.benefits.util.ProductGeneratorTest
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0 s - in coe.unosquare.benefits.util.ProductGeneratorTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 10, Failures: 0, Errors: 0, Skipped: 0
```