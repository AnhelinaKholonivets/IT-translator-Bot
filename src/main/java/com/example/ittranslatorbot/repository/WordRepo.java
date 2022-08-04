package com.example.ittranslatorbot.repository;

import com.example.ittranslatorbot.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepo extends JpaRepository<Word, Long> {
    Word findByWord(String word);
}
