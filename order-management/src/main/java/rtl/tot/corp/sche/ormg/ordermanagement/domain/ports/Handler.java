package rtl.tot.corp.sche.ormg.ordermanagement.domain.ports;

public interface Handler<Command> {
public boolean handle(Command cmd) throws Exception;
}
