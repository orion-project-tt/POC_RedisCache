package rtl.tot.corp.mrex.prcn.provider.cmd.commons.ports;

public interface Handler<Command> {
public boolean handle(Command cmd) throws Exception;
}
