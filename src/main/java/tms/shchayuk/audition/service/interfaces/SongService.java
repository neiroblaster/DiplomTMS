package tms.shchayuk.audition.service.interfaces;

import tms.shchayuk.audition.entity.Song;

import java.util.List;

public interface SongService {

    List<Song> findAll ();

    void saveSong (Song song);

    void deleteSongById(int id);
}
