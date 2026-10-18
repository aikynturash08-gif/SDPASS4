package order;

public class Main {
    public static void main(String[] args){
        OrderFacade orderFacade =new OrderFacade();

        orderFacade.placeOrder(
                "ORD-2026-001",
                "PROD-JAVA-17",
                2,
                150.0,
                "Astana,Mangilik El 55",
                "254015@astanait.edu.kz"
        );
    }
}
