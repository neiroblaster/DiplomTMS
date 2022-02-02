package tms.shchayuk.audition.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "lyrics", length = 1500)
    private String lyrics;

    @Column(name = "link")
    private String link;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToMany(mappedBy ="song", cascade = CascadeType.ALL)
    List<Line> listOfLines;

}
