package rtl.tot.corp.mrex.prcn.provider.cmd.adapters.update;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rtl.tot.corp.mrex.prcn.provider.cmd.commons.ports.Handler;
import rtl.tot.corp.mrex.prcn.provider.cmd.services.ProviderService;

@Slf4j
@Component
public class UpdateProviderHandler implements Handler<UpdateProviderCommandImpl> {

	@Autowired
	ProviderService service;

	public UpdateProviderHandler(ProviderService service) {
		this.service = service;
	}

	
	@Override
	public boolean handle(UpdateProviderCommandImpl cmd) throws Exception {
		return service.updateProvider(cmd);
		
	}

}
