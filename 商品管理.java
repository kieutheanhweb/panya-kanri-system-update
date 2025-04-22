package BakeryManager;
/**
 * 商品管理クラス：新商品を追加する、商品リストを表示クラス。
 */
import java.util.ArrayList;
import java.util.List;
public class  商品管理{

    private List<商品情報> products = new ArrayList<>();      // 商品のリスト

    // 商品をリストに追加するメソッド
    public void addProducts(商品情報 product){
        products.add(product);          //ArrayList　で商品をリストに追加.
    }
    // すべての商品情報を表示するメソッド
    public void displayAllProducts(){
        for (商品情報 product : products) {
            product.displayProductInfo();      // 商品情報を表示する
        }
    }
}
