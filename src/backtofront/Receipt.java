/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backtofront;

/**
 *
 * @author Dallas
 */
import java.text.*;
import java.util.Date;
public class Receipt {
    private Customer cust;
    private LineItem[] lineItems;
    private Date receiptDate = new Date();
    private String custId;
   
    public Receipt (String custId){
        this.custId = custId;
        cust = this.getCustomer(custId);
        lineItems = new LineItem[0];
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
    
    public LineItem[] getLineItems(){
        return lineItems;
    }
    
    public String getFormatDate(){
        SimpleDateFormat ft = new SimpleDateFormat("E MM.dd.yyyy ' / ' hh:mm a");
        return ft.format(receiptDate);
    }
  
    public double getTotalBeforeDiscount() {
        double grandTotal = 0.0;
        for(LineItem item : lineItems) {
            grandTotal += item.getProduct().getUnitCost();
        }
        return grandTotal;
    }
    
    public String outputReceipt(){
        double gt = 0.0;
        double st = 0.0;
        DecimalFormat df = new DecimalFormat("#.##");
        String output = ("Data / Time: " + this.getFormatDate() 
                + "\n\nCustomer ID: " + cust.getCustId() + "\nCustomer Name: " + cust.getCustName()
                + "\n\n-------------------------------------------------------------------------------------------------------------------------"
                + "\nProduct Name\t\tID #\t\tPrice\t\tQuantity\tDiscount Amount\t\tRate\t\tSubtotal"
                + "\n-------------------------------------------------------------------------------------------------------------------------\n");
        
        for(LineItem lI : lineItems){
            output += (lI.getProduct().getProdName()+"\t\t" + lI.getProduct().getProdId() 
                    + "\t\t$" + df.format(lI.getProduct().getUnitCost()) + "\t\t" + lI.getQty() 
                    + "\t\t$" + df.format(lI.getProduct().getDiscountAmt(lI.getQty())) 
                    + "\t\t\t" + (lI.getProduct().getDiscountRate() * 100) + "%"); 
                    st += ((lI.getProduct().getUnitCost() * lI.getQty()) - lI.getProduct().getDiscountAmt(lI.getQty()));
                    gt += st;
            output += ("\t\t$" + df.format(st));
        }
        output += ("\n\n\nTotal Before Discount: $" + df.format(this.getTotalBeforeDiscount())
                + "\n\nGRAND TOTAL: $" + df.format(gt));
        return output;
    }
    
    public void addItemToSale(String prodId, int qty) {
	FakeDatabase db =  new FakeDatabase();
        Product product = db.findProduct(prodId);
        
	// if found, add the lineItem to the receipt
	// but it's the receipt's job to do this!
        if(product != null) {
            this.addLineItem(prodId, qty);
        }  
    }
    
    public static void main(String[] args){
        Receipt entry = new Receipt("100");
        entry.addItemToSale("A101", 2);
        //System.out.println(entry.getLineItems()[0].getProduct().getProdName());
        System.out.println(entry.outputReceipt());
    }
}
