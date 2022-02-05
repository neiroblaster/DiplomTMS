package tms.shchayuk.audition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tms.shchayuk.audition.entity.Line;
import tms.shchayuk.audition.repository.LineRepository;
import tms.shchayuk.audition.service.interfaces.LineService;

import java.util.ArrayList;
import java.util.List;

@Service
public class LineServiceImpl implements LineService {

    @Autowired
    LineRepository lineRepository;

    @Override
    public void saveListOfLines(List<Line> lines) {
        for (Line line : lines) {
            lineRepository.save(line);
        }
    }

    @Override
    public List<Integer> getLinesIdBySongId(int id) {
        List<Line> linesFromDB = lineRepository.findAllBySongId(id);
        List<Integer> linesId = new ArrayList<>();
        for (Line lineFromDB : linesFromDB){
            linesId.add(lineFromDB.getId());
        }
        return linesId;
    }

    @Override
    public List<Line> findAllBySongId(int id) {
        return lineRepository.findAllBySongId(id);
    }
}
