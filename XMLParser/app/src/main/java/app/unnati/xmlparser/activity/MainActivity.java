package app.unnati.xmlparser.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import app.unnati.xmlparser.R;

public class MainActivity extends AppCompatActivity {

    Button btnDOMParser, btnSAXParser, btnXMLPullarser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDOMParser = findViewById(R.id.btnDOMParser);
        btnSAXParser = findViewById(R.id.btnSAXParser);
        btnXMLPullarser = findViewById(R.id.btnXMLPullarser);

        btnDOMParser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DOMParserActivity.class));
            }
        });

        btnSAXParser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SAXParserActivity.class));
            }
        });

        btnXMLPullarser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, XMLPullParserActivity.class));
            }
        });
    }
}
