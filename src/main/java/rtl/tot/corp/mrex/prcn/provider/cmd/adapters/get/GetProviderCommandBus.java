package rtl.tot.corp.mrex.prcn.provider.cmd.adapters.get;


import org.springframework.stereotype.Component;
import rtl.tot.corp.mrex.prcn.provider.cmd.commons.ports.CommandBus;
import rtl.tot.corp.mrex.prcn.provider.cmd.domain.Provider;
import rtl.tot.corp.mrex.prcn.provider.cmd.domain.ports.CacheBus;

import java.util.List;

@Component
public class GetProviderCommandBus implements CacheBus<GetProviderCommandImpl> {


	GetProviderHandler handler;

	public GetProviderCommandBus(GetProviderHandler handler) {
		super();
		this.handler = handler;
	}


	@Override
	public List<Provider> execute() throws Exception {
	 	return handler.handle();
		
	}






    
}