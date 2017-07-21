package org.artificial.language.model;

import javax.persistence.*;

@Entity
@Table(name = "word_class")
public class WordClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="word_class_id")
    private long id;

    @Column(name="name")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
