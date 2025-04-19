package BakeryManager;
/**
 * 商品情報クラス：各商品のデータ（名前、価格、説明、カテゴリー）を管理するクラス。
 * 商品を作成・表示・更新するためのメソッドが含まれている。
 */

public class 商品情報 {
    // 商品情報
    private String productName;      // 商品名
    private double price;            // 価格
    private String description;      // 商品説明
    private String category;         // カテゴリー（例：ケーキ、パン）
    //コンストラクタ

    public 商品情報(String productName, double price, String description, String category) {
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.category = category;
    }
    // Getter メソッド

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    // 商品情報を表示

    @Override
    public String toString() {
        return "商品情報{" +
                "商品名：" + productName +
                ", 価格：" + price +
                ", 商品説明：" + description +
                ", カテゴリー：" + category +
                '}';
    }
    public void displayProductInfo(){
        System.out.println(this);
    }
}



