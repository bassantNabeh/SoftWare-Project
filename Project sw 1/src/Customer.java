import java.util.ArrayList;

public class Customer extends User{
    ArrayList<Product> chart=new ArrayList<>();
    int points;
    int numOfCard;
    
    public Customer(){
    }

    // int credit;
    public Customer(String name, int id, String phone, String password) {
        super(name, id, phone, password);
    }
}
