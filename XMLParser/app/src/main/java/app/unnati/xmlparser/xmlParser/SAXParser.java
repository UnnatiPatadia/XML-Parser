package app.unnati.xmlparser.xmlParser;

import android.app.Activity;
import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParserFactory;

import app.unnati.xmlparser.parserModel.SAXModel;

public class SAXParser extends DefaultHandler {

    public List<SAXModel> AlltargetValues;
    private boolean currentTag = false;
    private String currentvalue = "";
    private SAXModel targetValue = null;
    private Activity activity;

    public SAXParser(Activity activity) {
        this.activity = activity;
        AlltargetValues = new ArrayList<>();
    }

    public void get() {
        try {
            InputStream is = activity.getAssets().open("sample.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            javax.xml.parsers.SAXParser saxParser = factory.newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();
            xmlReader.setContentHandler(this);
            xmlReader.parse(new InputSource(is));
        } catch (Exception e) {
            Log.e("Unnati ", "error in parsing response " + e.toString());
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        if (currentTag) {
            currentvalue = currentvalue + new String(ch, start, length);
            currentTag = false;
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // Log.e("Unnati","localname "+localName);
        currentTag = true;
        currentvalue = "";
        if (localName.equalsIgnoreCase("employee")) {
            targetValue = new SAXModel();
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        currentTag = false;
        if (localName.equalsIgnoreCase("name")) {
            targetValue.setName(currentvalue);
        } else if (localName.equalsIgnoreCase("salary")) {
            targetValue.setSalary(currentvalue);
        } else if (localName.equalsIgnoreCase("employee")) {
            AlltargetValues.add(targetValue);
//            Log.e("Unnati ","size all taget value "+AlltargetValues.size());
        }
    }

}
