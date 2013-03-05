/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backtofront;

/**
 *
 * @author Dallas
 */
import java.util.Date;
public class Receipt {
    private Customer cust;
    private LineItem[] lineItems;
    private Date receiptDate;
    private Receipt receipt;
    
    public Receipt (String custId){
        lineItems = new LineItem[0];
        this.getCustomer(custId);
    }
    
    public Customer getCustomer(String custId){
        FakeDatabase db = new FakeDatabase();
        return db.findCustomer(custId);
    }
    
    private void addToArray(LineItem item) {
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
        tempItems[lineItems.length] = item;
        lineItems = tempItems;
    }    
    
    public void addLineItem(String prodId, int qty) {
        LineItem item = new LineItem(prodId, qty);
        addToArray(item);
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
    
    public LineItem[] getLineItems(){
        return lineItems;
    }
 /*  
    public double getTotalBeforeDiscount() {
        double grandTotal = 0.0;
        for(LineItem item : lineItems) {
            grandTotal += item.getOrigPriceSubtotal();
        }
        return grandTotal;
    }
*/
    
    public String outputReceipt(){
        String output = ("DATE: " + receiptDate 
                + "\nCustomer ID: " + cust.getCustId() + "\nCustomer Name: " + cust.getCustName()
                + "\n\n----------------------------------------------------------------------------"
                + "\nProduct Name\t\tProduct ID\tSubtotal\tTotal"
                + "\n------------------------------------------------------------------------------\n");
        
        for(int i=0;i < this.lineItems.length; i++){
            output += (lineItems[i].getProduct().getProdName()+"\t\t" + lineItems[i].getProduct().getProdId() 
                    + "\t" + lineItems[i].getProduct().getUnitCost());
        }
        return output;
    }
    
    public static void main(String[] args){
        Receipt entry = new Receipt("100");
        entry.addItemToSale("A101", 2);
        //System.out.println(entry.getLineItems()[0].getProduct().getProdName());
        entry.outputReceipt();
    }
}
