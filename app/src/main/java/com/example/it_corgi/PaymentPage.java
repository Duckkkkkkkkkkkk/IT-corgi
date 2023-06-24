package com.example.it_corgi;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PaymentPage extends AppCompatActivity {

    private ImageButton paymentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_page);

        paymentButton = findViewById(R.id.to_pay);
        paymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPaymentSuccessfulSnackbar();
            }
        });
    }

    private void showPaymentSuccessfulSnackbar() {
        Snackbar.make(paymentButton, "Оплата произошла успешно!", Snackbar.LENGTH_SHORT).show();
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
}