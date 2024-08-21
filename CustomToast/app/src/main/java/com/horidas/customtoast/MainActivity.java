package com.horidas.customtoast;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnToast;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnToast = findViewById(R.id.btnToast);

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Default Toast
                //Toast.makeText(getApplicationContext(), "Message", Toast.LENGTH_SHORT).show();

                //Custom Toast
                Toast toast = new Toast(getApplicationContext());
                View toastView = getLayoutInflater().inflate(R.layout.custom_toast_layout, (ViewGroup) findViewById(R.id.customToast));
                toast.setView(toastView);
                TextView txtMsgToast = toastView.findViewById(R.id.txtMsgToast);
                txtMsgToast.setText("Message sent successfully");
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP | Gravity.END, 0, 0);
                toast.show();
            }
        });

    }
}