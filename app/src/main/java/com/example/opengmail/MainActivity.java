package com.example.opengmail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edtEmail;
    private EditText edtEmail2;
    private EditText edtSubject;
    private EditText edtMessage;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpVars();

    }


    private void setUpVars() {
        edtSubject = findViewById(R.id.edtSubject);
        edtMessage = findViewById(R.id.edtMessage);
        btnSend = findViewById(R.id.btnSend);
        edtEmail = findViewById(R.id.edtEmail);
        edtEmail2 = findViewById(R.id.edtEmail2);
    }
    public void btnSendOnclick(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, edtEmail.getText().toString());
        intent.putExtra(Intent.EXTRA_EMAIL, edtEmail2.getText().toString());
        intent.putExtra(Intent.EXTRA_SUBJECT, edtSubject.getText().toString());
        intent.putExtra(Intent.EXTRA_TEXT, edtMessage.getText().toString());
        intent.setType("text/plain");

        Intent chooser = Intent.createChooser(intent, null);

        startActivity(chooser);
    }
}