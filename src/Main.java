public class Main {
    public static void main(String[] args) {

        Actor actor1 = new Human("Первый", true, true);
        Actor actor2 = new Human("Второй", true, false);
        Actor actor3 = new Human("Третий", false, false);

        Market market = new Market();

        market.acceptToMarket(actor1);

        market.acceptToMarket(actor2);

        market.acceptToMarket(actor3);

        market.takeOrders();
        market.giveOrders();
        market.releaseFromQueue();
//        market.update();


    }
}
