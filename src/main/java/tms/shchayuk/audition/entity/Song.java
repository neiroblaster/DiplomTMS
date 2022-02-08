package tms.shchayuk.audition.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "lyrics", length = 10000)
    private String lyrics;

    @Column(name = "link", length = 1000)
    private String link;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToMany(mappedBy ="song", cascade = CascadeType.ALL)
    List<Line> listOfLines;

}
