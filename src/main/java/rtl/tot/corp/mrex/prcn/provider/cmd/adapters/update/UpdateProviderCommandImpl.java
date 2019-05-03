package rtl.tot.corp.mrex.prcn.provider.cmd.adapters.update;

import lombok.Data;
import org.springframework.data.annotation.Id;
import rtl.tot.corp.mrex.prcn.provider.cmd.domain.Provider;
import rtl.tot.corp.mrex.prcn.provider.cmd.domain.ports.UpdateProviderCommand;

@Data
public class UpdateProviderCommandImpl implements UpdateProviderCommand {

	@Id
	private final String rut;
	private final String name;
	private final String country;

	public UpdateProviderCommandImpl(Provider provider) {
		super();
		this.rut = provider.getRut();
		this.name = provider.getName();
		this.country = provider.getCountry();
	}

}