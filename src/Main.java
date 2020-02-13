import java.util.ArrayList;
import java.util.List;

public class Main {

    // Main function which prepares output and computes cost
    private static void processOrder(List<Parcel> parcels, boolean speedy) {
        if (parcels.size() == 0) {
            System.out.println("Total cost: 0$");
            return;
        }
        int totalPrice = 0;
        List<OrderItem> orderedItems = new ArrayList<>(); // List of ordered items
        for (Parcel parcel : parcels) {
            // Process each parcel and make a new order item based on it
            // Keep track of total cost
            int cost = parcel.getCost();
            totalPrice += cost;
            switch (parcel.getType()) {
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
                case Heavy:
                    orderedItems.add(new OrderItem(OrderItemType.Heavy, cost));
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
        Parcel p1 = new Parcel(20,50,20,4);
        Parcel p2 = new Parcel(20,50,40, 7);
        List<Parcel> parcels = new ArrayList<>();
        parcels.add(p1);
        parcels.add(p2);
        // Compare difference between with and without speedy shipping
        processOrder(parcels, true);
        System.out.println();
        processOrder(parcels, false);

    }

}
