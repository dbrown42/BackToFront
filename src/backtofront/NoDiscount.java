package backtofront;

public class NoDiscount implements DiscountStrategy {
private double discountRate;
    @Override
    public double getDiscountAmt(int qty, double unitCost) {
        return 0;
    }

    @Override
    public double getDiscountRate() {
        return discountRate;
    }

    @Override
    public void setDiscountRate(double discontRate) {
        this.discountRate = discountRate;
    }

}
