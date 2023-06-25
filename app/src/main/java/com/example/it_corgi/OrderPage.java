package com.example.it_corgi;
import com.example.it_corgi.model.Course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    int total_price = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        orders_list = findViewById(R.id.orders_list);

        for(Course c : MainActivity.fullcourseList){
            if(Order.items_id.contains(c.getId()))
                coursesTitle.add(c.getTitle() + "          " + c.getPrice() + "р.");
                total_price += Integer.parseInt (c.getPrice());
        }
        TextView totalPriceTextView = findViewById(R.id.total_price);
        totalPriceTextView.setText("Сумма: " + total_price + "р.");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, coursesTitle);
        orders_list.setAdapter(adapter);

        ImageButton clearFullCart = findViewById(R.id.clearFullCart);
        clearFullCart.setOnClickListener(new View.OnClickListener() { // метод для очистки корзины
            @Override
            public void onClick(View v) {
                clearFullCart();
                total_price = 0;
                TextView totalPriceTextView1 = findViewById(R.id.total_price);
                totalPriceTextView1.setText("Сумма: " + total_price + "р.");
            }
        });
    }

    public void openPaymentPage(View view) {
        Intent intent = new Intent(this, PaymentPage.class);
        startActivity(intent);
    }

    public void openAboutPage(View view) {
        Intent intent1 = new Intent(this, About.class);
        startActivity(intent1);
    }

    public void openContactsPage(View view) {
        Intent intent2 = new Intent(this, Contacts.class);
        startActivity(intent2);
    }
    public void openMainPage(View view) {
        Intent intent3 = new Intent(this, MainActivity.class);
        startActivity(intent3);
    }

    public void clearFullCart() {
        Order.items_id.clear();
        coursesTitle.clear();
        adapter.notifyDataSetChanged();
    }
}
