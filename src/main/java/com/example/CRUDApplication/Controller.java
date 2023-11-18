package com.example.CRUDApplication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private BookRepo bookRepo;

    @GetMapping("/getAllBooks")
    public ResponseEntity<List<Books>> getAllBooks(){
        List<Books> bookList = new ArrayList<>();
        bookRepo.findAll().forEach(bookList::add);
        if(bookList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public void getBookById(){

    }

    public void updateBookById(){

    }

    public void addBook(){

    }

    public void deleteBookById(){

    }

}
