package tms.shchayuk.audition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tms.shchayuk.audition.entity.Song;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {

    List<Song> findAll();

//    Song findById(int id);
//
//    void saveOrUpdateById(int id);
//
//    void deleteById(int id);
}
