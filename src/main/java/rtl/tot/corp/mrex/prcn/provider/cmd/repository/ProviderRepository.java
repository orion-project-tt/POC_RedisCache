package rtl.tot.corp.mrex.prcn.provider.cmd.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import rtl.tot.corp.mrex.prcn.provider.cmd.domain.Provider;

import java.util.List;

@Repository
@Primary
public interface ProviderRepository extends MongoRepository<Provider, String> {
    List<Provider> findAll();
}
