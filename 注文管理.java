package BakeryManager;
/**
 * 注文管理クラス：注文を追加する、商品情報を表示クラス。
 */
import java.util.ArrayList;
import java.util.List;
public class 注文管理 {
    private List<注文情報> orders = new ArrayList<>();     // リスト注文一覧

    // 注文をリストに追加するメソッド
    public void addOrder(注文情報 order) {
        orders.add(order);
    }
    // 全ての注文情報を表示するメソッド
    public void displayAllOrders() {
        for (注文情報 order : orders) {
            order.displayOrderInfo();
        }
    }
}
