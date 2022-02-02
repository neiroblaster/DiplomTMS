package tms.shchayuk.audition.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "words")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "wordOrder")
    private int wordOrder;

    @Column(name = "word")
    private String word;

    @Column(name = "showed")
    private boolean showed = true;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sline_id")
    private Line sline;

}
