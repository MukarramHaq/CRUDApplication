package com.example.CRUDApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private BookRepo bookRepo;

    @GetMapping("/getAllBooks")
    public ResponseEntity<List<Books>> getAllBooks(){
        List<Books> bookList = new ArrayList<>();
        bookRepo.findAll().forEach(bookList::add);
        if(bookList.isEmpty()){
            return new ResponseEntity<>(bookList, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
 
    @GetMapping("/getBookById/{id}")
    public ResponseEntity<Books> getBookById(@PathVariable Long id){
        Optional<Books> bookData = bookRepo.findById(id);
        if(bookData.isPresent()){
            return new ResponseEntity<>(bookData.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public void updateBookById(){

    }

    /* In this method we use @PostMapping annotation to create a new object in the database 
     * We'll use the repository save()method and pass "book" as the parameter. In the function 
     * argument it will return just the author and the title but, when we use the save() method
     * it will return the ID, Author and Title. This annotation lets the framework know that the
     * client sends the data to the server using HTTP requests (POST, PUT, PATCH, DELETE)
     * 
     * The @RequestBody annotation converts the HTTP request into a Java object
    */
    @PostMapping("/addBook")
    public ResponseEntity<Books> addBook(@RequestBody Books books){

        Books bookObj = bookRepo.save(books);
        return new ResponseEntity<>(bookObj, HttpStatus.OK);

    }

    public void deleteBookById(){

    }
    
}
