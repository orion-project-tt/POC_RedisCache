package rtl.tot.corp.mrex.prcn.provider.cmd.adapters.create;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rtl.tot.corp.mrex.prcn.provider.cmd.commons.ports.Handler;
import rtl.tot.corp.mrex.prcn.provider.cmd.services.ProviderService;

@Slf4j
@Component
public class CreateProviderHandler implements Handler<CreateProviderCommandImpl> {

	@Autowired
	ProviderService service;

	public CreateProviderHandler(ProviderService service) {
		this.service = service;
	}

	
	@Override
	public boolean handle(CreateProviderCommandImpl cmd) throws Exception {
		return service.addProvider(cmd);
		
	}

}
