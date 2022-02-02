package tms.shchayuk.audition.service.interfaces;

import tms.shchayuk.audition.entity.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
     Author getAuthorNameById(int id);

     List<Author> findAll ();
}
