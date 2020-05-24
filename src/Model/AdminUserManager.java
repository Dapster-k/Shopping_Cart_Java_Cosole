package Model;

import java.util.HashMap;
import java.util.Map;

public class AdminUserManager {
    private Map <String,AdminUser> adminUsers;
    public AdminUserManager()
    {
        adminUsers = new HashMap<>();
    }
    public boolean addNew(AdminUser customer) {
        if(adminUsers.containsKey(customer.getUserName()))
            return false;

        adminUsers.put(customer.getUserName(),customer);
        return true;
    }
    public boolean addNew(String username,String password) {
        if(adminUsers.containsKey(username))
            return false;

        AdminUser user = new AdminUser(username,password);
        adminUsers.put(user.getUserName(),user);
        return true;
    }
    // Update an existing customer
    public boolean save(AdminUser customer) {
        if(adminUsers.containsKey(customer.getId())){
            adminUsers.put(customer.getUserName(),customer);
            return true;
        }
        return false;
    }

    // Delete a customer from customer table by its id
    public void remove(String username) {
        adminUsers.remove(username);
    }

    public AdminUser getByUserPass(String username,String password) {
        if(adminUsers.containsKey(username)){
            if(adminUsers.get(username).getPassword().equals(password))
                return adminUsers.get(username);
        }
        return null;
    }
}
