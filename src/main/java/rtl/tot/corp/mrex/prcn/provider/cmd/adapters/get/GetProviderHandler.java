package rtl.tot.corp.mrex.prcn.provider.cmd.adapters.get;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rtl.tot.corp.mrex.prcn.provider.cmd.commons.ports.Handler;
import rtl.tot.corp.mrex.prcn.provider.cmd.domain.Provider;
import rtl.tot.corp.mrex.prcn.provider.cmd.domain.ports.HandlerCache;
import rtl.tot.corp.mrex.prcn.provider.cmd.services.ProviderService;

import java.util.List;

@Slf4j
@Component
public class GetProviderHandler implements HandlerCache {

	@Autowired
	ProviderService service;

	public GetProviderHandler(ProviderService service) {
		this.service = service;
	}

	@Override
	public List<Provider> handle() throws Exception {
		return service.getProviders();
	}
}
