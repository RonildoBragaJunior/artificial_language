package org.artificial.language.repository;

import org.artificial.language.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("wordRepository")
public interface WordRepository extends JpaRepository<Word, Integer> {

    Word findByName(String name);

}
