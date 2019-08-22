import java.util.Date;

public class Deposit {
    public double amount;
    public Date date;
    public String account;

    Deposit(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    /*
        Effects: returns a string displaying the deposit
     */
    public String toString(){
        return "Deposit of: $" + amount + " Date: " + date + " into account: " + account;
    }
}
