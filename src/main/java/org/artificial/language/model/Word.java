package org.artificial.language.model;

import javax.persistence.*;

@Entity
@Table(name = "Word")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="word_id")
    private long id;

    @Column(name="name")
    private String name;

    @ManyToOne
    private WordClass wordClass;

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

    public WordClass getWordClass() {
        return wordClass;
    }

    public void setWordClass(WordClass wordClass) {
        this.wordClass = wordClass;
    }
}
