package csc305.metrorailabdullah;

public abstract class User {
    protected String id, name, email, password, phoneNo;

    public User(String id, String name, String email, String password, String phoneNo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNo = phoneNo;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }

    public boolean login(String id, String password) {
        if(this.id.equals(id) && this.password.equals(password)) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean resetPassword(String oldPassword, String newPassword) {
        if(this.password.equals(oldPassword)) {
            this.password = newPassword;
            return true;
        }
        else {
            return false;
        }
    }

}
