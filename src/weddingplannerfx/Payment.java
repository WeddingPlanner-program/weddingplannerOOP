package weddingplannerfx;

public class Payment {
    protected int paymentID;
    protected double totalAmount;
    protected String paymentDetails;

    public Payment() {
    }

    public Payment(int paymentID, double totalAmount, String paymentDetails) {
        this.paymentID = paymentID;
        this.totalAmount = totalAmount;
        this.paymentDetails = paymentDetails;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
    }
    
    public void calcPayment(){
        System.out.println("The amount of this payment is: " + totalAmount);
    }
  
    
}