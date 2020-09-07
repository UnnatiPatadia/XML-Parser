package app.unnati.xmlparser.xmlParser;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

import app.unnati.xmlparser.parserModel.Country;

public class XMLPullParser {

    public static ArrayList<Country> parseXML(XmlPullParser parser) throws XmlPullParserException, IOException
    {
        ArrayList<Country> countries = null;
        int eventType = parser.getEventType();
        Country country = null;

        while (eventType != XmlPullParser.END_DOCUMENT){
            String name;
            switch (eventType){
                case XmlPullParser.START_DOCUMENT:
                    countries = new ArrayList();
                    break;
                case XmlPullParser.START_TAG:
                    name = parser.getName();
                    if (name.equals("country")){
                        country = new Country();
                        Country.id =parser.getAttributeValue(null,"id");
                    } else if (country != null){
                        if (name.equals("name")){
                            Country.name = parser.nextText();
                        } else if (name.equals("capital")){
                            Country.capital = parser.nextText();
                        }
                    }
                    break;
                case XmlPullParser.END_TAG:
                    name = parser.getName();
                    if (name.equalsIgnoreCase("country") && country != null){
                        if (countries != null) {
                            countries.add(country);
                        }
                    }
            }
            eventType = parser.next();
        }

        return countries;

    }
}
