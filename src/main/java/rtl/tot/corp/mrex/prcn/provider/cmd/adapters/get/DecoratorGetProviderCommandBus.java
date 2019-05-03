package rtl.tot.corp.mrex.prcn.provider.cmd.adapters.get;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rtl.tot.corp.mrex.prcn.provider.cmd.commons.infraestructure.EventPublisherService;
import rtl.tot.corp.mrex.prcn.provider.cmd.commons.ports.CommandBus;
import rtl.tot.corp.mrex.prcn.provider.cmd.domain.Provider;
import rtl.tot.corp.mrex.prcn.provider.cmd.domain.event.EventType;
import rtl.tot.corp.mrex.prcn.provider.cmd.domain.event.ProviderIntegrationEvent;
import rtl.tot.corp.mrex.prcn.provider.cmd.domain.ports.CacheBus;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class DecoratorGetProviderCommandBus implements CacheBus<GetProviderCommandImpl> {


	@Autowired
	EventPublisherService publisher;
	GetProviderCommandBus bus;

    public DecoratorGetProviderCommandBus(GetProviderCommandBus bus) {
    	this.bus = bus;
    }
    

    @Override
	public List<Provider> execute() throws Exception {

    		try {

    			List<Provider> providerList = this.bus.execute();

				if (providerList.isEmpty()) {
					log.warn("Empty List of Provider");
					return providerList;
				} else {
    	            log.info("Sending Provider Retrieve Event ");
    	            return providerList;
    			}

			} catch (Exception e) {
				log.error("Error Sending Provider Retrieve Event " , e.getLocalizedMessage());
				return new ArrayList<>();
    		}

	}

}