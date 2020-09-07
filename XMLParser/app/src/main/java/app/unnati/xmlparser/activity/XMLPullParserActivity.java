package app.unnati.xmlparser.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import app.unnati.xmlparser.R;
import app.unnati.xmlparser.parserModel.Country;
import app.unnati.xmlparser.xmlParser.XMLPullParser;

public class XMLPullParserActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml_pull_parser);

        textView = findViewById(R.id.textView);
        XmlPullParserFactory pullParserFactory;

        try {
            pullParserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = pullParserFactory.newPullParser();

            InputStream in_s = getApplicationContext().getAssets().open("country.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in_s, null);

            ArrayList<Country> countries = XMLPullParser.parseXML(parser);
            StringBuilder text = new StringBuilder();
            for (Country country : countries) {
                text.append("id : ").append(country.getId()).append(" name : ").append(country.getName()).append(" capital : ").append(country.getCapital()).append("\n");
            }
            textView.setText(text.toString());

        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }


    }

}
