import java.util.Date;

public class Withdraw {
    public double amount;
    public Date date;
    public String account;

    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    /*
        Effects: return a string displaying the withdraw
     */
    public String toString(){
        return "Withdraw of: $" + amount + " Date: " + date + " into account: " + account;
    }
}
