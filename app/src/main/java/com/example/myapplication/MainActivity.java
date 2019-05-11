package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<FoodVO> data;
    ArrayList<FoodVO> list = new ArrayList<>();
    ArrayList<FoodVO> nextList = new ArrayList<>();
    TextView first_text;
    TextView second_text;
    FoodVO victory;
    FoodVO first;
    FoodVO second;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first_text = findViewById(R.id.first_txt);
        second_text = findViewById(R.id.second_txt);

        list.add(new FoodVO(1,"떡볶이"));
        list.add(new FoodVO(2,"돈까스"));
        list.add(new FoodVO(3,"후라이드 치킨"));
        list.add(new FoodVO(4,"닭강정"));
        list.add(new FoodVO(5,"짜장면"));
        list.add(new FoodVO(6,"족발"));
        list.add(new FoodVO(7,"김.피.탕"));
        list.add(new FoodVO(8,"짬뽕"));
        /*list.add(new FoodVO(9,"닭발"));
        list.add(new FoodVO(10,"볶음밥"));
        list.add(new FoodVO(11,"토스트"));
        list.add(new FoodVO(12,"햄버거"));
        list.add(new FoodVO(13,"초빕"));
        list.add(new FoodVO(14,"김밥"));
        list.add(new FoodVO(15,"비빔밥"));
        list.add(new FoodVO(16,"물냉면"));
        list.add(new FoodVO(17,"비빔냉면"));
        list.add(new FoodVO(18,"타코야끼"));
        list.add(new FoodVO(19,"라면"));
        list.add(new FoodVO(20,"닭갈비"));
        list.add(new FoodVO(21,"불고기"));
        list.add(new FoodVO(22,"보쌈"));
        list.add(new FoodVO(23,"제육볶음"));
        list.add(new FoodVO(24,"닭볶음탕"));
        list.add(new FoodVO(25,"어묵"));
        list.add(new FoodVO(26,"피자"));
        list.add(new FoodVO(27,"찜닭"));
        list.add(new FoodVO(28,"쌀국수"));
        list.add(new FoodVO(29,"쫄면"));
        list.add(new FoodVO(30,"스테이크"));
        list.add(new FoodVO(31,"닭꼬치"));
        list.add(new FoodVO(32,"우동"));*/

        first_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextChoose(first);


            }
        });

        second_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextChoose(second);
            }
        });

        setChoose();
    }

    public void setChoose(){
        first = list.get((int) Math.floor(Math.random()*list.size()));
        String fname = first.getName();
        first_text.setText(fname);
        list.remove(first);

        second = list.get((int) Math.floor(Math.random()*list.size()));
        String sname = second.getName();
        second_text.setText(sname);
        list.remove(second);

    }

    public void nextChoose(FoodVO result){
        nextList.add(result);
        if(list.size() == 0){
            for(FoodVO slist : nextList){
                list.add(slist);
            }

            Log.d("list", "값" + list.get(0).toString());
            nextList.clear();
        }

        if(list.size() == 1){
            victory = list.get(0);
            String winner = victory.getName();
            Intent intent = new Intent(this, Main2Activity.class);
            intent.putExtra("winner", winner);
            startActivity(intent);

            Log.d("winner", "winner : " + winner);
            return;
        }

        Log.d("size", "사이즈 : " + list.size());

        setChoose();

    }
}
