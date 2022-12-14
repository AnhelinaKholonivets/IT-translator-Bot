package com.example.ittranslatorbot.service;

import com.example.ittranslatorbot.repository.WordRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WordService {
    private final WordRepo wordRepo;

    public WordService(WordRepo wordRepo) {
        this.wordRepo = wordRepo;
    }

    /**
     * // This is a method of getting the meaning of the word from DB
     * Gets the meaning of the word from DB
     *
     * @param word is key for search
     * @return word meaning
     * @exception NullPointerException if word is not found
     */
    public String getWordMeaning(String word) {
        try {
            return wordRepo.findByWord(word).getVal();
        } catch (NullPointerException e) {
            return "Ой, та я й сам не знаю таких слів";
        } catch (Exception e) { // really not good way to use Exception. With this you can skip many exceptions which have to be fixed.
            log.error("Exception: ", e);
            return "Спробуй пізніше";
        }
    }
}
