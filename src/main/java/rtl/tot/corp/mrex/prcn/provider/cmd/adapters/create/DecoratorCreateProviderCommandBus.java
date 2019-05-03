package rtl.tot.corp.mrex.prcn.provider.cmd.adapters.create;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rtl.tot.corp.mrex.prcn.provider.cmd.commons.ports.CommandBus;
import rtl.tot.corp.mrex.prcn.provider.cmd.domain.event.ProviderIntegrationEvent;
import rtl.tot.corp.mrex.prcn.provider.cmd.commons.infraestructure.EventPublisherService;
import rtl.tot.corp.mrex.prcn.provider.cmd.domain.event.EventType;

@Component
@Slf4j
public class DecoratorCreateProviderCommandBus implements CommandBus<CreateProviderCommandImpl> {


	@Autowired
	EventPublisherService publisher;
	CreateProviderCommandBus bus;

    public DecoratorCreateProviderCommandBus(CreateProviderCommandBus bus) {
    	this.bus = bus;
    }
    

    @Override
	public boolean execute(CreateProviderCommandImpl command) throws Exception {

    		ProviderIntegrationEvent integrationEvent = null;
    		try {

    			integrationEvent = new ProviderIntegrationEvent();

    			integrationEvent.setCountry(command.getCountry());
				integrationEvent.setName(command.getName());
				integrationEvent.setRut(command.getRut());


				if  (this.bus.execute(command)) {
    	            log.info("Sending Provider Creation integration Event " , command.getRut());
    	       	 
    	            return publisher.publish(EventType.PROVIDER_CREATED, integrationEvent);
    			}        
    		} catch (Exception e) {
    			log.error("Error Sending PriceCreateEvent integration Event " + integrationEvent.getMetadata() , e.getLocalizedMessage());
    		}

		return false;
	}

}