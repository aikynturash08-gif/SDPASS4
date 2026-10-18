package order;

class ShippingService {
    public String arrangeShipping(String orderId, String address) {
        System.out.println("[ShippingService] Arranging delivery to address: " + address + " for order ID: " + orderId);
        return "TRACK-XYZ-999";
    }
}

