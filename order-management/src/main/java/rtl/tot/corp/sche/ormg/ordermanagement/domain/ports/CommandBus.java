package rtl.tot.corp.sche.ormg.ordermanagement.domain.ports;

public interface CommandBus<Command> {

    public boolean execute(Command command) throws Exception;
}