package app.unnati.xmlparser.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import app.unnati.xmlparser.R;
import app.unnati.xmlparser.adapter.SAXParserAdapter;
import app.unnati.xmlparser.parserModel.SAXModel;
import app.unnati.xmlparser.xmlParser.SAXParser;

public class SAXParserActivity extends AppCompatActivity {

    SAXParser saxParser;
    ArrayList<SAXModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sax_parser);

        ListView lv = findViewById(R.id.user_list);

        saxParser = new SAXParser(SAXParserActivity.this);
        saxParser.get();

        for (int i = 0; i < saxParser.AlltargetValues.size(); i++) {
            String name = saxParser.AlltargetValues.get(i).getName();
            String salary = saxParser.AlltargetValues.get(i).getSalary();

            SAXModel saxModel = new SAXModel();
            saxModel.setName(name);
            saxModel.setSalary(salary);

            list.add(saxModel);
            Log.d("Unnati ", "List Name:" + name);
        }

        if (list != null && list.size() > 0) {
            SAXParserAdapter adapter = new SAXParserAdapter(list, this);
            //attaching adapter to the listview
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    String strName = list.get(position).getName();
                    Toast.makeText(getApplicationContext(),
                            "Name: " + strName, Toast.LENGTH_SHORT)
                            .show();
                }
            });
        } else {
            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
        }

    }
}
