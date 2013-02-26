package backtofront;

public interface DiscountStrategy {

    public abstract double getDiscountAmt(int qty, double unitCost);

    public abstract double getDiscountRate();

    public abstract void setDiscountRate(double discontRate);
    
}
