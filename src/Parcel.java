public class Parcel {

    private ParcelType type;
    private int weight;


    // Given dimensions and weight, set the right type
    public Parcel(int width, int height, int depth, int weight) {
        this.weight = weight;
        if (width < 10 && height < 10 && depth < 10) {
            this.type = ParcelType.Small;
        }
        else if (width < 50 && height < 50 && depth < 50) {
            this.type = ParcelType.Medium;
        }
        else if (width < 100 && height < 100 && depth < 100) {
            this.type = ParcelType.Large;
        }
        // Dimension limits for XL
        else if (width < 200 && height < 200 && depth < 200) {
            this.type = ParcelType.XL;
        }
        else this.type = ParcelType.Heavy;

    }

    public ParcelType getType() {
        return type;
    }


    // Compute cost of a parcel given type and weight
    public int getCost() {
        int ordinaryWeightPenalty = 2;
        int overWeightPenalty = 1;
        if (type == ParcelType.Small) {
            return 3 + Math.max(0,weight - 1) * ordinaryWeightPenalty;
        }
        else if (type == ParcelType.Medium) {
            return 8 + Math.max(0,weight - 3) * ordinaryWeightPenalty;
        }
        else if (type == ParcelType.Large) {
            return 15 + Math.max(0,weight - 6) * ordinaryWeightPenalty;
        }
        else if (type == ParcelType.XL) {
            return 25 + Math.max(0,weight - 10) * ordinaryWeightPenalty;
        }
        else return 50 + Math.max(0,weight - 50) * overWeightPenalty;
    }

}
