package com.example.miniproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import purchaseSuccess.PurchaseSuccessActivity;

public class OrderFormActivity extends AppCompatActivity {

    EditText editTextName, editTextAddress, editTextPhone;
    Button buttonPlaceOrder;
    Spinner spinnerPaymentMethod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_form);

        editTextName = findViewById(R.id.editTextName);
        editTextAddress = findViewById(R.id.editTextAddress);
        editTextPhone = findViewById(R.id.editTextPhone);
        buttonPlaceOrder = findViewById(R.id.buttonPlaceOrder);
        spinnerPaymentMethod = findViewById(R.id.spinnerPaymentMethod);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.payment_methods, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPaymentMethod.setAdapter(adapter);

        String productName = getIntent().getStringExtra("productName");
        int productPrice = getIntent().getIntExtra("productPrice", 0);

        buttonPlaceOrder.setOnClickListener(v -> {
            String name = editTextName.getText().toString();
            String address = editTextAddress.getText().toString();
            String phone = editTextPhone.getText().toString();
            String paymentMethod = spinnerPaymentMethod.getSelectedItem().toString();

            Intent intent = new Intent(OrderFormActivity.this, PurchaseSuccessActivity.class);
            intent.putExtra("paymentMethod", paymentMethod); // ส่ง payment method ที่เลือก
            startActivity(intent);

            intent.putExtra("name", name);
            intent.putExtra("address", address);
            intent.putExtra("phone", phone);
            intent.putExtra("productName", productName);
            intent.putExtra("productPrice", productPrice);
            intent.putExtra("paymentMethod", paymentMethod);

            startActivity(intent);
        });
    }
}
