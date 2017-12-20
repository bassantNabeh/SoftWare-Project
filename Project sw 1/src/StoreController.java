
import java.util.ArrayList;
import java.util.Scanner;

public class StoreController {

    Product p;
    Store s;
    StoreOwner object;
    int product_id;
    DB db = new DB();


   

    public boolean AddProduct_to_Store(StoreOwner owner) {
        SystemController syste = new SystemController();
        Scanner in = new Scanner(System.in);

        if (!syste.validation(4, owner)) {
            System.out.println("sorry you is not Store owner.");
            return false;
        }

        System.out.println(" Register Done.");
        int number_of_store;
        System.out.println("");
        if(owner.Stores.size()==0){
            System.out.println("you have no store to save products in it.");
            return false;
        }else if(owner.Stores.size()==1){
            System.out.println("You will add in store of "+owner.Stores.get(0).name);
            number_of_store=0;
        }
        else {
            System.out.println("Enter the store number :");
            number_of_store=in.nextInt();
        if (number_of_store < 0 || number_of_store >= owner.Stores.size()) {
            System.out.println("You entered wrong id .sorry you can't add");
            return false;
        }
        }
         
        
        //Product prod=new Product();
        
        

        System.out.println("Enter product id:");

        int product_id = in.nextInt();

        ArrayList<Object> array = db.Read_File(2);
        /// System.out.println("*****************************************");
        ArrayList<Product> Products = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {

            Products.add((Product) array.get(i));
           // System.out.println(Products.get(i).toString());
        }
        
        
        for (int i = 0; i < Products.size(); i++) {
            if (Products.get(i).id == product_id) {
                System.out.println("Sorry this product already exist. ");
                return false;
               
            } 
        }
        
            Product prod = new Product();
            System.out.print("Enter product name:");
            prod.name = in.next();
            System.out.print("Enter product brand:");
            prod.brand = in.next();
            System.out.print("Enter product category:");
            prod.category = in.next();
            System.out.print("Enter product color:");
            prod.color = in.next();
            System.out.print("Enter product amount:");
            prod.amount = in.nextInt();
            System.out.print("Enter product points:");
            prod.points = in.nextInt();
            System.out.print("Enter product description:");
            prod.description = in.next();
            System.out.print("Enter product price:");
            prod.price = in.nextFloat();
            prod.id = product_id;
            db.Write_file(2, prod);
       // prod.id = owner.Stores.get(number_of_store).p.size() + 1;
        owner.Stores.get(number_of_store).p.add(prod);
        return true;
    }

    
    
   /* public void Addbrand_to_Store() {
        SystemController syste = new SystemController();
        Scanner in = new Scanner(System.in);
        System.out.println("Are you \n1:Admin \n2:Store owner :");
        int chose = in.nextInt();
        User user;
        if (chose == 1) {
            System.out.println("please enter your name and your password:");
            user = new Admin();
            user.name = in.next();
            user.password = in.next();
            if (!syste.validation(chose, user)) {
                System.out.println("sorry you is not Admin.");
                return;
            }
        } else if (chose == 2) {
            System.out.println("please enter your name and your password:");
            user = new StoreOwner();
            user.name = in.next();
            user.password = in.next();
            if (!syste.validation(4, user)) {
                System.out.println("sorry you is not store owner.");
                return;
            }
        } else {
            return;
        }

        System.out.println("Enter brand id:");

        int brand_id = in.nextInt();

        ArrayList<Object> array = db.Read_File(3);
        /// System.out.println("*****************************************");
        boolean exist = true;
        if (array.size() == 0) {
            exist = false;
        }
        ArrayList<Brand> Brands = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            Brands.add((Brand) array.get(i));
        }

        for (int i = 0; i < Brands.size(); i++) {
            if (Brands.get(i).id == brand_id) {
                System.out.println("Sorry this brand already exist. ");
                exist = true;
                break;
            } else {
                exist = false;
            }
        }
        if (exist == false) {
            Brand brand = new Brand();
            System.out.print("Enter brand name:");
            brand.name = in.next();
            System.out.print("Enter number of products in  brand:");
            brand.numOfProducts = in.nextInt();
            System.out.print("Enter brand products:\n");
            for (int i = 0; i < brand.numOfProducts; i++) {

                Product prod = new Product();
                System.out.print("Enter product name:");
                prod.name = in.next();
                System.out.println("Enter product id:");
                prod.id = in.nextInt();
                System.out.print("Enter product brand:");
                prod.brand = in.next();
                System.out.print("Enter product category:");
                prod.category = in.next();
                System.out.print("Enter product color:");
                prod.color = in.next();
                System.out.print("Enter product amount:");
                prod.amount = in.nextInt();
                System.out.print("Enter product points:");
                prod.points = in.nextInt();

                System.out.print("Enter product price:");
                prod.price = in.nextFloat();
                System.out.print("Enter product description:");
                prod.description = in.next();

                brand.p.add(prod);

            }

            db.Write_file(3, brand);

        }

    }*/
    
     public Product GetProductById(int Id) {
        ArrayList<Object> array = db.Read_File(2);
        Product p = null;

        ArrayList<Product> Products = new ArrayList();
        for (int i = 0; i < array.size(); i++) {
            Products.add((Product) array.get(i));
        }
        for (int i = 0; i < Products.size(); i++) {
            if (Products.get(i).id == Id) {
                System.out.println(Products.get(i).toString());
                p = Products.get(i);
                break;
            }
        }

        return p;

    }
}
