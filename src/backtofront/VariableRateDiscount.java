package backtofront;

public class VariableRateDiscount implements DiscountStrategy {
    private double discountRate = .10;
    
    public VariableRateDiscount(){
    }
    
    public VariableRateDiscount (double rate){
        this.discountRate = rate;
    }
    
    @Override
    public double getDiscountAmt(int qty, double unitCost){
        return unitCost * qty * discountRate;
    }

    @Override
    public double getDiscountRate() {
        return discountRate;
    }

    @Override
    public void setDiscountRate(double discontRate) {
        this.discountRate = discontRate;
    }
    
    public static void main(String[] args){
        VariableRateDiscount app = new VariableRateDiscount(0.20);
        double amount = app.getDiscountAmt(2, 10);
        System.out.println("Discount Amt: " + amount);
    }
    
}
