package com.example.tryyourluck;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MyFragment extends Fragment {
    // 結果を示す文字列を保持するフィールド
    private String[] str;

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
    }

    // フラグメントがインスタンスかされる際に呼ばれるメソッド
    @Override
    public View onCreateView(
            // 第1パラメーター:XMLを解釈してオブジェクトを生成する LayoutInflaterクラス
            LayoutInflater inflater,
            // 第2パラメーター:フラグメントの親デビュー
            ViewGroup container,
            // 第3パラメーター:以前の状態が保存されていれば渡される
            Bundle savedInstanceState
    ){
        // フラグメントをcontainer(親デビュー)上に構築し、これを戻り値にする
        View v = inflater.inflate(R.layout.fragment_my, container);
        // 結果として表示する文字配列を取得
        str = getResources().getStringArray(R.array.arr1);
        // テキストビューのインスタンスを取得
        final TextView tv = (TextView) v.findViewById(R.id.textView1);
        // トーストに表示する文字列を取得
        final String msg[] = getResources().getStringArray(R.array.arr2);

        // ボタンタップ時の処理
        ((Button) v.findViewById(R.id.button1))
                .setOnClickListener(
                        new View.OnClickListener(){
                            @Override
                            public void onClick(View v){
                                // 結果を抽出するメソッドを実行
                                String result = chooseOne();
                                // 結果をテキストビューに表示
                                tv.setText(result);

                                // 結果の文字列に応じてトーストにメッセージを表示
                                if (result.equals(str[0])) {
                                    Toast.makeText(
                                            getActivity(),
                                            msg[0],   // 文字配列の先頭要素を表示
                                            Toast.LENGTH_SHORT).show();
                                }
                                if (result.equals(str[1])) {
                                    Toast.makeText(
                                            getActivity(),
                                            msg[1],   // 文字配列の2番目の要素を表示
                                            Toast.LENGTH_SHORT).show();
                                }
                                if (result.equals(str[2])) {
                                    Toast.makeText(
                                            getActivity(),
                                            msg[2],   // 文字配列の3番目の要素を表示
                                            Toast.LENGTH_SHORT).show();
                                }
                                if (result.equals(str[3])) {
                                    Toast.makeText(
                                            getActivity(),
                                            msg[3],   // 文字配列の4番目の要素を表示
                                            Toast.LENGTH_SHORT).show();
                                }
                                if (result.equals(str[4])) {
                                    Toast.makeText(
                                            getActivity(),
                                            msg[4],   // 文字配列の5番目の要素を表示
                                            Toast.LENGTH_SHORT).show();
                                }

                            }


                        });
        // container(親ビュー)上に構築したフラグメントを
        // onCreateView()の戻り値として返す
        return v;
    }
    /******************************************************************************
     * ランダムに生成した値をりようして結果を抽出する
     * @return  String
     *****************************************************************************/
    private String chooseOne(){
        Random rnd = new Random();

        int r = rnd.nextInt(10);
        String result = str[4];

        if ( r < 2){
            result = str[0];
        }else if ( r >= 2 && r < 4){
            result = str[1];
        }else if ( r >= 4 && r < 6){
            result = str[2];
        }else if ( r >= 6 && r < 8){
            result = str[3];
        }
        return result;
    }
}
