

import java.util.ArrayList;
import java.util.Scanner;

public class RegisterController {

    public String name;
    public String password;
    SystemController system = new SystemController();

    DB db = new DB();

    public int login(User user) {
        system = new SystemController();  
        int NumberOfUser=0;
        boolean exsist = false;        
        if (exsist == false) {//admin
            exsist = system.validation(1, user);
            NumberOfUser=1;
        } 
        if (exsist == false) {//store owner
            System.out.println("*****************owner*******************");
            exsist = system.validation(4, user);
            NumberOfUser=2;
        } 
        if (exsist == false) {//customer
            exsist = system.validation(5, user);
            NumberOfUser=3;
        }

        if (exsist == true) {

            System.out.println("Login successuful.");
        } else {
            NumberOfUser=-1;
            System.out.println("not valid login.");
        }
        return NumberOfUser;//0 as not exsist.
    }

    public boolean Register(User user,int type) {


      
        boolean exist = true;
       
        if (type == 1) {
            exist = system.validation(1, user);
            if (exist == false) {
                ArrayList<Object> x = db.Read_File(1);
                user.id = x.size() + 1;
                db.Write_file(1, user);
                System.out.println("Resgister Done.");
                return true;
            } else {
                System.out.println("this Admin already exist");
                return false;
            }

        } else if (type == 2) {
            exist = system.validation(4, user);
            if (exist == false) {
                ArrayList<Object> x = db.Read_File(1);
                user.id = x.size() + 1;
                db.Write_file(4, user);
                System.out.println("Resgister Done.");
                return true;
            } else {
                System.out.println("this Store Owner already exist");
                return false;
            }

        } else if (type == 3) {
            Customer x1=(Customer)user;
            x1.points=90;
            exist = system.validation(5, x1);
            if (exist == false) {
                ArrayList<Object> x = db.Read_File(1);
                user.id = x.size() + 1;
                db.Write_file(5, user);
                System.out.println("Resgister Done.");
                return true;
            } else {

                System.out.println("this Customer already exist");
                return false;
            }

        }
        return false;

    }

}
