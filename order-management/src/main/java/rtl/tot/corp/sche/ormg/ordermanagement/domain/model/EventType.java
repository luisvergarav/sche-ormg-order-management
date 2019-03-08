package rtl.tot.corp.sche.ormg.ordermanagement.domain.model;

public enum EventType {
    ORDER_CREATED("productCreated"),
    ORDER_UPDATED("productUpdated"),
    ORDER_DELETED("productDeleted");
    private final String name;

    EventType(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

