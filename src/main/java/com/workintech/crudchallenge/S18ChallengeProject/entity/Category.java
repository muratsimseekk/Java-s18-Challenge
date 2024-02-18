package com.workintech.crudchallenge.S18ChallengeProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "category",schema = "fsweb")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<Book> bookListCategory = new ArrayList<>();

    public void addBook(Book book){
        if (bookListCategory==null){
            bookListCategory=new ArrayList<>();
        }
        bookListCategory.add(book);
    }
}
