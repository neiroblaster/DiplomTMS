package tms.shchayuk.audition.utility;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class Answers {

    private List<Answer> answerList = new ArrayList<>();

    public void addOneAnswer (Answer answer){
        answerList.add(answer);
    }
}
