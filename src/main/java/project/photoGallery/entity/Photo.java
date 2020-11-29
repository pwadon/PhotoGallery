package project.photoGallery.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="photos")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(unique = true)
    private String name;

    private String type;

    @Column(columnDefinition = "LONGBLOB")
    private byte[] file;

    @ManyToOne
    @JoinColumn(name ="gallery_id")
    Gallery gallery;

    public Photo(String name,String type, byte[] file,Gallery gallery) {
        this.name = name;
        this.type = type;
        this.file = file;
        this.gallery = gallery;
    }

}
