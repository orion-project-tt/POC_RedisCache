package rtl.tot.corp.mrex.prcn.provider.cmd.commons.domain;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.Data;

import java.io.Serializable;

/**
 * API response
 * 
 * @author: jameswang
 * @version: 1.0, Feb 2, 2018
 */
@Data
public class APIResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7631579479199449062L;

	@JsonPropertyDescription("response code.")
	private int					code;

	@JsonPropertyDescription("response type.")
	private String				type;

	@JsonPropertyDescription("response message.")
	private String				message;

}
