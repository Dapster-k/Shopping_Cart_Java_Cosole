package Model;

import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserManager {
    private Map<String,User> users;
    public UserManager() {
        users = new HashMap<>();
    }
    public boolean addNew(User customer) {
        if(users.containsKey(customer.getUserName()))
            return false;

        users.put(customer.getUserName(),customer);
        return true;
    }

    public boolean isNumberValid(String number)
    {
        /* Considering the case for indian mobile
        In India, Mobile is valid if below 3 condition is specified
         * 1) Begins with 0 or 91
         * 2) Then contains 7 or 8 or 9.
         * 3) Then contains 9 digits
         * You can change this validation as you want
         */
        Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");

        Matcher m = p.matcher(number);

        return (m.find() && m.group().equals(number));
    }

    public User addNew(String username,String password) {
        if(users.containsKey(username))
            return null;

        User user = new User(username,password);
        System.out.println("*************************************************");
        System.out.println("Complete below details");
        Scanner sc = new Scanner(System.in);

        //General User Details
        //Name
        System.out.print("Name :");
        String name = sc.nextLine();
        //Mobile No
        String mobile="";
        do{
            System.out.print("Mobile No :");
            mobile = sc.nextLine();
        }while (!isNumberValid(mobile));
        //DOB
        System.out.print("Date of Birth\nYear :");
        int year = sc.nextInt();
        System.out.print("Month :");
        int month = sc.nextInt();
        System.out.print("Date :");
        int date = sc.nextInt();
        LocalDate dob = LocalDate.of(year,month,date);
        sc.nextLine();

        //Address
        Address add = new Address();
        System.out.print("Detail Address\nHouseNo/Street/LandMark :");
        String addressLine1 = sc.nextLine();
        System.out.print("City :");
        String city = sc.next();
        System.out.print("State :");
        String state = sc.next();
        System.out.print("Country :");
        String country = sc.next();

        //set address object
        add.setAddressLine1(addressLine1);
        add.setCity(city);
        add.setState(state);
        add.setCountry(country);

        //set user object
        user.setName(name);
        user.setTelephone(mobile);
        user.setBirthday(dob);
        user.setActualAddress(add);

        users.put(user.getUserName(),user);
        return user;
    }

    // Update an existing customer
    public boolean save(User customer) {
        if(users.containsKey(customer.getUserName())){
            users.put(customer.getUserName(),customer);
            return true;
        }
        return false;
    }

    // Delete a customer from customer table by its username
    public void remove(String username) {
        users.remove(username);
    }

    public User getByUserPass(String username,String password) {
        if(users.containsKey(username)){
            if(users.get(username).getPassword().equals(password))
                return users.get(username);
        }
        return null;
    }
    // Returns a list with all customers
    public Map<String,User> getAll() {
        return users;
    }
}
