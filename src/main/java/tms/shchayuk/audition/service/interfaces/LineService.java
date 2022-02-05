package tms.shchayuk.audition.service.interfaces;

import tms.shchayuk.audition.entity.Line;

import java.util.List;

public interface LineService {

    void saveListOfLines(List<Line> lines);

    List<Integer> getLinesIdBySongId(int id);

    List<Line> findAllBySongId(int id);
}
