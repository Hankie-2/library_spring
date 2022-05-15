package kg.library.spring.library_spring.dao;

import kg.library.spring.library_spring.entity.Book;
import kg.library.spring.library_spring.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface BookRepository  extends JpaRepository<Book,Long> {

    @Query(value = "DELETE FROM books WHERE title = ?",nativeQuery = true)
    void deleteBookByTitle(String title);

    @Query(value = "INSERT INTO books(title,author_id,publishing_year,sell_cost,rent_cost,amount)" +
                    "VALUES(?1,?2,?3,?4,?5,?6)",nativeQuery = true)
    void insertBook(String title, Long authorId, int year, BigDecimal sellCost,BigDecimal rentCost,int amount);

    @Query(value = "SELECT b.title,a.fullname, b.publishing_year,b.sell_cost,b.rent_cost,b.amount FROM books b INNER JOIN author a on b.author_id = a.id",nativeQuery = true)
    List<Book> getAll();

}
