
import java.util.ArrayList;
import java.util.Scanner;

public class SystemController {

    public boolean validation(int chose, User user) {
        ArrayList<Object> Users = new ArrayList<Object>();
        DB ourData = new DB();
        if (chose == 1) {
            ArrayList<Admin> use = new ArrayList<>();
            Users = ourData.Read_File(1);
            //System.out.println("size =" + Users.size());
            for (int i = 0; i < Users.size(); i++) {
                // System.out.println(" user = " + Users.get(i).toString());
                use.add((Admin) Users.get(i));
            }
            for (int i = 0; i < use.size(); i++) {
                // System.out.println("user.password = " + user.password + "use.get(i).password= " + use.get(i).password);
                //System.out.println(" use.get(i).name= " + use.get(i).name);
                if (use.get(i).password.equals(user.password) && use.get(i).name.equals(user.name)) {
                    System.out.println("OK");
                    return true;
                }
            }
        }
        if (chose == 4) {
            ArrayList<StoreOwner> use = new ArrayList<>();
            Users = ourData.Read_File(4);
            for (int i = 0; i < Users.size(); i++) {
                // System.out.println(" user = " + Users.get(i).toString());
                use.add((StoreOwner) Users.get(i));
            }
            //System.out.println("size = " + Users.size());
            // System.out.println(user.toString());
            for (int i = 0; i < Users.size(); i++) {
                System.out.println("user.password = " + user.password + "use.get(i).password= " + use.get(i).password);
                System.out.println(" use.get(i).name= " + use.get(i).name);
                if (use.get(i).password.equals(user.password) && use.get(i).name.equals(user.name)) {
                    System.out.println("OK");
                    return true;
                }
            }
        }
        if (chose == 5) {
            ArrayList<Customer> use = new ArrayList<>();
            Users = ourData.Read_File(5);
            for (int i = 0; i < Users.size(); i++) {
                //System.out.println(" user = " + Users.get(i).toString());
                use.add((Customer) Users.get(i));
            }
            for (int i = 0; i < Users.size(); i++) {
                // System.out.println("user.password = " + user.password + "use.get(i).password= " + use.get(i).password);
                // System.out.println(" use.get(i).name= " + use.get(i).name);
                if (use.get(i).password.equals(user.password) && use.get(i).name.equals(user.name)) {
                    System.out.println("OK");
                    return true;
                }
            }

        }
        return false;
    }

    public boolean AddProduct_to_System(Admin admin) {
        SystemController syste = new SystemController();
        DB db = new DB();
        Scanner in = new Scanner(System.in);

        if (!syste.validation(1, admin)) {
            System.out.println("sorry you is not Admin.");
            return false;
        }

        System.out.println(" Register Done.");
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

        return true;

    }

    public boolean Addbrand_to_System(Admin admin) {
        SystemController syste = new SystemController();
        DB db = new DB();
        Scanner in = new Scanner(System.in);
        if (!syste.validation(1, admin)) {
            System.out.println("sorry you is not Admin.");
            return false;
        }

        ArrayList<Object> array = db.Read_File(3);
        int brand_id = array.size() + 1;
        Brand brand = new Brand();
        System.out.print("Enter brand name:");
        brand.name = in.next();
        System.out.print("Enter number of products in  brand:");
        brand.numOfProducts = in.nextInt();

        System.out.print("Enter brand products:\n");

        for (int i = 0; i < brand.numOfProducts; i++) {
            //Product prod = new Product();
            while (!AddProduct_to_System(admin)) {
                System.out.println("You have other change to enter this product.");
            }

            ArrayList<Object> array1 = db.Read_File(2);
            /// System.out.println("*****************************************");
            ArrayList<Product> Products = new ArrayList<>();
            for (int k = 0; k < array1.size(); k++) {

                Products.add((Product) array1.get(k));
                // System.out.println(Products.get(i).toString());
            }
            /* Product prod = new Product();
            System.out.print("Enter product name:");
            prod.name = in.next();
            prod.id =product_id; ;//outo increment
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
            prod.description = in.next();*/

            brand.p.add(Products.get(Products.size() - 1));
        }

        db.Write_file(3, brand);

        return true;
    }

    public boolean AddStore_to_System(StoreOwner owner) {
        SystemController syste = new SystemController();
        DB db = new DB();
        Scanner in = new Scanner(System.in);
        if (!syste.validation(1, owner)) {
            System.out.println("sorry you are not store owner.");
            return false;
        }

        // ArrayList<Object> array = db.Read_File(6);//for stoews.
        int brand_id = owner.Stores.size() + 1;
        Store store = new Store();
        System.out.print("Enter brand name:");
        store.name = in.next();
        System.out.print("Enter number of products in  brand:");
        store.numOfProducts = in.nextInt();
        System.out.print("Enter brand products:\n");
        for (int i = 0; i < store.numOfProducts; i++) {

            Product prod = new Product();
            System.out.print("Enter product name:");
            prod.name = in.next();
            prod.id = i;//outo increment
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

            store.p.add(prod);
        }
        owner.Stores.add(store);
        //db.Write_file(6, store);

        return true;
    }

}
