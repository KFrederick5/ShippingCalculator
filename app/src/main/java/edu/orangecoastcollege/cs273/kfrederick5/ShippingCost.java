package edu.orangecoastcollege.cs273.kfrederick5;

/**
 * Created by kfrederick5 on 9/12/2016.
 */
public class ShippingCost {
    private int mOunce;
    private double mTotalCost;
    private double mAddCost;
    private double mBaseCost;

    public ShippingCost() {
    }

    public ShippingCost(int mOunce, double mTotalCost, double mAddCost, double mBaseCost) {
        this.mOunce = mOunce;
        this.mTotalCost = mTotalCost;
        this.mAddCost = mAddCost;
        this.mBaseCost = mBaseCost;
    }

    public int getOunce() {
        return mOunce;
    }

    public double getTotalCost() {
        return mTotalCost;
    }

    public double getBaseCost() {
        return mBaseCost;
    }

    public void setOunce(int mOunce) {
        this.mOunce = mOunce;
        recalcValues();
    }

    public void setTotalCost(double mTotalCost) {
        this.mTotalCost = mTotalCost;
        recalcValues();
    }

    public void setAddCost(double mAddCost) {
        this.mAddCost = mAddCost;
        recalcValues();
    }

    public void setBaseCost(double mBaseCost){
        this.mBaseCost = mBaseCost;
        recalcValues();
    }

    public double getAddCost() {
        return mAddCost;
    }

    public void recalcValues()
    {
        mAddCost = ((mOunce < 16)? 0.0 : (mOunce/4 - 4) * .50);
        mTotalCost = mAddCost + mBaseCost;
    }
}
