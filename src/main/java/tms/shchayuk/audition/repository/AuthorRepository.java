package tms.shchayuk.audition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tms.shchayuk.audition.entity.Author;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    public Author findById (int id);

    public List<Author> findAll();
}
