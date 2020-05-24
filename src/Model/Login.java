package Model;

public class Login {
    public static enum LoginType{
        Login,
        SignUp
    }
    public static enum UserType{
        Admin,
        User
    }
    private UserManager users;
    private AdminUserManager admin;
    public Login(){
        users = new UserManager();
        admin = new AdminUserManager();
        admin.addNew("admin","admin");
    }
    public UserManager getUserManger(){
        return users;
    }
    public AdminUserManager getAdminUserManager(){
        return admin;
    }
    public Person LoginCheck(String user,String pass,UserType type){
        if(type == UserType.Admin){
            return admin.getByUserPass(user,pass);
        }
        else {
            return users.getByUserPass(user,pass);
        }
    }
}
