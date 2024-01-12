package weddingplannerfx;

public class CreditCard extends Payment{
  private String cardName;
  private int CCnumber;
  private int expDate;
  private int CVV;

    public CreditCard() {
    }

    public CreditCard(String cardName, int CreditCardNumber, int expDate, int CVV, int paymentID, double totalAmount, String paymentDetails) {
        super(paymentID, totalAmount, paymentDetails);
        this.cardName = cardName;
        this.CCnumber = CreditCardNumber;
        this.expDate = expDate;
        this.CVV = CVV;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getCCnumber() {
        return CCnumber;
    }

    public void setCCnumber(int CCnumber) {
        this.CCnumber = CCnumber;
    }

    public int getExpDate() {
        return expDate;
    }

    public void setExpDate(int expDate) {
        this.expDate = expDate;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
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