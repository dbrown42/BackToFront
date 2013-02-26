/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backtofront;

/**
 *
 * @author dbrown69
 */
public class LineItem {
    private String prodId;
    private double qty;
    private Product product;
    
    
    public LineItem(String prodId, double qty, Product product){
        this.prodId = prodId;
        this.qty = qty;
        this.product = product;
    }
    
    public String getProdName(){
        
        return this.product.getProdName();
    }
    
    
    
    public static void main(String[] args){
    }
}
