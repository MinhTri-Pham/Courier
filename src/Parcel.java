public class Parcel {

    private ParcelSize size;
    private int weight;

    private final int smallWeightLimit = 1;
    private final int mediumWeightLimit = 3;
    private final int largeWeightLimit = 6;
    private final int xlWeightLimit = 10;
    private final int weightPenalty = 2;


    // Given dimensions, set the right size
    public Parcel(int width, int height, int depth, int weight) {
        this.weight = weight;
        if (width < 10 && height < 10 && depth < 10) {
            this.size = ParcelSize.Small;
        }
        else if (width < 50 && height < 50 && depth < 50) {
            this.size = ParcelSize.Medium;
        }
        else if (width < 100 && height < 100 && depth < 100) {
            this.size = ParcelSize.Large;
        }
        else this.size  = ParcelSize.XL;

    }

    public ParcelSize getSize() {
        return size;
    }


    // Compute cost of a parcel given size and weight
    public int getCost() {
        if (size == ParcelSize.Small) {
            return 3 + Math.max(0,weight - smallWeightLimit)*weightPenalty;
        }
        else if (size == ParcelSize.Medium) {
            return 8 + Math.max(0,weight - mediumWeightLimit)*weightPenalty;
        }
        else if (size == ParcelSize.Large) {
            return 15 + Math.max(0,weight - largeWeightLimit)*weightPenalty;
        }
        else return 25 + Math.max(0,weight - xlWeightLimit)*weightPenalty;
    }

}
