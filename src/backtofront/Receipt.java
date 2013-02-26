/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backtofront;

/**
 *
 * @author Dallas
 */
public class Receipt {
    private Customer cust;
    private LineItem[] lineItems;
    
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
    
    public void addItemToSale(String prodId, int qty){
        LineItem item = new LineItem(prodId, qty);
        addToArray(item);
    }
    
    public LineItem[] getLineItems(){
        return lineItems;
    }
    
    public static void main(String[] args){
        Receipt entry = new Receipt("100");
        entry.addItemToSale("A101", 2);
        System.out.println(entry.getLineItems()[0].getProduct().getProdName());
    }
}
