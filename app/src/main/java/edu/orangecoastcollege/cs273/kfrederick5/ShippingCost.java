package edu.orangecoastcollege.cs273.kfrederick5;

/**
 * Class created to hold the shipping costs
 * of an item.
 * Created by kfrederick5 on 9/12/2016.
 */
public class ShippingCost {

    /**
     * Created a static variable to hold the base cost for shipping,
     * an int cost to hold the weight of the package, and doubles
     * for the added cost and the total cost.
     */
    private static final double BASE_COST = 3.00;
    private int mOunce;
    private double mTotalCost;
    private double mAddCost;

    /**
     * Default constructor that assigns the total cost an initial
     * value equal to the base cost, and the added cost to 0.
     */
    public ShippingCost() {
        mTotalCost = BASE_COST;
        mAddCost = 0.0;
    }

    /**
     * Creates an overloaded constructor that passes a weight
     * value and then recalculates the remaining values based
     * on that value.
     * @param mOunce a weight of a package
     */
    public ShippingCost(int mOunce) {
        this.mOunce = mOunce;
        recalcValues();
    }

    /**
     * Returns the weight of the package in ounces
     * @return the weight in ounces
     */
    public int getOunce() {
        return mOunce;
    }

    /**
     * Returns the total cost of the package based
     * on calculations of the weight, base cost, and added
     * cost.
     * @return a double of the total shipping cost for the package
     */
    public double getTotalCost() {
        return mTotalCost;
    }

    /**
     * Sets the weight of the package in ounces given
     * by the user. Then recalculates the other values
     * based on this input.
     * @param mOunce integer weight of the package in ounces
     */
    public void setOunce(int mOunce) {
        this.mOunce = mOunce;
        recalcValues();
    }

    /**
     *Returns the added cost of the package calculated by
     * taking the weight and adding .50 every 4 ounces above 16
     * @return a double that returns the added cost for the package
     */
    public double getAddCost() {
        return mAddCost;
    }

    /**
     * Calculates the values of total and added cost based on the
     * ounces given by the user and the base cost of shipping.
     */
    public void recalcValues()
    {
        mAddCost = ((mOunce < 16)? 0.0 : Math.ceil(mOunce/4.0 - 4) * .50);
        mTotalCost = mAddCost + BASE_COST;
    }
}
