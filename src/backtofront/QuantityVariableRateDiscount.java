package backtofront;

public class QuantityVariableRateDiscount implements DiscountStrategy {
    private double discountRate = .10;
    private int minQty = 5;
    
    public QuantityVariableRateDiscount(){
    }
    
    public QuantityVariableRateDiscount (double rate, int minQty){
        this.discountRate = rate;
        this.minQty = minQty;
    }
    
    @Override
    public double getDiscountAmt(int qty, double unitCost){
        if(qty >= minQty){
            return unitCost * qty * discountRate;
        }
        else{
            return 0;
        }
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
        QuantityVariableRateDiscount app = new QuantityVariableRateDiscount(0.20, 5);
        double amount = app.getDiscountAmt(5, 10);
        System.out.println("Discount Amt: " + amount);
    }
    
}
