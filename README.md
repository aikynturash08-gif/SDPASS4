# Assignment #4 — Facade Structural Design Pattern

**Course:** ShP-2216 – Software Design Patterns (OP 6B06102)  
**Author:** Aikyn Turash  
**Language:** Java (JDK 17)  

---

## 📌 Project Overview
This project implements the **Facade Structural Design Pattern** in Java (Option B — Online Order Processing Facade).

The system models an e-commerce order processing pipeline, coordinating four distinct subsystem services:
- **`InventoryService`**: Checks and reserves stock for requested items; handles stock releases during rollbacks.
- **`PaymentProcessor`**: Processes card/account charges and handles refunds if downstream steps fail.
- **`ShippingService`**: Coordinates logistics and generates delivery tracking numbers.
- **`NotificationService`**: Dispatches confirmation notifications to customers.

---

## 🏗️ Architecture & Pattern Implementation
The `OrderFacade` encapsulates the underlying complexity of coordinating stock reservations, payments, shipping, and notification dispatching behind a simple method:

```java
public boolean placeOrder(String orderId, String productId, int quantity, double amount, String address, String customerEmail);
