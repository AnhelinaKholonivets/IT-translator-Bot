package com.example.ittranslatorbot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Word {

    /**
     * When creating a POJO object, we use a white line to separate fields in it.
     * Also, there is needed to be added overrided toString(), equals() and hashCode() methods.
     * Comments on what this class is used for and what each of the fields is responsible for.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String word;

    private String val;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return Objects.equals(id, word1.id) && Objects.equals(word, word1.word) && Objects.equals(val, word1.val);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, word, val);
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", val='" + val + '\'' +
                '}';
    }
}
