package BakeryManager;
/**
 * 顧客情報管理クラス：顧客情報を追加する、表示するクラス。
 */
import java.util.ArrayList;
import java.util.List;
public class 顧客情報管理 {
    private List<顧客情報> customers = new ArrayList<>();       // 顧客のリスト

    // 顧客をリストに追加するメソッド
    public void addCustomer(顧客情報 customer) {
        customers.add(customer);            // 顧客をリストに追加
    }

    // すべての顧客情報を表示するメソッド
    public void displayAllCustomers() {
        for (顧客情報 customer : customers) {
            customer.displayInfo();            // 顧客情報を表示する
        }
    }
}
