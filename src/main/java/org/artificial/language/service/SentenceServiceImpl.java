package org.artificial.language.service;


import org.artificial.language.model.Sentence;
import org.artificial.language.model.Word;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service("sentenceService")
public class SentenceServiceImpl implements SentenceService{

    @PersistenceContext
    private EntityManager em;

    public List<Sentence> listByWord(Word word){
        StringBuffer queryBuffer = new StringBuffer();
        queryBuffer.append(" SELECT table1 FROM Sentence table1");
        queryBuffer.append(" JOIN table1.word word");
        queryBuffer.append(" where word.id = :word_id");

        TypedQuery<Sentence> query = em.createQuery(queryBuffer.toString(), Sentence.class);
        query = query.setParameter("word_id", word.getId());
        return query.getResultList();
    }
}