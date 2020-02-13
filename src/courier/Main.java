package courier;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // Main function which prepares output and computes cost
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

        // For task 5 - for now don't do much because didn't have time
        // Rough idea described in updateItems function
        List<OrderItem> withDiscounts = updateItems(orderedItems);
        totalPrice = computePriceWithDiscounts(withDiscounts);

        // If speedy shipping included, add Speedy Shopping item with appropriate cost
        // Double total cost
        if (speedy) {
            withDiscounts.add(new OrderItem(OrderItemType.Speedy, totalPrice));
            totalPrice *= 2;
        }
        // Print out the output
        printOrderedItems(orderedItems);
        System.out.println("Total cost: $" + totalPrice);
        System.out.println();
        return totalPrice;

    }

    // Does discounting (task 5)
    // Takes nondiscounted items and outputs the best configuration items with discounts applied
    public static List<OrderItem> updateItems(List<OrderItem> nonDiscounted) {
        // Find all small orders and medium ones for the first and second discounts
        List<OrderItem> smallItems = new ArrayList<>();
        List<OrderItem> mediumItems = new ArrayList<>();
        List<OrderItem> forMixedDiscount = new ArrayList<>();
        for (OrderItem ordItem : nonDiscounted) {
            if (ordItem.getType() == OrderItemType.Small) {
                smallItems.add(ordItem);
            }
            else if (ordItem.getType() == OrderItemType.Medium) {
                mediumItems.add(ordItem);
            }
            else {
                forMixedDiscount.add(ordItem);
            }
        }

        // Run out of time, here's a quick outline of what I would do next
        // Have two more lists for discounted small items and discounted medium items
        // (just from the first two discounts)
        // Call these discSmall and discMed

        // Declare another list for all items that
        // will then be considered for the last discount

        // Sort out smallItems amd mediumItems by price
        // If smallItems and mediumItems have size n and m, take top (highest price)
        // n/3 and m/4 (int div) and initialise discounted versions into discSmall and discMed
        // (see OrderItemClass constructor)
        // Rest goes into forMixedDiscount

        // Two final lists
        // Ones with items that will be discounted by mixed discount (discMix)
        // Those that will stay undiscounted

        // Sort forMixedDiscount by prize
        // For top l/5 intialise discounted versions into discMix
        // Rest copied into undiscounted list

        // Result is concatenation of discSmall, discMed, discMix and undiscounted

        // Dummy to pass up to task 4
        return nonDiscounted;
    }

    // Computes final cost with discounts (task 5)
    private static int computePriceWithDiscounts(List<OrderItem> discounted) {
       int totalCost = 0;
       for (OrderItem finalItem : discounted) totalCost += finalItem.getCost();
       return totalCost;
    }

    // Printing function
    private static void printOrderedItems(List<OrderItem> orderItems) {
        for (OrderItem ordItem : orderItems) {
            System.out.println(ordItem.toString());
        }
    }
}
