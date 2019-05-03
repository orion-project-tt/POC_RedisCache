package rtl.tot.corp.mrex.prcn.provider.cmd.adapters.create;

import lombok.Data;
import rtl.tot.corp.mrex.prcn.provider.cmd.domain.Provider;
import rtl.tot.corp.mrex.prcn.provider.cmd.domain.ports.CreateProviderCommand;

@Data
public class CreateProviderCommandImpl implements CreateProviderCommand {

	private final String rut;
	private final String name;
	private final String country;

	public CreateProviderCommandImpl(Provider provider) {
		super();
		this.rut = provider.getRut();
		this.name = provider.getName();
		this.country = provider.getCountry();
	}

}