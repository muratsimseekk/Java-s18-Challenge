package com.workintech.crudchallenge.S18ChallengeProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "author" , schema = "fsweb")
public class Author {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "author" , cascade = CascadeType.ALL)
    private List<Book> bookListAuthor ;

    public void addBook(Book book){
        if (bookListAuthor == null){
            bookListAuthor=new ArrayList<>();
        }
        bookListAuthor.add(book);
    }
}
