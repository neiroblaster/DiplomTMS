package tms.shchayuk.audition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tms.shchayuk.audition.entity.Line;
import tms.shchayuk.audition.entity.Word;
import tms.shchayuk.audition.repository.LineRepository;
import tms.shchayuk.audition.repository.WordRepository;
import tms.shchayuk.audition.service.interfaces.WordService;

import java.util.ArrayList;
import java.util.List;

@Service
public class WordServiceImpl implements WordService {

    @Autowired
    WordRepository wordRepository;

    @Autowired
    LineRepository lineRepository;

    @Override
    public void saveListOfWords(List<Word> words) {
        for (Word word : words) {
            wordRepository.save(word);
        }
    }

    @Override
    public List<Word> getWordsBySlineId(List<Integer> lineId) {
        List<Word> words = new ArrayList<>();
        for (Integer slineId : lineId) {
            words.addAll(wordRepository.findWordsBySlineId(slineId));
        }
        return words;
    }

    @Override
    public List<Word> findAllWordsBySlineId(Integer id) {
        return wordRepository.findWordsBySlineId(id);
    }

}
