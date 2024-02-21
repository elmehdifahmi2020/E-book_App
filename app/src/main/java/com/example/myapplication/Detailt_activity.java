package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.addBook.BookRepository;

import java.util.List;

public class Detailt_activity extends AppCompatActivity {
    BookRepository repository ;
    TextView titleBook , writerBook , description,priceBook,qauntity,total;
    ImageView plus , minus,pic_Book;
    Button buy;
    int numberQ = 1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailt_activty);
        initView();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String price = bundle.getString("price");
        titleBook.setText(bundle.getString("title"));
        writerBook.setText(bundle.getString("writer"));
        description.setText(bundle.getString("descriptionn"));
        pic_Book.setImageResource(bundle.getInt("image"));
        priceBook.setText(price+" $");
        qauntity.setText(String.valueOf(numberQ));
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberQ+=1;
                qauntity.setText(String.valueOf(numberQ));
                total.setText("Total : "+Integer.parseInt(price)*numberQ+" $");


            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numberQ>1){
                    numberQ-=1;
                    qauntity.setText(String.valueOf(numberQ));
                    total.setText("Total : "+Integer.parseInt(price)*numberQ+" $");
                }else {
                    qauntity.setText(String.valueOf(numberQ));
                    total.setText("Total : "+Integer.parseInt(price)*numberQ+" $");

                }
            }
        });
        //List<String> list = new MainActivity().sendData();
        //titleBook.setText(activity.sendData().size());
    }
    void initView(){
        total = findViewById(R.id.total);
        qauntity = findViewById(R.id.quantity);
        priceBook = findViewById(R.id.price_book);
       titleBook = findViewById(R.id.title_book);
       writerBook = findViewById(R.id.wrtiter_book);
       description = findViewById(R.id.detailDesc);
       plus = findViewById(R.id.image_plus);
       minus = findViewById(R.id.image_minus);
       pic_Book =findViewById(R.id.pic_book);
       buy = findViewById(R.id.buy);
    }
}
