package edu.orangecoastcollege.cs273.kfrederick5;

/**
 * Created by kfrederick5 on 9/12/2016.
 */
public class ShippingCost {
    private static final double BASE_COST = 3.00;
    private int mOunce;
    private double mTotalCost;
    private double mAddCost;

    public ShippingCost() {
        mTotalCost = BASE_COST;
        mAddCost = 0.0;
    }

    public ShippingCost(int mOunce) {
        this.mOunce = mOunce;
        recalcValues();
    }

    public int getOunce() {
        return mOunce;
    }

    public double getTotalCost() {
        return mTotalCost;
    }

    public void setOunce(int mOunce) {
        this.mOunce = mOunce;
        recalcValues();
    }

    public double getAddCost() {
        return mAddCost;
    }

    public void recalcValues()
    {
        mAddCost = ((mOunce < 16)? 0.0 : Math.ceil(mOunce/4.0 - 4) * .50);
        mTotalCost = mAddCost + BASE_COST;
    }
}
