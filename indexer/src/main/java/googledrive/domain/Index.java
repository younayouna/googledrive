package googledrive.domain;

import googledrive.IndexerApplication;
import googledrive.domain.Indexed;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Index_table")
@Data
public class Index {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fileid;

    @ElementCollection
    private List<String> keywords;

    @PostPersist
    public void onPostPersist() {
        Indexed indexed = new Indexed(this);
        indexed.publishAfterCommit();
    }

    public static IndexRepository repository() {
        IndexRepository indexRepository = IndexerApplication.applicationContext.getBean(
            IndexRepository.class
        );
        return indexRepository;
    }

    public static void indexFile(Uploaded uploaded) {
        /** Example 1:  new item 
        Index index = new Index();
        repository().save(index);

        Indexed indexed = new Indexed(index);
        indexed.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(uploaded.get???()).ifPresent(index->{
            
            index // do something
            repository().save(index);

            Indexed indexed = new Indexed(index);
            indexed.publishAfterCommit();

         });
        */

    }
}
