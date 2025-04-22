package BakeryManager;
/**
 * 条件クラス：（商品の選択肢、数量、お客様情報、商品情報、注文情報) の入力検証クラス。
 */
public class 条件チェック {

    // 現在は商品が2つの場合のチェック
   // 今後商品数が増える場合は、商品リストのサイズでチェックする方法に変更可能
    public boolean 商品が有効か(int choice) {
        if (choice < 1 || choice > 2) {
            System.out.println("商品の選択が無効です。1 または 2 を入力してください。");
            return false;
        }
        return true;
    }

    // 数量が有効かどうかを確認するメソッド(1以下＝＝＞FALSE && 100以上==>店長に相談に乗る)
    public boolean 数量が有効か(int quantity) {
        if (quantity <= 0) {
            System.out.println("数量は1以上の正の整数でなければなりません。");
            return false;
        }
        else if (quantity>100){
            System.out.println("数量は１００を超えております。店長にご相談ください。TEL:０７０－９１００－５６７８");
            return false;
        }
        return true;
    }

    // 客様情報が有効かどうかを確認するメソッド()
    // 現在は顧客名のみをチェックしていますが、必要に応じてメールアドレスや生年月日のチェック処理も追加可能です。
    public boolean 顧客情報が有効か(顧客情報 customer) {
        if (customer == null) {
            System.out.println("顧客情報が無効です。");       //  customerオブジェクトがまだ生成されていない場合
            return false;                                 // （＝未初期化）、nullになります。
        }
        if (customer.getName() == null || customer.getName().isEmpty()) {     // 名前が未入力
            System.out.println("顧客名が入力されていません。");                     // または名前が空の文字列（何も入力されていない）場合
            return false;
        }
        return true;
    }

    // 注文情報が有効かどうかを確認するメソッド()
    //注文が存在か、商品未選択か、数量有効を検証条件です。
    public boolean 注文が有効か(注文情報 order) {
        if (order == null) {
            System.out.println("注文情報が存在しません。");            //注文が存在か
            return false;
        }
        if (order.getProduct() == null) {                         // (注文情報クラス)のGetter メソッド(getProduct)
            System.out.println("商品が未選択です。");                //.getProduct==>return product (商品名)
            return false;
        }
        if (order.getQuantity() <= 0) {                           // (注文情報クラス)のGetter メソッド(getQuantity)
            System.out.println("注文数量が無効です。");              //.getQuantity==>return quantity(数量)
            return false;
        }
        return true;
    }

    // 商品情報が有効かどうかを確認するメソッド()
    //商品が存在か、商品名未選択か、単価有効(>0)を検証条件です。
    public boolean 商品情報が有効か(商品情報 product) {
        if (product == null) {
            System.out.println("商品情報が存在しません。");                         //  productオブジェクトがまだ生成されていない場合
            return false;                                                       // （＝未初期化）、nullになります。
        }
        if (product.getProductName() == null || product.getProductName().isEmpty()) {
            System.out.println("商品名が入力されていません。");                        // 商品名が未入力
            return false;                                                         // または商品名が空の文字列（何も入力されていない）場合
        }
        if (product.getPrice() <= 0) {
            System.out.println("商品価格は正の整数でなければなりません。");             //単価＜０の場合
            return false;
        }
        return true;
    }
}