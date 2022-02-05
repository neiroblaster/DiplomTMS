package tms.shchayuk.audition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tms.shchayuk.audition.entity.Word;

import java.util.List;

public interface WordRepository extends JpaRepository<Word, Integer> {

//    List<Word> getWordsBySlineId (List <Integer> lineId);

    List<Word> findWordsBySlineId (Integer id);
}
