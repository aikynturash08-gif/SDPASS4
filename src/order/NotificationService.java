package order;

class NotificationService {
    public void sendOrderConfirmation(String customerEmail, String orderId) {
        System.out.println("[NotificationService] Sending confirmation email to " + customerEmail + " for order: " + orderId);
    }
}
