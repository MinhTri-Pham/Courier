import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<OrderItem> processOrder(List<Parcel> parcels) {
        List<OrderItem> orderedItems = new ArrayList<>();
        for (Parcel parcel : parcels) {
            orderedItems.add(new OrderItem(parcel.size, parcel.getCost()));
        }
        return orderedItems;
    }

    public static void printOrderedItems(List<OrderItem> orderItems) {
        for (OrderItem ordItem : orderItems) {
            System.out.println(ordItem.toString());
        }
    }

}
