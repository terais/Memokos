package memoko.st.kn.memoko.component;

import java.util.ArrayList;
import java.util.HashMap;

import memoko.st.kn.memoko.ListActivity;

/**
 * 一覧画面に表示するのはデータの最初10文字だけ。
 */
public class DataAdjust {
    public static ArrayList<HashMap<String,String>> dataAdjust() {
        //データを10文字にしたものを格納するリスト
        ArrayList<HashMap<String,String>> showList = new ArrayList<>();

        for(HashMap<String,String> data : ListActivity.getMemoList()) {
            String body = data.get("body");

            if(body.length() > 10){
                // リストに表示するのは10文字まで
                body = body.substring(0, 11) + "...";
            }
            data.put("body",body);
            showList.add(data);
        }

        return showList;
    }
}
