package rtl.tot.corp.mrex.prcn.provider.cmd.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Provider
 */
@Data
public class Provider {
    @JsonProperty("name")
    private String name;

    @JsonProperty("rut")
    private String rut;

    @JsonProperty("country")
    private String country;

    /**
     * Provider Name
     *
     * @return name
     **/
    @ApiModelProperty(example = "Apple", value = "Provider Name")

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    /**
     * Rut of Provider
     *
     * @return rut
     **/
    @ApiModelProperty(example = "24527271-5", value = "Rut of Provider")

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    /**
     * Country of product
     *
     * @return country
     **/
    @ApiModelProperty(example = "PE", value = "Country of product")

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @JsonCreator
    public Provider(    @JsonProperty("name") String name,
                        @JsonProperty("rut") String rut,
                        @JsonProperty("country") String country) {
        this.name = name;
        this.rut = rut;
        this.country = country;
    }
}
