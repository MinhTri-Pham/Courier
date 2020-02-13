public class Parcel {

    ParcelSize size;

    public Parcel(int w, int h, int d) {
        if (w < 10 && h < 10 && d < 10) {
            this.size = ParcelSize.Small;
        }
        else if (w < 50 && h < 50 && d < 50) {
            this.size = ParcelSize.Medium;
        }
        else if (w < 100 && h < 100 && d < 100) {
            this.size = ParcelSize.Large;
        }
        else this.size  = ParcelSize.XL;

    }

    public int getCost() {
        if (size == ParcelSize.Small) return 3;
        else if (size == ParcelSize.Medium) return 8;
        else if (size == ParcelSize.Large) return 15;
        else return 25;
    }

}
