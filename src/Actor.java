public abstract class Actor implements ActorBehavior{
    protected boolean isTakeOrder;
    protected boolean isMakeOrder;
    protected final String name;

    public Actor(String name) {
        this.name = name;
    }

    public Actor(String name, boolean isMakeOrder, boolean isTakeOrder) {
        this.isTakeOrder = isTakeOrder;
        this.isMakeOrder = isMakeOrder;
        this.name = name;
    }

    public abstract String getName();

    @Override
    public String toString() {
        return this.name;
    }
}
