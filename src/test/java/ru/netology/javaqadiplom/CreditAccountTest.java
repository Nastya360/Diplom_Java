package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldGetBalance() {
        CreditAccount account = new CreditAccount(0, 500, 5);

        Assertions.assertEquals(0, account.getBalance());


    }

    @Test
    public void shouldGetCreditLimit() {
        CreditAccount account = new CreditAccount(0, 500, 5);

        Assertions.assertEquals(500, account.getCreditLimit());


    }

    @Test
    public void shouldGetRate() {
        CreditAccount account = new CreditAccount(0, 500, 5);

        Assertions.assertEquals(5, account.getRate());


    }


    @Test
    public void shouldPointToAnExceptionWhenInitialBalanceIsNotPositive() {


        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(-500, 500, 5);
            ;
        });

    }


    @Test
    public void shouldPointToAnExceptionWhenCreditLimitIsNotPositive() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(500, -500, 5);
            ;
        });
    }


    @Test
    public void shouldPointToAnExceptionWhenRateIsNotPositive() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(500, 500, -5);
        });

    }


    @Test
    public void paymentShouldBeSuccessfulWhenAmountLessThanTheInitialBalance() {
        CreditAccount account = new CreditAccount(1000, 0, 5);


        Assertions.assertEquals(true, account.pay(500));


    }

    @Test
    public void paymentShouldBeDeclinedWhenAmountMoreThanTheInitialBalance() {
        CreditAccount account = new CreditAccount(1000, 0, 5);


        Assertions.assertEquals(false, account.pay(1001));


    }

    @Test
    public void paymentShouldBeSuccessfulWhenAmountLessThanTheCreditLimit() {
        CreditAccount account = new CreditAccount(1000, 500, 5);


        Assertions.assertEquals(true, account.pay(1499));


    }

    @Test
    public void paymentShouldBeDeclinedWhenAmountMoreThanTheCreditLimit() {
        CreditAccount account = new CreditAccount(1000, 500, 5);


        Assertions.assertEquals(false, account.pay(1501));


    }

    @Test
    public void paymentShouldBeDeclinedWhenAmountZero() {
        CreditAccount account = new CreditAccount(1000, 1500, 5);


        Assertions.assertEquals(false, account.pay(0));


    }

    @Test
    public void paymentShouldBeDeclinedWhenAmountHasNegativeValue() {
        CreditAccount account = new CreditAccount(1000, 1500, 5);


        Assertions.assertEquals(false, account.pay(-1));


    }


    @Test
    public void paymentShouldBeSuccessfulWhenAmountEqualsCreditLimit() {
        CreditAccount account = new CreditAccount(0, 500, 5);


        Assertions.assertEquals(true, account.pay(500));


    }

    @Test
    public void paymentShouldBeSuccessfulWhenAmountEqualsBalance() {
        CreditAccount account = new CreditAccount(50, 450, 5);


        Assertions.assertEquals(true, account.pay(500));


    }

    @Test
    public void shouldReplenishTheBalance() {
        CreditAccount account = new CreditAccount(0, 500, 5);


        Assertions.assertEquals(true, account.add(1));


    }

    @Test
    public void shouldNotReplenishTheBalanceWhenAmountIsZero() {

        CreditAccount account = new CreditAccount(0, 500, 5);


        Assertions.assertEquals(false, account.add(0));


    }

    @Test
    public void shouldNotReplenishTheBalanceWhenAmountIsNegative() {
        CreditAccount account = new CreditAccount(1000, 500, 5);


        Assertions.assertEquals(false, account.add(-1));


    }


    @Test
    public void shouldNotChargePercent() {
        CreditAccount account = new CreditAccount(1000, 1500, 5);
        Assertions.assertEquals(0, account.yearChange());


    }

    @Test
    public void shouldChargePercent() {
        CreditAccount account = new CreditAccount(200, 500, 15);

        Assertions.assertEquals(0, account.yearChange());


    }

    @Test
    public void shouldGetCreditLimitWhenCreditLimitIsZero() {
        CreditAccount account = new CreditAccount(10, 0, 5);

        Assertions.assertEquals(0, account.getCreditLimit());


    }

    @Test
    public void shouldGetInitialBalanceWhenInitialBalanceIsZero() {
        CreditAccount account = new CreditAccount(0, 10, 5);

        Assertions.assertEquals(0, account.getBalance());


    }

    @Test
    public void shouldGetRateWhenRateIsZero() {
        CreditAccount account = new CreditAccount(10, 10, 0);

        Assertions.assertEquals(0, account.getRate());


    }


}






