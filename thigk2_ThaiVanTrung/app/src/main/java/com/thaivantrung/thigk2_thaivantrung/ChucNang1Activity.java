package com.thaivantrung.thigk2_thaivantrung;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class ChucNang1Activity extends AppCompatActivity {
    private static final double RATE_USD = 25400.0; // 1 USD = 25,400 VND

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuc_nang1);

        EditText etVnd = findViewById(R.id.et_vnd);
        Button btnConvert = findViewById(R.id.btn_convert);
        TextView tvResult = findViewById(R.id.tv_result);

        btnConvert.setOnClickListener(v -> {
            String input = etVnd.getText().toString().trim();
            if (input.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập số tiền VND!", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                double vnd = Double.parseDouble(input.replace(",", ""));
                double usd = vnd / RATE_USD;
                tvResult.setText(String.format(
                        "%.0f VND\n=\n%.4f USD\n\n(Tỉ giá: 1 USD = %,.0f VND)", vnd, usd, RATE_USD));
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Số tiền không hợp lệ!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
