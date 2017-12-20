
import java.util.ArrayList;

public class StoreOwner extends User {

    Wallet wallet = new Wallet();
    ArrayList<Store> Stores = new ArrayList<>();

    public StoreOwner() {
    }

    // int credit;
    public StoreOwner(String name, int id, String phone, String password) {
        super(name, id, phone, password);
    }
    
    public StoreOwner(String name, int id, String phone, String password, ArrayList<Store> Stores) {

        super(name, id, phone, password);
        this.Stores = Stores;
    }

    public void explore_number_showproduct() {

        ArrayList<Product> Users = new ArrayList<Product>();//for products
        User = D.Read_File(2);
        for (int i = 0; i < User.size(); i++) {
            Users.add((Product) User.get(i));
        }
        for (int i = 0; i < Users.size(); i++) {
            System.out.println(Users.get(i).count);
        }

    }

    public void Explore_number_showproduct(StoreOwner owner) {

        // ArrayList<Product> Users = new ArrayList<Product>();//for products
        //User = D.Read_File(2);
        for (int j = 0; j < owner.Stores.size(); j++) {
            System.out.println("Store :" + owner.Stores.get(j).name);
            for (int i = 0; i < owner.Stores.get(j).p.size(); i++) {
                System.out.println(owner.Stores.get(j).p.get(i).count);
            }
        }

    }

    public Product Getmax_number_showproduct(StoreOwner owner) {
        int max = 0;
        Product prod=new Product();
        int index=-1;
        if (owner.Stores.get(0).p.size() != 0) {
                max = owner.Stores.get(0).p.get(0).count;
                index=0;
                prod=owner.Stores.get(0).p.get(0);
            }
        index=-1;
        for (int j = 0; j < owner.Stores.size(); j++) {
            //System.out.println("Store :" + owner.Stores.get(j).name); 
            for (int i = 0; i < owner.Stores.get(j).p.size(); i++) {
                if (max < owner.Stores.get(j).p.get(i).count) {
                    max = owner.Stores.get(j).p.get(i).count;
                    index=i;
                }
                //System.out.println(owner.Stores.get(j).p.get(i).count);
                
            }
            if(index!=-1){
                prod=owner.Stores.get(j).p.get(index);
            }
            
        }
        
        return prod;
    }

    public int getmax_number_showproduct() {

        ArrayList<Product> Users = new ArrayList<Product>();
        User = D.Read_File(2);
        for (int i = 0; i < User.size(); i++) {
            Users.add((Product) User.get(i));

        }
        int max = Users.get(0).count;
        for (int i = 0; i < Users.size(); i++) {
            if (max < Users.get(i).count) {
                max = Users.get(i).count;
            }
        }
        return max;

    }
    
    public boolean suggest(String productName)
    {
        ArrayList<Product> Users = new ArrayList<Product>();
        User = D.Read_File(2);
        for(int i=0; i<User.size(); i++)
        {
            Users.add((Product) User.get(i));
        }
        ArrayList<String> Users1 = new ArrayList<String>();
        User = D.Read_File(6);
        for(int i=0; i<User.size(); i++)
        {
            Users1.add((String) User.get(i));
        }
        Product p = new Product();
        for(int i=0; i<Users.size(); i++)
        {
            System.out.println("Users.get(i).name ="+Users.get(i).name);
            if(Users.get(i).name.equals(productName))
            {
                System.out.println("This Product is already exist in products.");
                return  false;
            }
        }
        for(int i=0; i<Users1.size(); i++)
        {
            System.out.println("Users1.get(i) ="+Users1.get(i));
            if(Users1.get(i).equals(productName))
            {
                System.out.println("This Product is already existin suggestion.");
                return  false;
            }
        }
        
        System.out.println("Saved Suggestion success.");
        D.Write_file(6, productName);
        return true;
    }

}
