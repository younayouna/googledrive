package googledrive.domain;

import googledrive.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class Uploaded extends AbstractEvent {

    private Long size;
    private String name;
    private String filepath;
    private String type;
    private String fildid;
}
