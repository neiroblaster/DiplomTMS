package tms.shchayuk.audition.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tms.shchayuk.audition.entity.Line;
import tms.shchayuk.audition.entity.Song;
import tms.shchayuk.audition.entity.Word;
import tms.shchayuk.audition.repository.LineRepository;
import tms.shchayuk.audition.repository.SongRepository;
import tms.shchayuk.audition.service.interfaces.LineService;
import tms.shchayuk.audition.service.interfaces.WordService;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Component
public class Strategy {

    @Autowired
    SongRepository songRepository;

    @Autowired
    LineService lineService;

    @Autowired
    WordService wordService;

    @Autowired
    private AnswersFromDAO answersFromDAO;

    @Autowired
    private Answers answers;


    public List<Word> splitAndSaveWordsBySongId(int id) {
        Song song = songRepository.findSongById(id);
        List<String> createdLines = Arrays.asList(song.getLyrics().split("\r\n"));
        List<Line> lines = new ArrayList<>();
        Line line;
        for (String savedLine : createdLines) {
            if (!savedLine.equals(""))
            {
                line = new Line();
                line.setStext(savedLine);
                lines.add(line);
                line.setSong(song);
            }
        }

        List<Word> words = new ArrayList<>();


        for (Line everyLine : lines) {
            List<String> createdWords = new ArrayList<>(Arrays.stream(everyLine.getStext()
                    .split("\\p{P}?[ \\t\\n\\r]+")).collect(Collectors.toList()));
            int wordOrder = 1;
            for (String savedWord : createdWords) {
                Word word = new Word();
                word.setWord(savedWord);
                word.setWordOrder(wordOrder);
                words.add(word);
                word.setSline(everyLine);
                wordOrder++;
            }
        }

        lineService.saveListOfLines(lines);
        wordService.saveListOfWords(words);

        return words;
    }

    public List<String> doStrategy(List<Word> allWords, List<Line> allLines) {

        answers.getAnswerList().clear();
        List<String> answersFromDAOfirst = new ArrayList<>();
        String wordToCompare = "";

        for (Line curLine : allLines) {
            Random random = new Random();
            int randomWord = random.nextInt(curLine.getListOfWords().size()) + 1;
            for (Word curWord : curLine.getListOfWords()) {
                if (curWord.getWordOrder() == randomWord) {
                    Answer answer = new Answer();
                    answer.setRightAnswer(curWord.getWord());
                    answer.setSongId(curLine.getSong().getId());
                    answer.setLineId(curLine.getId());
                    answer.setWordId(curWord.getId());

                    curWord.setShowed(false);
                    wordToCompare = curWord.getWord();
                    curWord.setWord(null);
                    answersFromDAOfirst.add(wordToCompare);

                    answers.addOneAnswer(answer);
                }
            }
        }
        answersFromDAO.setAnswersFromDAO(answersFromDAOfirst);

        return answersFromDAOfirst;
    }


}


