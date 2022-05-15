package kg.library.spring.library_spring.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "birthday")
    private Date birthday;

    //=======Relationships=======

    @OneToMany(mappedBy = "author")
    private List<Book> books=new ArrayList<>();

    //=======Relationships=======

    public Author() {
    }


    @Override
    public String toString() {
        return "Author{" +
                "fullname='" + fullname + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<Book> getBooks() {
        return books;
    }


    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
