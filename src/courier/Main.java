package courier;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // courier.Main function which prepares output and computes cost
    // Returns the total cost
    public static int processOrder(List<Parcel> parcels, boolean speedy) {
        if (parcels.size() == 0) {
            System.out.println("Total cost: 0$");
            return 0;
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
        System.out.println();
        return totalPrice;

    }

    private static void printOrderedItems(List<OrderItem> orderItems) {
        for (OrderItem ordItem : orderItems) {
            System.out.println(ordItem.toString());
        }
    }
}