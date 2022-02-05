package tms.shchayuk.audition.service.interfaces;

import tms.shchayuk.audition.entity.Line;
import tms.shchayuk.audition.entity.Word;

import java.util.List;

public interface WordService {

    void saveListOfWords(List<Word> words);

    List<Word> getWordsBySlineId(List<Integer> lineId);

    List<Word> findAllWordsBySlineId(Integer id);
}
