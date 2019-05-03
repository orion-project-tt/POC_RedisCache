package rtl.tot.corp.mrex.prcn.provider.cmd.commons.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class EventProperties {

    private String channel;
    private String commerce;
    private String country;
    private String mimeType;
    private String version;
    
}
