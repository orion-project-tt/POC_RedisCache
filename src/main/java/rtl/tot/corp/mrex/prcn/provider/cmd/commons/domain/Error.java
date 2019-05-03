package rtl.tot.corp.mrex.prcn.provider.cmd.commons.domain;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

/**
 * Standard structure for unexpected errors
 */
@ApiModel(description = "Standard structure for unexpected errors")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-29T21:40:10.925Z[GMT]")
public class Error   {
  @JsonProperty("userMessage")
  private String userMessage = null;

  @JsonProperty("internalMessage")
  private String internalMessage = null;

  @JsonProperty("moreInfo")
  private String moreInfo = null;

  public Error userMessage(String userMessage) {
    this.userMessage = userMessage;
    return this;
  }

  /**
   * User error message
   * @return userMessage
  **/
  @ApiModelProperty(example = "Unexpected error", required = true, value = "User error message")
  @NotNull

  public String getUserMessage() {
    return userMessage;
  }

  public void setUserMessage(String userMessage) {
    this.userMessage = userMessage;
  }

  public Error internalMessage(String internalMessage) {
    this.internalMessage = internalMessage;
    return this;
  }

  /**
   * Internal system error message
   * @return internalMessage
  **/
  @ApiModelProperty(example = "Internal error", value = "Internal system error message")

  public String getInternalMessage() {
    return internalMessage;
  }

  public void setInternalMessage(String internalMessage) {
    this.internalMessage = internalMessage;
  }

  public Error moreInfo(String moreInfo) {
    this.moreInfo = moreInfo;
    return this;
  }

  /**
   * Additional error information
   * @return moreInfo
  **/
  @ApiModelProperty(example = "Unexpected errors", value = "Additional error information")

  public String getMoreInfo() {
    return moreInfo;
  }

  public void setMoreInfo(String moreInfo) {
    this.moreInfo = moreInfo;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(this.userMessage, error.userMessage) &&
        Objects.equals(this.internalMessage, error.internalMessage) &&
        Objects.equals(this.moreInfo, error.moreInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userMessage, internalMessage, moreInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    
    sb.append("    userMessage: ").append(toIndentedString(userMessage)).append("\n");
    sb.append("    internalMessage: ").append(toIndentedString(internalMessage)).append("\n");
    sb.append("    moreInfo: ").append(toIndentedString(moreInfo)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
