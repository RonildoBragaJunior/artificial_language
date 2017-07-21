package org.artificial.language.repository;

import org.artificial.language.model.WordClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("wordClassRepository")
public interface WordClassRepository extends JpaRepository<WordClass, Integer> {


}
