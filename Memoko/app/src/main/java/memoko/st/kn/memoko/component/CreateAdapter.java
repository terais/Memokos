package memoko.st.kn.memoko.component;

import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import memoko.st.kn.memoko.ListActivity;

public class CreateAdapter {
    public static SimpleAdapter createAdapter(ArrayList<HashMap<String,String>> memoList) {
        // Adapter生成
        final SimpleAdapter simpleAdapter = new SimpleAdapter(ListActivity.getInstance(),
                memoList, // 使用するデータ
                android.R.layout.simple_list_item_2, // 使用するレイアウト（今回はテンプレートを使う）
                new String[]{"body","id"}, // どの項目を
                new int[]{android.R.id.text1, android.R.id.text2} // どのidの項目に入れるか
        );

        return simpleAdapter;
    }
}
