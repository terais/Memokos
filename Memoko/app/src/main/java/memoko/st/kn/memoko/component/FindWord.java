package memoko.st.kn.memoko.component;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import memoko.st.kn.memoko.ListActivity;
import memoko.st.kn.memoko.R;

public class FindWord {

    /**
     * ダイアログでOKボタンが押されたら検索ワードをリターン
     */
    public static void findWord() {
        // idがfindButtonのボタンを取得
        Button findButton = ListActivity.getInstance().findViewById(R.id.findButton);
        //clickイベント追加
        findButton.setOnClickListener(new View.OnClickListener() {
            /**
             * ダイアログ生成
             */
            @Override
            public void onClick(View v) {
                //文字入力フォームのビューを作成
                final EditText editView = new EditText(ListActivity.getInstance());

                // ダイアログ生成  AlertDialogのBuilderクラスを指定してインスタンス化
                AlertDialog.Builder dialog = new AlertDialog.Builder(ListActivity.getInstance());
                // タイトル設定
                dialog.setTitle("検索");
                //入力フォーム
                dialog.setView(editView);

                // OKボタン処理(色変えて再表示)
                dialog.setPositiveButton("検索", new DialogInterface.OnClickListener(){

                    /**
                     * 入力された文字列をwordに設定
                     */
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String word = editView.getText().toString();

                        //HITしたIDを入れるリスト
                        ArrayList<String> hit = new ArrayList<>();

                        //検索文字列とmemoListを比較してHITしたらIDを控える
                        for(HashMap<String,String> data : ListActivity.getMemoList()) {
                            String body = data.get("body");

                            if(body.contains(word)) {
                                hit.add(data.get("id"));
                            }
                        }
                        ListActivity.getInstance().setHit(hit);

                        //wordと一致する場合bgカラーを黄色にする
                        ListActivity.getSimpleAdapter().setViewBinder(ListActivity.mViewBinder);
                        // idがmemoListのListViewを取得
                        ListView listView = ListActivity.getInstance().findViewById(R.id.memoList);
                        //背景色を変えてから再表示
                        listView.setAdapter(ListActivity.getSimpleAdapter());

                    }
                });

                // NGボタン作成
                dialog.setNegativeButton("キャンセル", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 何もしないで閉じる
                    }
                });

                // ダイアログ表示
                dialog.create().show();

            }

        });
    }
}
