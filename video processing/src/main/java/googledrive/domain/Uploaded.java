package googledrive.domain;

import googledrive.domain.*;
import googledrive.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Uploaded extends AbstractEvent {

    private Long size;
    private String name;
    private String filepath;
    private String type;
    private String fildid;
}
