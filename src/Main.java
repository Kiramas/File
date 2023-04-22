import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String[] products = {"Молоко", "Хлеб", "Гречневая крупа"};
    static int[] prices = {50, 14, 80};

    static File saveFile = new File("basket.txt");

    public static void main(String[] args) throws IOException {
        Basket basket = null;
        if (saveFile.exists()) {
            basket = Basket.loadFromTxtFile(saveFile);
        } else {
            basket = new Basket(products, prices);
        }

        int currentPrice = 0;
        System.out.println("Список возможных товаров для покупки");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] + " " + prices[i] + " руб/шт.");
        }

        while (true) {
            showPrice();
            System.out.println("Выберите товар и количество или введите `end`");
            String input = scanner.nextLine();

            if ("end".equals(input)) {
                break;
            }

            String[] parts = input.split(" ");
            int productNumber = Integer.parseInt(parts[0]) - 1;
            int productAmount = Integer.parseInt(parts[1]);
            basket.addToCart(productNumber, productAmount);
            basket.saveTxt(saveFile);
        }
        basket.printCart();
    }

    public static void showPrice() {
        System.out.println("Список возможных товаров для покупки");
        int sum = 0;
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i] + " " + prices[i] + " руб/шт ");

        }
    }
}

