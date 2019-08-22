import javafx.concurrent.Worker;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.assertEquals;

public class CustomerTests {
    Customer customer;
    Deposit checkDeposit;
    Deposit saveDeposit;
    Withdraw checkWithdraw;
    Withdraw saveWithdraw;
    Date date;

    @Before
    public void setUp() {
        customer = new Customer();
        date = new Date(119, 07, 21);
        checkDeposit = new Deposit(1.2, date, "Checking");
        saveDeposit = new Deposit(1.2, date, "Saving");
        checkWithdraw = new Withdraw(1.2, date, "Checking");
        saveWithdraw = new Withdraw(1.2, date, "Saving");
    }

    @Test
    public void testDepositToString() {
        String expectedCheck = "Deposit of: $1.2 Date: Wed Aug 21 00:00:00 PDT 2019 into account: Checking";
        assertEquals(checkDeposit.toString(), expectedCheck);

        String expectedSave = "Deposit of: $1.2 Date: Wed Aug 21 00:00:00 PDT 2019 into account: Saving";
        assertEquals(saveDeposit.toString(), expectedSave);
    }

    @Test
    public void testWithdrawToString() {
        String expectedCheck = "Withdraw of: $1.2 Date: Wed Aug 21 00:00:00 PDT 2019 into account: Checking";
        assertEquals(checkWithdraw.toString(), expectedCheck);

        String expectedSave = "Withdraw of: $1.2 Date: Wed Aug 21 00:00:00 PDT 2019 into account: Saving";
        assertEquals(saveWithdraw.toString(), expectedSave);
    }

    @Test
    public void testCustomerWithdraw() {
        customer.checkBalance = 2.2;
        customer.savingBalance = 2.2;

        // "Checking" withdraw
        customer.withdraw(checkWithdraw.amount, checkWithdraw.date, checkWithdraw.account);
        // check balance
        assertEquals(customer.checkBalance, 2.2 - 1.2);
        // check only one withdraw is added to the list
        assertEquals(customer.withdraws.size(), 1);
        // check the withdraw is added to the list
        assertEquals(customer.withdraws.get(0).toString(), checkWithdraw.toString());

        // "Saving" withdraw
        customer.withdraw(saveWithdraw.amount, saveWithdraw.date, saveWithdraw.account);
        // check balance
        assertEquals(customer.savingBalance, 2.2 - 1.2);
        // check only one withdraw is added to the list
        assertEquals(customer.withdraws.size(), 2);
        // check the withdraw is added to the list
        assertEquals(customer.withdraws.get(1).toString(), saveWithdraw.toString());

        // checking the case in which we don't withdraw money because there is overdraft for checking account
        customer.withdraw(checkWithdraw.amount, checkWithdraw.date, checkWithdraw.account);
        // the balance should be the same
        assertEquals(customer.checkBalance, 2.2 - 1.2);
        // check the size hasn't changed
        assertEquals(customer.withdraws.size(), 2);
        // check the withdraws list is the same
        assertEquals(customer.withdraws.get(0).toString(), checkWithdraw.toString());
        assertEquals(customer.withdraws.get(1).toString(), saveWithdraw.toString());

        // checking the case in which we don't withdraw money because there is overdraft for saving account
        customer.withdraw(saveWithdraw.amount, saveWithdraw.date, saveWithdraw.account);
        // the balance should be the same
        assertEquals(customer.savingBalance, 2.2 - 1.2);
        // check the size hasn't changed
        assertEquals(customer.withdraws.size(), 2);
        // check the withdraws list is the same
        assertEquals(customer.withdraws.get(0).toString(), checkWithdraw.toString());
        assertEquals(customer.withdraws.get(1).toString(), saveWithdraw.toString());
    }

    @Test
    public void testCustomerDeposit() {
        customer.deposit(checkDeposit.amount, checkDeposit.date, checkDeposit.account);
        assertEquals(customer.checkBalance, 1.2);
        assertEquals(customer.deposits.size(), 1);
        assertEquals(customer.deposits.get(0).toString(), checkDeposit.toString());

        customer.deposit(saveDeposit.amount, saveDeposit.date, saveDeposit.account);
        assertEquals(customer.savingBalance, 1.2);
        assertEquals(customer.deposits.size(), 2);
        assertEquals(customer.deposits.get(1).toString(), saveDeposit.toString());
    }
}
