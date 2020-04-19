package model.user;

import javax.persistence.*;
import javax.validation.GroupSequence;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Users")
public class User {


    @Id
    @Column(name = "username")
    @NotEmpty(message = "Это поле обязательное")
    private String login;

    @NotEmpty(message = "Это поле обязательное")
    @Column(name = "password")
    private String password;

    @Transient
    @NotEmpty(message = "Это поле обязательное")
    private String passwordRepeat;

    @NotEmpty(message = "Это поле обязательное")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Это поле обязательное")
    @Column(name = "surname")
    private String surname;

    @NotEmpty(message = "Это поле обязательное")
    @Column(name = "mail")
    private String mail;

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }
}
