package rtl.tot.corp.mrex.prcn.provider.cmd.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import rtl.tot.corp.mrex.prcn.provider.cmd.adapters.create.CreateProviderCommandImpl;
import rtl.tot.corp.mrex.prcn.provider.cmd.adapters.update.UpdateProviderCommandImpl;
import rtl.tot.corp.mrex.prcn.provider.cmd.domain.Provider;

import java.util.List;

@Service
@Slf4j
public class ProviderService {

	private final
	ProviderCache cacheService;

	private final
	ProviderDatabaseService providerDatabaseService;

	public ProviderService(ProviderCache cacheService, ProviderDatabaseService providerDatabaseService) {
		this.cacheService = cacheService;
		this.providerDatabaseService = providerDatabaseService;
	}

	public boolean addProvider(CreateProviderCommandImpl cmd) {

		Provider provider = new Provider(
				cmd.getName(), cmd.getRut(), cmd.getCountry()
		);
		provider.setRut(cmd.getRut());
		log.info("Provider Saved successful ", provider);
		return true;

	}

	public boolean updateProvider(UpdateProviderCommandImpl cmd) {

		Provider provider = new Provider(
				cmd.getName(), cmd.getRut(), cmd.getCountry()
		);
		provider.setRut(cmd.getRut());
		log.info("Provider Updated successful ", provider);
		return true;


	}

	public List<Provider> getProviders() {
		List<Provider> providerList = cacheService.getProviders();

		if (!providerList.isEmpty()) {
			log.info("Serving the provider from cache");
			return providerList;
		}
		else {
			List<Provider> providerListBD = providerDatabaseService.GetProvidersfromDB();
			cacheService.cacheProvider(providerListBD);
			log.info("Serving the cache from DB");
			return providerListBD;
		}

	}
}
