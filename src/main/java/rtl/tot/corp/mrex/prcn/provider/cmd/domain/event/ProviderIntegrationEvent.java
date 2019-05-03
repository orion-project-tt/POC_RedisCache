package rtl.tot.corp.mrex.prcn.provider.cmd.domain.event;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.data.annotation.Id;
import rtl.tot.corp.mrex.prcn.provider.cmd.commons.infraestructure.EventDomain;

@Data
@JsonIgnoreProperties({"mapper", "entityType"})
public class ProviderIntegrationEvent implements EventDomain {
    @JsonProperty("name")
    private String name = null;

    @Id
    @JsonProperty("rut")
    private String rut = null;

    @JsonProperty("country")
    private String country = null;
	private final ObjectMapper mapper = new ObjectMapper();
	 
		
	@Override
	@JsonIgnore
	public String getEntityId() {
		// TODO Auto-generated method stub
		return rut;
	}

	@Override
	@JsonIgnore
	public String getMetadata() {
		String jsonValue;
        try {
            jsonValue = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            jsonValue = super.toString();
        }
        return jsonValue;
	}

	@Override
	public String getEntityType() {
		return getClass().getName();
	}

	

	public ObjectMapper getMapper() {
		return mapper;
	}

	


	
	
}
