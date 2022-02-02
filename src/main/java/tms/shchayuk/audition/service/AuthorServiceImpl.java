package tms.shchayuk.audition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tms.shchayuk.audition.entity.Author;
import tms.shchayuk.audition.repository.AuthorRepository;
import tms.shchayuk.audition.service.interfaces.AuthorService;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    
    @Autowired
    private AuthorRepository authorRepository;
    
    @Override
    public Author getAuthorNameById(int id) {
        return authorRepository.findById(id);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }
}
