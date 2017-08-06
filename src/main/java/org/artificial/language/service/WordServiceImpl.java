package org.artificial.language.service;

import org.artificial.language.model.Word;
import org.artificial.language.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service("wordService")
public class WordServiceImpl implements WordService{

    @Autowired
    private WordRepository wordRepository;

    @PersistenceContext
    private EntityManager em;

    public Word findByName(String name) {
        return wordRepository.findByName(name);
    }
}
