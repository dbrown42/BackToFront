/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backtofront;

/**
 *
 * @author Dallas
 */
public class CashRegister {
    private String custId;
    
    private Receipt receipt;
    
    public CashRegister(String custId){
        this.custId = custId;
        receipt = new Receipt(custId);
    }
    
    public void addItemToSale(String prodId, int qty) {
	FakeDatabase db =  new FakeDatabase();
        Product product = db.findProduct(prodId);
        
	// if found, add the lineItem to the receipt
	// but it's the receipt's job to do this!
        if(product != null) {
            receipt.addLineItem(prodId, qty);
        }  
    }
    
    public void outputReceipt(){
        receipt.outputReceipt();
    }
    
    public static void main(String[] args){
        CashRegister entry = new CashRegister("100");
        entry.addItemToSale("A101", 2);
        entry.outputReceipt();
    }
}
