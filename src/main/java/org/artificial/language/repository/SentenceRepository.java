package org.artificial.language.repository;


import org.artificial.language.model.Sentence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("sentenceRepository")
public interface SentenceRepository extends JpaRepository<Sentence, Integer> {

}
