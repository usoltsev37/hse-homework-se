package ru.hse.soundmapping.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Music")
public class Music {

    @Id
    @Column (name = "id")
    private Long id;

    @Column (name = "type")
    private String type;

    @Column (name = "genre")
    private String genre;

    @Column (name = "name")
    private String name;

    @Column (name = "author")
    private String author;

    @Column (name = "sheets_url")
    private String sheetsUrl;

    @Column (name = "price")
    private int price;

    @Column (name = "rating")
    private int sheetsRating;
}
