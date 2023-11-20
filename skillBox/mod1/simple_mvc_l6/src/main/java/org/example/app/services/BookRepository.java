package org.example.app.services;

import org.apache.log4j.Logger;
import org.example.web.dto.Book;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository<T> implements ProjectRepository<Book>, ApplicationContextAware {

    private final Logger logger = Logger.getLogger(BookRepository.class);
    private final List<Book> repo = new ArrayList<>();
    private ApplicationContext context;

    @Override
    public List<Book> retreiveAll() {
        return new ArrayList<>(repo);
    }

    @Override
    public void store(Book book) {
        book.setId(book.hashCode());
        logger.info("store new book: " + book);
        repo.add(book);
    }

    @Override
    public boolean removeItemById(Integer bookIdToRemove) {
        for (Book book : retreiveAll()) {
            if (book.getId().equals(bookIdToRemove)) {
                logger.info("remove book completed: " + book);
                return repo.remove(book);
            }
        }
        return false;
    }

    @Override
    public boolean removeByRegex(String regex) {
        boolean isRemoved = false;
        if (regex.contains("author")) {
            logger.info("delete by author");
            for (Book book : retreiveAll()) {
                System.out.println("---->"+regex.substring(7));
                if(book.getAuthor().equals(regex.substring(7))){
                    logger.info("remove book completed: " + book);
                    repo.remove(book);
                    isRemoved = true;
                }
            }
        } else if (regex.contains("title")) {
            logger.info("delete by title");
            for (Book book : retreiveAll()) {
                if(book.getTitle().equals(regex.substring(6))){
                    logger.info("remove book completed: " + book);
                    repo.remove(book);
                    isRemoved = true;
                }
            }

        } else if (regex.contains("size")) {
            logger.info("delete by size");
            for (Book book : retreiveAll()) {
                if(book.getSize().equals(regex.substring(5))){
                    logger.info("remove book completed: " + book);
                    repo.remove(book);
                    isRemoved = true;
                }
            }

        }
        return isRemoved;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    private void defaultInit() {
        logger.info("default INIT in book repo bean");
    }

    private void defaultDestroy() {
        logger.info("default DESTROY in book repo bean");
    }
}

