package order;

class InventoryService {
    public boolean reserveStock(String productId, int quantity) {
        System.out.println("[InventoryService] Checking and reserving " + quantity + " units of product: " + productId);
        return true;
    }

    public void releaseStock(String productId, int quantity) {
        System.out.println("[InventoryService] Rollback: Releasing " + quantity + " units of product back to stock: " + productId);
    }
}
