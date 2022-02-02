package tms.shchayuk.audition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tms.shchayuk.audition.entity.Song;
import tms.shchayuk.audition.repository.SongRepository;
import tms.shchayuk.audition.service.interfaces.SongService;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    SongRepository songRepository;

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }
}
