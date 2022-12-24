package parking_lot.admin;

public class Account {

    private String userName;
    private String password;
    private Person person;




    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Person getPerson() {
        return person;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
