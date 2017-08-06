package org.artificial.language.model;

import javax.persistence.*;

@Entity
@Table(name = "word_sentence")
public class WordSentence {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "word_sentence_id")
    private long id;

    @ManyToOne
    private Word word;

    @ManyToOne
    private Sentence sentence;

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public Sentence getSentence() {
        return sentence;
    }

    public void setSentence(Sentence sentence) {
        this.sentence = sentence;
    }
}
