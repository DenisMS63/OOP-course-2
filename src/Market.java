import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Market implements MarketBehavior, QueueBehavior{
    private List<Actor> queue;
    private List<Actor> queueReleaseFromQueue;
    @Override
    public void acceptToMarket(Actor actor) {
        System.out.println(actor + " пришел в магазин (будет добавлен в очередь)");
        this.takeInQueue(actor);
    }

    @Override
    public void takeInQueue(Actor actor) {
        System.out.println(actor + " встал в очередь (добавлен в список)");
        queue = new LinkedList<>();
        queue.add(actor);
    }

    @Override
    public void takeOrders() {
        System.out.println("Отмечены посетители сделавшие заказ");
        for (Actor el : queue){
            if (!el.isMakeOrder){
                el.setMakeOrder(true);
            }
        }
    }

    @Override
    public void giveOrders() {
        System.out.println("Отмечены посетители получившие заказ");
        for (Actor el : queue){
            if (el.isMakeOrder){
                el.setTakeOrder(true);
            }
        }

    }

    @Override
    public void releaseFromQueue() {
        System.out.println("Посетители получившие заказ добавлены в список готовых выходить из магазина");
        for (Actor el : queue){
            if (el.isTakeOrder){
//                queueReleaseFromQueue.add(el);
                this.releaseFromMarket(queue);
            }
        }
    }

    @Override
    public void releaseFromMarket(List<Actor> actorList) {
        System.out.println("Удаление посетителей из списка");
        for (Actor el : actorList){
            actorList.remove(el);
        }
    }

    @Override
    public void update() {
        System.out.println("Магазин обновлен");
        this.takeOrders();
        this.giveOrders();
        this.releaseFromQueue();
    }

}
