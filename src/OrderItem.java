public class OrderItem {
    private OrderItemType type;
    private int cost;

    public OrderItem(OrderItemType type, int cost) {
        this.type = type;
        this.cost = cost;
    }

    @Override
    public String toString() {
        if (type == OrderItemType.Speedy) return "Speedy Shipping: $" + cost;
        return type.toString() + " Parcel: $" + cost;
    }
}
