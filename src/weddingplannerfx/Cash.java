package weddingplannerfx;

public class Cash extends Payment{

    public Cash() {
    }

    public Cash(int paymentID, double totalAmount, String paymentDetails) {
        super(paymentID, totalAmount, paymentDetails);
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
    }
    
}
