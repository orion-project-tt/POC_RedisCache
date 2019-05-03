package rtl.tot.corp.mrex.prcn.provider.cmd.domain.ports;

import rtl.tot.corp.mrex.prcn.provider.cmd.domain.Provider;

import java.util.List;

public interface CacheBus<Command> {

    List<Provider> execute() throws Exception;
}