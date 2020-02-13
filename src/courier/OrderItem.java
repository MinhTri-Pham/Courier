package courier;

public class OrderItem {
    private OrderItemType type;
    private int cost; // Negative for discounts

    public OrderItem(OrderItemType type, int cost) {
        this.type = type;
        this.cost = cost;
    }

    @Override
    public String toString() {
        if (type == OrderItemType.Speedy) return "Speedy Shipping: $" + cost;
        else if (type == OrderItemType.Discount) return "Discount: $" + cost;
        return type.toString() + " Parcel: $" + cost;
    }
}
