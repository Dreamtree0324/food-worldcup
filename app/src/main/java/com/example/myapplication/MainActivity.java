package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<FoodVO> data;
    ArrayList<FoodVO> list = new ArrayList<>();
    ArrayList<FoodVO> nextList = new ArrayList<>();
    ImageView first_image;
    ImageView second_image;
    TextView round;
    FoodVO victory;
    FoodVO first;
    FoodVO second;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first_image = findViewById(R.id.first_img);
        second_image = findViewById(R.id.second_img);
        round = findViewById(R.id.round);

        list.add(new FoodVO(1,"떡볶이", R.drawable.topokki));
        list.add(new FoodVO(2,"돈까스", R.drawable.donkatsu));
        list.add(new FoodVO(3,"후라이드 치킨", R.drawable.chicken));
        list.add(new FoodVO(4,"닭강정", R.drawable.gangjeong));
        list.add(new FoodVO(5,"짜장면", R.drawable.jjajangmyeon));
        list.add(new FoodVO(6,"족발", R.drawable.jokbal));
        list.add(new FoodVO(7,"탕수육", R.drawable.tang));
        list.add(new FoodVO(8,"짬뽕", R.drawable.jjambbong));
        list.add(new FoodVO(9,"닭발",R.drawable.yangnyeom));
        list.add(new FoodVO(10,"볶음밥", R.drawable.friedrice));
        list.add(new FoodVO(11,"토스트", R.drawable.toast));
        list.add(new FoodVO(12,"햄버거", R.drawable.hamburger));
        list.add(new FoodVO(13,"초밥", R.drawable.sushi));
        list.add(new FoodVO(14,"김밥", R.drawable.kimbap));
        list.add(new FoodVO(15,"비빔밥", R.drawable.bibimbap));
        list.add(new FoodVO(16,"물냉면", R.drawable.coldnoodle));
        list.add(new FoodVO(17,"비빔냉면", R.drawable.bibimcold));
        list.add(new FoodVO(18,"타코야끼", R.drawable.takoyaki));
        list.add(new FoodVO(19,"라면", R.drawable.ramyeon));
        list.add(new FoodVO(20,"닭갈비", R.drawable.chickenchops));
        list.add(new FoodVO(21,"불고기", R.drawable.bulgogi));
        list.add(new FoodVO(22,"보쌈", R.drawable.bossam));
        list.add(new FoodVO(23,"훈제오리", R.drawable.smokedduck));
        list.add(new FoodVO(24,"닭볶음탕", R.drawable.chickenbokeumtang));
        list.add(new FoodVO(25,"어묵", R.drawable.fishcake));
        list.add(new FoodVO(26,"피자", R.drawable.pizza));
        list.add(new FoodVO(27,"찜닭", R.drawable.steamedchicken));
        list.add(new FoodVO(28,"쌀국수", R.drawable.ricenoodle));
        list.add(new FoodVO(29,"쫄면", R.drawable.jjolmyeon));
        list.add(new FoodVO(30,"스테이크", R.drawable.steak));
        list.add(new FoodVO(31,"닭꼬치", R.drawable.chickenskewers));
        list.add(new FoodVO(32,"우동", R.drawable.soup));

        first_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextChoose(first);

            }
        });

        second_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextChoose(second);
            }
        });

        setChoose();
    }

    public void setChoose(){
        first = list.get((int) Math.floor(Math.random()*list.size()));
        int fimg = first.getImg();
        first_image.setImageResource(fimg);
        list.remove(first);

        second = list.get((int) Math.floor(Math.random()*list.size()));
        int simg = second.getImg();
        second_image.setImageResource(simg);
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
            int winfood = victory.getImg();
            Intent intent = new Intent(this, Main2Activity.class);
            intent.putExtra("winner", winner);
            intent.putExtra("food", winfood);
            startActivity(intent);

            Log.d("winner", "winner : " + winner);
            return;
        }

        Log.d("size", "사이즈 : " + list.size());

        setChoose();


    }
}
