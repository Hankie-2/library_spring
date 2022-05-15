package kg.library.spring.library_spring.service;

import kg.library.spring.library_spring.dao.BookRepository;
import kg.library.spring.library_spring.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BookServiceImpl implements BookService
{
    @Autowired
    private BookRepository bookRepository;

    @Override
    public void deleteBookByTitle(String title) {
        bookRepository.deleteBookByTitle(title);
    }

    @Override
    public void insertBook(String title, Long authorId, int year, BigDecimal sellCost, BigDecimal rentCost, int amount) {
        bookRepository.insertBook(title,authorId,year,sellCost,rentCost,amount);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    @Override
    public Page<Book> findPaginated(int pageN, int pageSize,String sortField,String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageN-1,pageSize,sort);
        return bookRepository.findAll(pageable);
    }
}
