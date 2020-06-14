package object;

import java.util.Objects;

public class MyUser {
    public String id;
    public String username;
    public String realname;
    public String password;
    public String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyUser myUser = (MyUser) o;
        return Objects.equals(id, myUser.id) &&
                Objects.equals(username, myUser.username) &&
                Objects.equals(realname, myUser.realname) &&
                Objects.equals(password, myUser.password) &&
                Objects.equals(email, myUser.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, realname, password, email);
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", realname='" + realname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
