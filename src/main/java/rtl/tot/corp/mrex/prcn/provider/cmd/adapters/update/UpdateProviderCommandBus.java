package rtl.tot.corp.mrex.prcn.provider.cmd.adapters.update;


import org.springframework.stereotype.Component;
import rtl.tot.corp.mrex.prcn.provider.cmd.commons.ports.CommandBus;

@Component
public class UpdateProviderCommandBus implements CommandBus<UpdateProviderCommandImpl> {


	UpdateProviderHandler handler;

	public UpdateProviderCommandBus(UpdateProviderHandler handler) {
		super();
		this.handler = handler;
	}


	@Override
	public boolean execute(UpdateProviderCommandImpl command) throws Exception {
	 	return handler.handle(command);
		
	}






    
}