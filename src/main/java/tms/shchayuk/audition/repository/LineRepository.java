package tms.shchayuk.audition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tms.shchayuk.audition.entity.Line;

import java.util.List;

@Repository
public interface LineRepository extends JpaRepository <Line, Integer> {

    List<Line> getLineBySongId (int id);

    List<Line> findAllBySongId (int id);
}
