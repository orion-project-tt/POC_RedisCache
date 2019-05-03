package rtl.tot.corp.mrex.prcn.provider.cmd.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;
import rtl.tot.corp.mrex.prcn.provider.cmd.domain.Provider;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class ProviderCache {
    private static final String menuEntryKey = "menu";
    private final String host;
    private final String authKey;
    private final ObjectMapper mapper;

    public ProviderCache(Environment env) {
        this.host = Objects.requireNonNull(
            env.getProperty("azure.redis.host"));
        this.authKey = Objects.requireNonNull(
            env.getProperty("azure.redis.key"));
        this.mapper = new ObjectMapper();
    }

    private Jedis createClient() {
        JedisShardInfo shardInfo = new JedisShardInfo(this.host, 6380, true);
        shardInfo.setPassword(this.authKey);
        return new Jedis(shardInfo);
    }

    List<Provider>  getProviders() {
        log.info("Attempting to retrieve the providers from cache");

        Jedis client = createClient();
        String resultString = client.get(menuEntryKey);
        client.close();

        log.info("Cache Data: " + resultString);

        if(resultString != null && !resultString.isEmpty()) {
            try {
                return mapper.readValue(resultString,
                    new TypeReference<List<Provider>>() { });
            }
            catch (IOException e) {
                log.error("Cache content is of unknown format: {}", resultString);
                return new LinkedList<>();
            }
        }
        else {
            return new LinkedList<>();
        }
    }

    void cacheProvider(List<Provider> providerList) {
        log.info("Attempting to cache the list of the providers");
        try {
            String menuAsString = mapper.writeValueAsString(providerList);

            Jedis client = createClient();
            client.set(menuEntryKey, menuAsString);
            client.close();
        }
        catch (IOException ex) {
            log.error("Could not cache the provider: {}", ex.getMessage(), ex);
        }
    }

}
