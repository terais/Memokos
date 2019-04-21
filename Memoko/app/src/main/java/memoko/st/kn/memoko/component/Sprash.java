package memoko.st.kn.memoko.component;

/**
 * アプリ起動時にメモっ娘を表示する時間を操作するメソッド
 */
public class Sprash {
    public static void sprash(){
        //メモっ娘を１秒表示
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.print(e);
        }
    }
}
