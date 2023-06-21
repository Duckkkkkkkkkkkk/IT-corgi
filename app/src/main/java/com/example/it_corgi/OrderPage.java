package com.example.it_corgi;
import com.example.it_corgi.model.Course;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ImageButton;
import android.view.View;

import com.example.it_corgi.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderPage extends AppCompatActivity {

    private ListView orders_list;
    private ArrayAdapter<String> adapter;
    private List<String> coursesTitle = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        orders_list = findViewById(R.id.orders_list);

        for(Course c : MainActivity.fullcourseList){
            if(Order.items_id.contains(c.getId()))
                coursesTitle.add(c.getTitle());
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, coursesTitle);
        orders_list.setAdapter(adapter);

        ImageButton clearFullCart = findViewById(R.id.clearFullCart);
        clearFullCart.setOnClickListener(new View.OnClickListener() { // метод для очистки корзины
            @Override
            public void onClick(View v) {
                clearFullCart();
            }
        });
    }

    public void clearFullCart() {
        Order.items_id.clear();
        coursesTitle.clear();
        adapter.notifyDataSetChanged();
    }
}