public class OrderItem {
    private ParcelSize type;
    private int cost;

    public OrderItem(ParcelSize type, int cost) {
        this.type = type;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return type.toString() + " Parcel: $" + cost ;
    }
}
