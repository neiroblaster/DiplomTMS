package tms.shchayuk.audition.utility;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class AnswersFromDAO {

    private List<String> answersFromDAO;

    public AnswersFromDAO() {
    }
}
