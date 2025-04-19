package BakeryManager;

import java.time.LocalDate;

/**
 * 商品情報クラス：各商品のデータを管理するクラス
 */

public class 注文情報 {
    private LocalDate orderDate;       // 注文日
    private 商品情報 product;            // 注文された商品
    private int quantity;               // 注文個数
    // コンストラクタ（注文情報の初期化）

    public 注文情報(LocalDate orderDate, 商品情報 product, int quantity) {
        this.orderDate = orderDate;
        this.product = product;
        this.quantity = quantity;
    }
    // Getter メソッド

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public 商品情報 getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
    //Setter メソッド

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setProduct(商品情報 product) {
        this.product = product;
    }
    // 注文個数検討
    public void setQuantity(int quantity) {
        if (quantity < 1){
            System.out.println("Error: 注文個数は１以上にしてください");   //１個小なり場合
            this.quantity = 1;
        }
        else {
            this.quantity = quantity;
        }
    }

    // 注文情報を表示（合計金額付き)

    @Override
    public String toString() {
        double totalPrice = product.getPrice() * quantity;
        return "注文情報{" +
                "注文日：" + orderDate +
                ", 商品：" + product.getProductName() +
                ", 単価：" + product.getPrice() +
                ", 注文個数：" + quantity +
                ", 合計金額：" + totalPrice +
                '}';
    }
    // 注文情報をコンソールに出力
    public void displayOrderInfo() {
        System.out.println(this);
    }
}
