package tms.shchayuk.audition.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "slines")
public class Line {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "stext")
    private String stext;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "song_id")
    private Song song;

    @OneToMany(mappedBy = "sline", cascade = CascadeType.ALL)
    List<Word> listOfWords;

}
