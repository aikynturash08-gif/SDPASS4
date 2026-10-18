package order;

class PaymentProcessor {
    public boolean processPayment(String orderId, double amount) {
        System.out.println("[PaymentProcessor] Processing payment of $" + amount + " for order ID: " + orderId);
        return true;
    }

    public void refundPayment(String orderId, double amount) {
        System.out.println("[PaymentProcessor] Rollback: Refunding $" + amount + " for order ID: " + orderId);
    }
}
