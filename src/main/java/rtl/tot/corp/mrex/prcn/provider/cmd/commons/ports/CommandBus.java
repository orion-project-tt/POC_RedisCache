package rtl.tot.corp.mrex.prcn.provider.cmd.commons.ports;

public interface CommandBus<Command> {

    public boolean execute(Command command) throws Exception;
}