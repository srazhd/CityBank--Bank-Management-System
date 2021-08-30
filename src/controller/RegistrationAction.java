package controller;

import model.RegistrationModel;


public class RegistrationAction {

    public RegistrationAction(String name, String email, String username, String password) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }
    private String name;
    private String email;
    private String username;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String insertReg(RegistrationAction ra) throws Exception{
        RegistrationModel rm= new RegistrationModel();
        if (rm.insertintoRegistration(ra)) {
            return "Registration Successful!!";

        } else {
            return "Registration Unsuccessful!!";

        }
        
    }
}
