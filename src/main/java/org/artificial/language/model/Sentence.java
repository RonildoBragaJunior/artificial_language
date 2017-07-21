package org.artificial.language.model;

import javax.persistence.*;

@Entity
@Table(name = "Sentence")
public class Sentence {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="sentence_id")
    private long id;

    @Column(name="name")
    private String name;

    @ManyToOne
    private Word word;

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

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }
}
