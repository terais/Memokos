package memoko.st.kn.memoko.component;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TwoLineListItem;
import memoko.st.kn.memoko.ListActivity;

public class ListClick {
    public static void listClick(ListView listView) {
        // リスト項目をクリックした時の処理
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            /**
             * @param parent ListView
             * @param view 選択した項目
             * @param position 選択した項目の添え字
             * @param id 選択した項目のID
             */
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // インテント作成  第二引数にはパッケージ名からの指定で、遷移先クラスを指定
                Intent intent = new Intent(ListActivity.getInstance(), memoko.st.kn.memoko.Create.class);

                // 選択されたビューを取得 TwoLineListItemを取得した後、text2の値を取得する
                // TwoLineListItemはAPI17では推奨されていないためいつか修正しよう。
                TwoLineListItem two = (TwoLineListItem)view;
                TextView idTextView = two.getText2();
                String isStr = (String) idTextView.getText();
                // 値を引き渡す (識別名, 値)の順番で指定します
                intent.putExtra("id", isStr);
                // Activity起動
                ListActivity.getInstance().startActivity(intent);
            }
        });
    }
}
