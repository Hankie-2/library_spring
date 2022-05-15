package kg.library.spring.library_spring.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "wallet")
    private Integer wallet;

    @Column(name = "enabled")
    private boolean enabled;

    @Transient
    private String confirmPassword;

    //=======Relationships=======

    @ManyToMany(mappedBy = "users")
    private List<Role> roles;

    @ManyToMany(mappedBy = "usersRented")
    private List<Book> rentedBooks;

    @ManyToMany(mappedBy = "usersBought")
    private List<Book> boughtBooks;

    @ManyToMany(mappedBy = "usersReaded")
    private List<Book> readedBooks;

    //=======Relationships=======


    public User(String login, String password, String name, String surname, String confirmPassword,Integer wallet,boolean enabled) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.confirmPassword = confirmPassword;
        this.wallet = wallet;
        this.enabled = enabled;
    }

    public User() {
    }

    public String getPassword() {
        return password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Book> getRentedBooks() {
        return rentedBooks;
    }

    public void setRentedBooks(List<Book> rentedBooks) {
        this.rentedBooks = rentedBooks;
    }

    public List<Book> getBoughtBooks() {
        return boughtBooks;
    }

    public void setBoughtBooks(List<Book> boughtBooks) {
        this.boughtBooks = boughtBooks;
    }

    public List<Book> getReadedBooks() {
        return readedBooks;
    }

    public void setReadedBooks(List<Book> readedBooks) {
        this.readedBooks = readedBooks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public Integer getWallet(){
        return this.wallet;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setWallet(Integer wallet){
        this.wallet = wallet;
    }
}
