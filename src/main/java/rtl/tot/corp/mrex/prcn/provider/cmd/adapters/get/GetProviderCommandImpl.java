package rtl.tot.corp.mrex.prcn.provider.cmd.adapters.get;

import lombok.Data;
import rtl.tot.corp.mrex.prcn.provider.cmd.domain.Provider;
import rtl.tot.corp.mrex.prcn.provider.cmd.domain.ports.GetProviderCommand;

@Data
public class GetProviderCommandImpl implements GetProviderCommand {

	private final String rut;
	private final String name;
	private final String country;

	public GetProviderCommandImpl(Provider provider) {
		super();
		this.rut = provider.getRut();
		this.name = provider.getName();
		this.country = provider.getCountry();
	}

}