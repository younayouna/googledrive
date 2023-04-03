package googledrive.domain;

import googledrive.DriveApplication;
import googledrive.domain.Uploaded;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "File_table")
@Data
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long size;

    private String name;

    private String filepath;

    private String type;

    private String fileid;

    @PostPersist
    public void onPostPersist() {
        Uploaded uploaded = new Uploaded(this);
        uploaded.publishAfterCommit();
    }

    public static FileRepository repository() {
        FileRepository fileRepository = DriveApplication.applicationContext.getBean(
            FileRepository.class
        );
        return fileRepository;
    }
}
