import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    public int accountNumber;
    public ArrayList<Deposit> deposits;
    public ArrayList<Withdraw> withdraws;
    public double checkBalance;
    public double savingBalance;
    public double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    public Customer() {
        deposits = new ArrayList<>();
        withdraws = new ArrayList<>();
        checkBalance = 0;
        savingBalance = 0;
        savingRate = 0;
        name = "";
    }

    public Customer(int accountNumber, double checkBalance, double savingBalance, String name) {
        this.accountNumber = accountNumber;
        this.checkBalance = checkBalance;
        this.savingBalance = savingBalance;
        this.name = name;
    }

    /*
        Requires: double amt >= 0, account == "Saving" or "Checking"
        Modifies: this, deposits, checkBalance or savingBalance,
        Effects: adds amt to balance, adds the deposit to the list of deposits
     */
    public double deposit(double amt, Date date, String account) {
        Deposit newDeposit = new Deposit(amt, date, account);
        deposits.add(newDeposit);

        if (account == "Checking") {
            checkBalance += amt;
        } else if (account == "Saving") {
            savingBalance += amt;
        }

        return 0;
    }

    /*
        Requires: double amt >= 0, account == "Saving" or "Checking"
        Modifies: this, withdraws, checkBalance or savingBalance,
        Effects: if there is not overdraft, adds amt to the balance, and adds the withdrawal to the list
     */
    public double withdraw(double amt, Date date, String account) {
        if (checkOverdraft(amt, account)) {
            return 0;
        }

        Withdraw newWithdraw = new Withdraw(amt, date, account);
        withdraws.add(newWithdraw);

        if (account == "Checking") {
            checkBalance -= amt;
        } else if (account == "Saving") {
            savingBalance -= amt;
        }

        return 0;
    }

    /*
        Requires: double amt >= 0, account == "Checking" or "Saving"
        Effects: returns true if amt is bigger than balance
     */
    private boolean checkOverdraft(double amt, String account) {
        if ((account == "Checking" && amt > checkBalance) ||
                (account == "Saving" && amt > savingBalance)) {
            return true;
        }
        return false;
    }



    // do not modify
    public void displayDeposits() {
        for (Deposit d : deposits) {
            System.out.println(d);
        }
    }

    // do not modify
    public void displayWithdraws() {
        for (Withdraw w : withdraws) {
            System.out.println(w);
        }
    }

}

