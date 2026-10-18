package order;

public class OrderFacade {
    private final InventoryService inventoryService;
    private final PaymentProcessor paymentProcessor;
    private final ShippingService shippingService;
    private final NotificationService notificationService;

    public OrderFacade() {
        this.inventoryService = new InventoryService();
        this.paymentProcessor = new PaymentProcessor();
        this.notificationService = new NotificationService();
        this.shippingService = new ShippingService();
    }

    public boolean placeOrder(String orderId, String productId, int quantity, double amount, String address, String customerEmail) {
        System.out.println("Starting Order Placement Process(ID: " + orderId);
        boolean reserved = inventoryService.reserveStock(productId, quantity);
        if (!reserved) {
            System.out.println("Order failed: Stock reservation failed ");
            return false;
        }
        boolean paid = paymentProcessor.processPayment(orderId, amount);
        if (!paid) {
            System.out.println("Order failed; payment declained,Rolling back inventory");
            inventoryService.releaseStock(productId, quantity);
            return false;
        }
        try {
            String trackingNumber=shippingService.arrangeShipping(orderId,address);
            System.out.println("Shipping arranged succefully.tracking: "+trackingNumber);
        } catch (Exception e){
            System.out.println("Order dailed during shipping. Initiating full rollback");
            paymentProcessor.refundPayment(orderId,amount);
            inventoryService.releaseStock(productId,quantity);
            return false;
        }
        notificationService.sendOrderConfirmation(customerEmail,orderId);
        System.out.println("Order Succesfully Completed");
        return true;
    }
}
