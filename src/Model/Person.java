package Model;

public abstract class Person {
    private int         id;
    private String      username;
    private String      password;
    public Person() {
    }
    private void setId(int id) {
        this.id = id;
    }
    public Person(String username, String password) {
        this.setUserName(username);
        this.setPassword(password);
        this.setId(username.hashCode());
    }
    public int getId() {
        return id;
    }
    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
