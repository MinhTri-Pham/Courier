package courier;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Tests {

    @Test
    public void singleSmall() {
        Parcel smallNonOverWeight = new Parcel(1,1,1,1);
        List<Parcel> parcels = new ArrayList<>();
        parcels.add(smallNonOverWeight);
        Assert.assertEquals(3,Main.processOrder(parcels,false));
        Assert.assertEquals(6,Main.processOrder(parcels,true));
        parcels.clear();
        Parcel smallOverWeight = new Parcel(2,2,2,4);
        parcels.add(smallOverWeight);
        Assert.assertEquals(9,Main.processOrder(parcels,false));
        Assert.assertEquals(18,Main.processOrder(parcels,true));
    }

    @Test
    public void twoDifferent() {
        Parcel small = new Parcel(8,8,8,1);
        Parcel medium = new Parcel(10,5,5,2);
        List<Parcel> parcels = new ArrayList<>();
        parcels.add(small);
        parcels.add(medium);
        Assert.assertEquals(11,Main.processOrder(parcels,false));
        Assert.assertEquals(22,Main.processOrder(parcels,true));
    }

    @Test
    public void twoSmallOneOverWeight() {
        Parcel smallNonOverWeight = new Parcel(1,1,1,1);
        Parcel smallOverWeight = new Parcel(2,2,2,4);
        List<Parcel> parcels = new ArrayList<>();
        parcels.add(smallNonOverWeight);
        parcels.add(smallOverWeight);
        Assert.assertEquals(12,Main.processOrder(parcels,false));
        Assert.assertEquals(24,Main.processOrder(parcels,true));
    }

    @Test
    public void twoOverLimitOneHeavy() {
        Parcel smallOverWeight = new Parcel(2,2,2,2);
        Parcel heavyOverWight = new Parcel(200,200,150,51);
        List<Parcel> parcels = new ArrayList<>();
        parcels.add(smallOverWeight);
        parcels.add(heavyOverWight);
        Assert.assertEquals(56,Main.processOrder(parcels,false));
        Assert.assertEquals(112,Main.processOrder(parcels,true));
    }
}
