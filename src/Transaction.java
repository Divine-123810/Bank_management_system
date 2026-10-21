import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String type;
    private double amount;
    private LocalDateTime date;

    public Transaction (String type,double amount) {
        this.type = type;
        this.amount = amount;
        this.date = LocalDateTime.now();
    }
    public void display(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.println(date.format(format) + " | " + type + " | " + amount + " RWf");
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type='" + type + '\'' +
                ", amount=" + amount +
                '}';
    }
}
