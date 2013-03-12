package backtofront;

public class Product {
    private String prodId;
    private String prodName;
    private double unitCost;
    private DiscountStrategy discount;
    
    public Product(String prodId, String prodName, double unitCost, DiscountStrategy discount){
        this.prodId = prodId;
        this.prodName = prodName;
        this.unitCost = unitCost;
        this.discount = discount;
    }
    public double getDiscountAmt(int qty){
        return discount.getDiscountAmt(qty, unitCost);
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public DiscountStrategy getDiscount() {
        return discount;
    }

    public void setDiscount(VariableRateDiscount discount) {
        this.discount = discount;
    }
    
    public double getDiscountRate(){
       return discount.getDiscountRate(); 
    }
    
    public static void main(String[] args){
        Product product = new Product("101", "Hat", 20.00, new QuantityVariableRateDiscount(.2, 5));
        double discount = product.getDiscountAmt(8);
        System.out.println("Discount: " + discount);
    }
}
