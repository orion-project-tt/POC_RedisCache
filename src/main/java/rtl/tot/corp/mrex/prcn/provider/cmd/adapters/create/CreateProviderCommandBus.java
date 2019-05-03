package rtl.tot.corp.mrex.prcn.provider.cmd.adapters.create;


import org.springframework.stereotype.Component;
import rtl.tot.corp.mrex.prcn.provider.cmd.commons.ports.CommandBus;

@Component
public class CreateProviderCommandBus implements CommandBus<CreateProviderCommandImpl> {

	
	CreateProviderHandler handler;

	public CreateProviderCommandBus(CreateProviderHandler handler) {
		super();
		this.handler = handler;
	}


	@Override
	public boolean execute(CreateProviderCommandImpl command) throws Exception {
	 	return handler.handle(command);
		
	}






    
}