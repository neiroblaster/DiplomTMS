package tms.shchayuk.audition.utility;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Answer {

    private int songId;
    private int lineId;
    private int wordId;
    private String rightAnswer;
    private String clientAnswer;
    private boolean check = false;

}

