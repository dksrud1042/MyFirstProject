package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.opencsv.CSVReader;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class MainContent extends AppCompatActivity {
    private int cnt_allergies = 0;
    private int cnt_good_oily = 0;
    private int cnt_bad_oily = 0;
    private int cnt_good_dry = 0;
    private int cnt_bad_dry = 0;
    private int cnt_good_sens = 0;
    private int cnt_bad_sens = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_content);

        //제품 이름 받기
        TextView textView = findViewById(R.id.Name1);
        TextView textView1 = findViewById(R.id.jisung1);
        TextView textView2 = findViewById(R.id.jisung2);
        TextView textView3 = findViewById(R.id.gunsung1);
        TextView textView4 = findViewById(R.id.gunsung2);
        TextView textView5 = findViewById(R.id.mingam1);
        TextView textView6 = findViewById(R.id.mingam2);
        TextView textView7 = findViewById(R.id.alergi2);

        Intent intent = getIntent();
        String message = intent.getStringExtra("제품명");
//        String all_ingre = intent.getStringExtra("모든성분");
        textView.setText(message);


        RecyclerView recyclerView2 = findViewById(R.id.recyclerView2);
        //세로 레이아웃 활용
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        recyclerView2.setLayoutManager(layoutManager);
        MaindataAdapter adapter = new MaindataAdapter();

//        List<String> all_ingre_list = Arrays.asList(all_ingre.split(","));

        //RecyclerView안에 data 넣기(사진,이름)
        try {

            InputStreamReader result = new InputStreamReader(getResources().openRawResource(R.raw.result));
            InputStreamReader result2 = new InputStreamReader(getResources().openRawResource(R.raw.result2));
            BufferedReader resultReader = new BufferedReader(result);
            BufferedReader resultReader2 = new BufferedReader(result2);
            resultReader.readLine();
            CSVReader read1 = new CSVReader(resultReader);
            CSVReader read2 = new CSVReader(resultReader2);
            String[] nameRecord = null;
            String[] ingreRecord = null;
            String ingre = null;
            while((nameRecord = read2.readNext()) != null)
            {
                nameRecord[2] = StringUtils.deleteWhitespace(nameRecord[2]);
                if(nameRecord[2].equals(message))
                {
                    ingre = nameRecord[4];
                    break;
                }
            }
            while ((ingreRecord = read1.readNext()) != null) {
                // all_ingre_list안에 성분의 이름이 있으면 출력
                if (ingre.contains(ingreRecord[1])) {
                    switch (ingreRecord[3]) {
                        case "1":
                            adapter.addItem(new Maindata(ingreRecord[1], R.drawable.grade1));
                            break;
                        case "2":
                            adapter.addItem(new Maindata(ingreRecord[1], R.drawable.grade2));
                            break;
                        case "3":
                            adapter.addItem(new Maindata(ingreRecord[1], R.drawable.grade3));
                            break;
                        case "4":
                            adapter.addItem(new Maindata(ingreRecord[1], R.drawable.grade4));
                            break;
                        case "5":
                            adapter.addItem(new Maindata(ingreRecord[1], R.drawable.grade5));
                            break;
                        case "6":
                            adapter.addItem(new Maindata(ingreRecord[1], R.drawable.grade6));
                            break;
                        case "7":
                            adapter.addItem(new Maindata(ingreRecord[1], R.drawable.grade7));
                            break;
                        case "8":
                            adapter.addItem(new Maindata(ingreRecord[1], R.drawable.grade8));
                            break;
                        case "9":
                            adapter.addItem(new Maindata(ingreRecord[1], R.drawable.grade9));
                            break;
                    }

                    if (ingreRecord[4] != null && ingreRecord[4].equals("1")){
                        cnt_allergies += 1;
                    }
                    if (ingreRecord[5] != null && ingreRecord[5].equals("0")){
                        cnt_good_oily += 1;
                    } else if (ingreRecord[5] != null && ingreRecord[5].equals("1")){
                        cnt_bad_oily += 1;
                    }
                    if (ingreRecord[6] != null && ingreRecord[6].equals("0")){
                        cnt_good_dry += 1;
                    } else if (ingreRecord[6] != null && ingreRecord[6].equals("1")){
                        cnt_bad_dry += 1;
                    }
                    if (ingreRecord[7] != null && ingreRecord[7].equals("0")){
                        cnt_good_sens += 1;
                    } else if (ingreRecord[7] != null && ingreRecord[7].equals("1")){
                        cnt_bad_sens += 1;
                    }
                }

            }

        }catch (Exception e){
            Toast.makeText(this, "에러 발생", Toast.LENGTH_LONG).show();
        }

        textView1.setText(String.valueOf(cnt_good_oily));
        textView2.setText(String.valueOf(cnt_bad_oily));
        textView3.setText(String.valueOf(cnt_good_dry));
        textView4.setText(String.valueOf(cnt_bad_dry));
        textView5.setText(String.valueOf(cnt_good_sens));
        textView6.setText(String.valueOf(cnt_bad_sens));
        textView7.setText(String.valueOf(cnt_allergies));

        recyclerView2.setAdapter(adapter);

    }


}