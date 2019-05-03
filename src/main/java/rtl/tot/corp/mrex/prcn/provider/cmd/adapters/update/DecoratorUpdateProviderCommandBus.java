package rtl.tot.corp.mrex.prcn.provider.cmd.adapters.update;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rtl.tot.corp.mrex.prcn.provider.cmd.commons.ports.CommandBus;
import rtl.tot.corp.mrex.prcn.provider.cmd.domain.event.ProviderIntegrationEvent;
import rtl.tot.corp.mrex.prcn.provider.cmd.commons.infraestructure.EventPublisherService;
import rtl.tot.corp.mrex.prcn.provider.cmd.domain.event.EventType;

@Component
@Slf4j
public class DecoratorUpdateProviderCommandBus implements CommandBus<UpdateProviderCommandImpl> {


	@Autowired
	EventPublisherService publisher;
	UpdateProviderCommandBus bus;

    public DecoratorUpdateProviderCommandBus(UpdateProviderCommandBus bus) {
    	this.bus = bus;
    }
    

    @Override
	public boolean execute(UpdateProviderCommandImpl command) throws Exception {

    		ProviderIntegrationEvent integrationEvent = null;
    		try {

    			integrationEvent = new ProviderIntegrationEvent();

    			integrationEvent.setCountry(command.getCountry());
				integrationEvent.setName(command.getName());
				integrationEvent.setRut(command.getName());


				if  (this.bus.execute(command)) {
    	            log.info("Sending UpdateCreateEvent integration Event " , command.getRut());
    	       	 
    	            return publisher.publish(EventType.PROVIDER_UPDATED, integrationEvent);
    			}        
    		} catch (Exception e) {
    			log.error("Error Sending ProviderUpdatedEvent integration Event " + integrationEvent.getMetadata() , e.getLocalizedMessage());
    		}

		return false;
	}

}