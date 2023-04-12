package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqadiplom.SavingAccount;

import static org.junit.jupiter.api.Assertions.*;

public class SavingAccountTest {


    @Test
    public void checkSavingAccount() {
        SavingAccount account = new SavingAccount(1_500, 500, 10_000, 5);
        assertEquals(1_500, account.getBalance());
        assertEquals(500, account.getMinBalance());
        assertEquals(10_000, account.getMaxBalance());
        assertEquals(5, account.getRate());
    }

    @Test
    public void checkIncorrectBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(300, 500, 10_000, 5);
        });
    }

    @Test
    public void checkMinusBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(-1_000, 500, 10_000, 5);
        });
    }

    @Test
    public void checkMinusRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(1000, 500, 10_000, -5);
        });
    }

    @Test
    public void checkZeroMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(1_000, 500, 0, 5);
        });
    }

    @Test
    public void checkPaySavingAccountAmongMinMaxBalance() {
        SavingAccount account = new SavingAccount(1_000, 500, 10_000, 5);
        assertFalse(account.pay(600));
        assertEquals(400, account.getBalance());
    }

    @Test
    public void checkPaySavingAccount() {
        SavingAccount account = new SavingAccount(1_500, 500, 2_000, 5);
        boolean result = account.pay(1_000);
        assertTrue(result);
        assertEquals(500, account.getBalance());
    }

    @Test
    public void checkPayMinusAmount() {
        SavingAccount account = new SavingAccount(1_500, 500, 2_000, 5);
        boolean result = account.pay(-1_000);
        assertEquals(false, result);
        assertEquals(1_500, account.getBalance());
    }

    @Test
    public void checkPayBelowMinBalance() {
        SavingAccount account = new SavingAccount(1_500, 500, 2_000, 5);
        boolean result = account.pay(1_100);
        assertEquals(false, result);
        assertEquals(400, account.getBalance());
    }

    @Test
    public void checkPayAboveMaxBalance() {
        SavingAccount account = new SavingAccount(1_500, 500, 2_000, 5);
        boolean result = account.pay(7_000);
        assertEquals(false, result);
    }

    @Test
    void checkPayWithinTheBalance() {
        SavingAccount account = new SavingAccount(1_500, 500, 2_000, 5);
        assertTrue(account.pay(300));
        assertEquals(1_200, account.getBalance());
    }


    @Test
    public void checkAddAmount() {
        SavingAccount account = new SavingAccount(1_500, 500, 2_000, 5);
        boolean result = account.add(300);
        assertEquals(true, result);
        assertEquals(1_800, account.getBalance());
    }


    @Test
    public void checkAddMinusAmount() {
        SavingAccount account = new SavingAccount(1_500, 500, 2_000, 5);
        boolean result = account.add(-300);
        assertEquals(false, result);
        assertEquals(1_500, account.getBalance());
    }

    @Test
    public void checkAddAboveMaxBalance() {
        SavingAccount account = new SavingAccount(1_500, 500, 2_000, 5);
        boolean result = account.add(600);
        assertEquals(false, result);
        assertEquals(1_500, account.getBalance());
    }

    @Test
    void checkAddAboveMaxLimitBalance() {
        SavingAccount account = new SavingAccount(1_500, 500, 2_000, 5);
        assertFalse(account.add(1000));
        assertEquals(1_500, account.getBalance());
    }


    @Test
    public void checkAddZeroAmount() {
        SavingAccount account = new SavingAccount(1_500, 500, 2_000, 5);
        boolean result = account.add(0);
        assertEquals(false, result);
        assertEquals(1_500, account.getBalance());

    }

    @Test
    public void checkYearChange() {
        SavingAccount account = new SavingAccount(1_500, 500, 2_000, 5);
        int result = account.yearChange();
        assertEquals(75, result);
    }

    @Test
    void checkYearChangeWithZeroRate() {
        SavingAccount account = new SavingAccount(1_500, 500, 2_000, 5);
        account.setRate(0);
        assertEquals(0, account.yearChange());
    }


    @Test
    void checkMinBalance() {
        SavingAccount account = new SavingAccount(1_500, 500, 2_000, 5);
        assertEquals(500, account.getMinBalance());
    }

    @Test
    void checkMaxBalance() {
        SavingAccount account = new SavingAccount(1_500, 500, 2_000, 5);
        assertEquals(2_000, account.getMaxBalance());
    }

    @Test
    void checkRate() {
        SavingAccount account = new SavingAccount(1_500, 500, 2_000, 5);
        assertEquals(5, account.getRate());
    }

}
