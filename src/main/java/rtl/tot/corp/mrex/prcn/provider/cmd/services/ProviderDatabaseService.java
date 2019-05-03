package rtl.tot.corp.mrex.prcn.provider.cmd.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import rtl.tot.corp.mrex.prcn.provider.cmd.domain.Provider;
import rtl.tot.corp.mrex.prcn.provider.cmd.repository.ProviderRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ProviderDatabaseService {

    private final ProviderRepository repository;

    public ProviderDatabaseService(ProviderRepository repository) {
        this.repository = repository;
    }

    List<Provider> GetProvidersfromDB() {
        return new ArrayList<>(repository
                .findAll());
    }

}
