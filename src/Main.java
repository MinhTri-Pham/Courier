import java.util.ArrayList;
import java.util.List;

public class Main {

    // Main function which prepares output and computes cost
    public static void processOrder(List<Parcel> parcels, boolean speedy) {
        List<OrderItem> orderedItems = new ArrayList<>(); // List of ordered items
        int totalPrice = 0;
        for (Parcel parcel : parcels) {
            // Process each parcel and make a new order item based on it
            // Keep track of total cost
            int cost = parcel.getCost();
            totalPrice += cost;
            switch (parcel.size) {
                case Small:
                    orderedItems.add(new OrderItem(OrderItemType.Small, cost));
                    break;
                case Medium:
                    orderedItems.add(new OrderItem(OrderItemType.Medium, cost));
                    break;
                case Large:
                    orderedItems.add(new OrderItem(OrderItemType.Large, cost));
                    break;
                case XL:
                    orderedItems.add(new OrderItem(OrderItemType.XL, cost));
                    break;
            }
        }
        // If speedy shipping included, add Speedy Shopping item with appropriate cost
        // Double total cost
        if (speedy) {
            orderedItems.add(new OrderItem(OrderItemType.Speedy, totalPrice));
            totalPrice *= 2;
        }
        // Print out the output
        printOrderedItems(orderedItems);
        System.out.println("Total cost: $" + totalPrice);

    }

    private static void printOrderedItems(List<OrderItem> orderItems) {
        for (OrderItem ordItem : orderItems) {
            System.out.println(ordItem.toString());
        }
    }

    // For testing
    public static void main(String[] args) {
        Parcel p1 = new Parcel(1,1,9);
        Parcel p2 = new Parcel(2,3,1);
        Parcel p3 = new Parcel(1,51,1);
        Parcel p4 = new Parcel(101,10,10);
        List<Parcel> parcels = new ArrayList<>();
        parcels.add(p1);
        parcels.add(p2);
        parcels.add(p3);
        parcels.add(p4);
        processOrder(parcels, true);
        System.out.println();
        processOrder(parcels, false);

    }

}
