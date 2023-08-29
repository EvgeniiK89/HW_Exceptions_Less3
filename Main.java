import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Payment payment = new Payment();
        Payment.Order purchase = payment.new Order();
        purchase.createShoppingList();
        payment.amountMoneyPay(purchase.getOrderList());
        payment.printShoppingList(purchase.getOrderList());
    }
}

