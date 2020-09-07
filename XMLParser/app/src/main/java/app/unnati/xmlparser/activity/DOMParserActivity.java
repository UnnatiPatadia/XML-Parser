package app.unnati.xmlparser.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.InputStream;

import app.unnati.xmlparser.R;
import app.unnati.xmlparser.xmlParser.DOMParser;

public class DOMParserActivity extends AppCompatActivity {
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dom_parser);

        tv1 = findViewById(R.id.textView1);

        try {
            InputStream is = getAssets().open("file.xml");
            DOMParser.parser(is);

            for (int i = 0; i < DOMParser.nList.getLength(); i++) {

                Node node = DOMParser.nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element2 = (Element) node;
                    tv1.setText(tv1.getText() + "\nName : " + DOMParser.getValue("name", element2) + "\n");
                    tv1.setText(tv1.getText() + "Surname : " + DOMParser.getValue("surname", element2) + "\n");
                    tv1.setText(tv1.getText() + "-----------------------");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
