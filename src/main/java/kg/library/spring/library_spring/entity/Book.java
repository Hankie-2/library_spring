package kg.library.spring.library_spring.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "publishing_date")
    private Integer publishingYear;

    @Column(name = "sell_cost")
    private BigDecimal sellCost;

    @Column(name = "rent_cost")
    private BigDecimal rentCost;

    @Column(name = "amount")
    private Integer amount;

    //=======Relationships=======

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE})
    @JoinTable(name = "genre_book",joinColumns = @JoinColumn(name = "book_id"),inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres;

    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE})
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE})
    @JoinTable(name = "rented_books",
    joinColumns = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "reader_id"))
    private List<User> usersRented;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE})
    @JoinTable(name = "readed_books",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "reader_id"))
    private List<User> usersReaded;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE})
    @JoinTable(name = "sold_books",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "reader_id"))
    private List<User> usersBought;

    //=======Relationships=======


    public Book(String title, Integer publishingYear, BigDecimal sellCost, BigDecimal rentCost, Integer amount) {
        this.title = title;
        this.publishingYear = publishingYear;
        this.sellCost = sellCost;
        this.rentCost = rentCost;
        this.amount = amount;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publishingDate=" + publishingYear +
                ", sellCost=" + sellCost +
                ", rentCost=" + rentCost +
                ", amount=" + amount +
                '}';
    }

    public List<User> getUsersReaded() {
        return usersReaded;
    }

    public void setUsersReaded(List<User> usersReaded) {
        this.usersReaded = usersReaded;
    }

    public List<User> getUsersBought() {
        return usersBought;
    }

    public void setUsersBought(List<User> usersBought) {
        this.usersBought = usersBought;
    }

    public List<User> getUsersRented() {
        return usersRented;
    }

    public void setUsersRented(List<User> usersRented) {
        this.usersRented = usersRented;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Integer getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(Integer publishingYear) {
        this.publishingYear = publishingYear;
    }

    public BigDecimal getSellCost() {
        return sellCost;
    }

    public void setSellCost(BigDecimal sellCost) {
        this.sellCost = sellCost;
    }

    public BigDecimal getRentCost() {
        return rentCost;
    }

    public void setRentCost(BigDecimal rentCost) {
        this.rentCost = rentCost;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
