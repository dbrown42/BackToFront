/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backtofront;

/**
 *
 * @author dbrown69
 */
public class LineItem{
    private double qty;
    private Product product;
    
    public LineItem(String prodId, int qty){
        FakeDatabase db = new FakeDatabase();
        this.qty = qty;
        product = db.findProduct(prodId);
    }

    /**
     * @return the qty
     */
    public double getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(double qty) {
        this.qty = qty;
    }
    
    public Product getProduct(){
        return this.product;
    }
    
    public static void main(String[] args){
        
    }
}
