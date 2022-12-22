package tms.shchayuk.audition.utility;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Result {

    private int percent;
    private int width;
    private int numberOfRightAnswers;
    private int numberOfAllWords;
    private String color;
}
