package BakeryManager;
/**
 * 客様情報クラス：お客様の名前、住所、電話番号、生年月日、メールアドレスを管理するクラス。
 * お客様情報を作成・表示・更新するためのメソッドが含まれている。
 */
import java.time.LocalDate;

public class 顧客情報 {
    // 客様情報
    private String name;            //お客様の名前
    private String address;        //住所
    private String phone;           //電話番号
    private String email;           //メールアドレス
    private LocalDate birthDate;    //生年月日

    //コンストラクタ

    public 顧客情報(String name, String address, String phone, String email, LocalDate birthDate) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.birthDate = birthDate;
    }
    // Getter メソッド

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
    //Setter メソッド

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    //  客様情報を表示
    @Override
    public String toString() {
        return "名前：" + name + "\n" +
                "住所：" + address + "\n" +
                "電話番号：" + phone + "\n" +
                "Email：" + email + "\n" +
                "生年月日：" + birthDate;
    }
    public void displayInfo(){
        System.out.println(this);
    }
}
