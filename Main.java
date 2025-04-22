package BakeryManager;
/**
 * Mainクラス：条件オブジェクト初期化、商品作成、お客様情報作成、商品追加、お客様情報追加、
 *           商品リスト一覧、お客様情報リスト一覧、注文追加、商品選択、注文作成、注文リスト表示するクラス。
 */
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // オブジェクト管理者を初期化する
        条件チェック validator = new 条件チェック();
        注文管理 orderManager = new 注文管理();
        商品管理 productManager = new 商品管理();
        顧客情報管理 customerManager = new 顧客情報管理();

        // 商品作成（商品名、価格、商品説明、カテゴリー。）　(商品情報クラスのオブジェクト初期化)
        商品情報 product1 = new 商品情報("チョコレートケーキ", 500, "美味しいチョコレートケーキ", "ケーキ");
        商品情報 product2 = new 商品情報("クリームパン", 300, "甘いクリームパン", "パン");

        // お客様情報作成(名前、住所、携帯電話、mailアドレス、生年月日)　　　(顧客情報クラスのオブジェクト初期化)
        顧客情報 customer1 = new 顧客情報("KIEUTHEANH", "大阪府吹田市", "070-9100-5678", "kieutheanhjp@gmail.com", LocalDate.of(2002, 8, 15));
        顧客情報 customer2 = new 顧客情報("鈴木花子", "東京都渋谷区", "080-2345-6789", "hanako@yahho.com", LocalDate.of(1985, 8, 22));

        // 商品追加。
        productManager.addProducts(product1);   //メソッド　addProduct(): クラス商品管理で定義しました。
        productManager.addProducts(product2);
        //お客様情報追加。
        customerManager.addCustomer(customer1);  //メソッド　addCustomer(): クラス顧客情報管理で定義しました。
        customerManager.addCustomer(customer2);

        // 商品リスト一覧.
        System.out.println("＞＞＞＞＞＞ 商品一覧 ＜＜＜＜＜＜＜＜");
        productManager.displayAllProducts();
        //お客様情報リスト一覧。
        System.out.println("＞＞＞＞＞＞ 顧客一覧 ＜＜＜＜＜＜＜＜");
        customerManager.displayAllCustomers();

        // 注文追加.
        while (true) {
            System.out.print(" 続けてご注文しますか？（YES / NO）: ");
            String input = sc.nextLine().trim();
            if (input.equalsIgnoreCase("NO")) {    //IgnoreCase.
                System.out.println("注文受付を終了します。");     //大文字/小文字を区別せずに比較します。
                break;
            }

            // 商品選択.
            // 現在は商品を固定で表示していますが,
            // 商品数が増える場合はArrayListを使って動的に表示することも可能.
            System.out.println("商品を選んでください:");
            System.out.println("1. チョコレートケーキ");
            System.out.println("2. クリームパン");
            System.out.print("番号を入力: ");

            int choice;
            try {                                              //nextLine()は改行コードも読み取るため、nextInt()後に改行が残り、
                choice = Integer.parseInt(sc.nextLine());      //次のnextLine()で空の入力になることがあります。
            } catch (NumberFormatException e) {                //なのでnextLine()で文字列を読み取り、それをInteger.parseInt()で整数に変換して
                System.out.println("数字で入力してください。");     //choiceに代入します。
                continue;
            }
            if (!validator.商品が有効か(choice)) continue;                      //メソッド商品が有効か(): 条件チェッククラスで定義した。
            商品情報 selectedProduct = (choice == 1) ? product1 : product2;
            if (!validator.商品情報が有効か(selectedProduct)) continue;          //メソッド商品情報が有効か(): 条件チェッククラスで定義した。

            // 数量入力
            System.out.print("数量を入力: ");
            int quantity;
            try {
                quantity = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("数量は数字で入力してください。");
                continue;
            }

            if (!validator.数量が有効か(quantity)) continue;             //メソッド数量が有効か(): 条件チェッククラスで定義した。

            // 注文作成
            注文情報 order = new 注文情報(LocalDate.now(), selectedProduct, quantity);    // *LocalDate.now():　現在の時間。
            if (!validator.注文が有効か(order)) continue;                                // *Java 8 から使用可能.

            orderManager.addOrder(order);
            System.out.println("ご注文が完了しました！");
        }

        // 注文リスト表示
        System.out.println("========== 注文一覧 ==========");
        orderManager.displayAllOrders();                        ////メソッドdisplayAllOrders(): 注文管理クラスで定義した。
    }
}