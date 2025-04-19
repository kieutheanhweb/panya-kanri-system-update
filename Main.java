package BakeryManager;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 商品作成（固定、単価、商品名、商品説明、カテゴリー）
        商品情報 product1 = new 商品情報("チョコレートケーキ", 500, "美味しいチョコレートケーキ", "ケーキ");
        商品情報 product2 = new 商品情報("クリームパン", 300, "甘いバナナブレッド", "パン");
        // 顧客作成
        顧客情報 customer1 = new 顧客情報("田中太郎", "東京都渋谷区", "090-1234-5678", "taro@example.com", LocalDate.of(1990, 5, 15));
        顧客情報 customer2 = new 顧客情報("鈴木花子", "大阪府大阪市", "080-2345-6789", "hanako@example.com", LocalDate.of(1985, 8, 22));
        // 商品管理・顧客管理・注文管理
        商品管理 productManager = new 商品管理();
        顧客情報管理 customerManager = new 顧客情報管理();
        注文管理 orderManager = new 注文管理();
      //商品、客様情報追加
        productManager.addProducts(product1);
        productManager.addProducts(product2);
        customerManager.addCustomer(customer1);
        customerManager.addCustomer(customer2);
        System.out.println(">>>>>>>>>>>商品一覧<<<<<<<<<<<<");
        productManager.displayAllProducts();
        System.out.println(">>>>>>>>>>>顧客一覧<<<<<<<<<<<<");
        customerManager.displayAllCustomers();

        // 注文
        while (true) {
            System.out.print("続けてご注文しますか？ (はい/いいえ): ");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("いいえ")) {            //注文したくないならbreakでアウト
                break;
            }

            System.out.println("商品をお選んでください:");
            System.out.println("1. チョコレートケーキ");
            System.out.println("2. クリームパン");
            System.out.print("番号を入力: ");
            int choice = Integer.parseInt(sc.nextLine());                  // 選択読み込む

            商品情報 selectedProduct = null;                      // 初期= null
            if (choice == 1) {
                selectedProduct = product1;
            } else if (choice == 2) {
                selectedProduct = product2;
            } else {
                System.out.println("選択することができません。もう一度ご入力ください。");
                continue;
            }

            System.out.print("数量をご入力ください: ");
            int quantity = Integer.parseInt(sc.nextLine());

            注文情報 order = new 注文情報(LocalDate.now(), selectedProduct, quantity);
            orderManager.addOrder(order);

            System.out.println("注文が登録されました！");
        }

        // 全ての注文を表示
        System.out.println(">>>>>>>>>>>注文一覧<<<<<<<<<<<<");
        orderManager.displayAllOrders();
    }
}
