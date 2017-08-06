package org.artificial.language.service;


import org.artificial.language.model.Sentence;
import org.artificial.language.model.Word;

import java.util.List;

public interface SentenceService {

    public List<Sentence> listByWord(Word word);
}
