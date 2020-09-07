package app.unnati.xmlparser.xmlParser;

import android.util.Log;

import org.w3c.dom.DOMError;
import org.w3c.dom.DOMErrorHandler;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class DOMParser implements DOMErrorHandler {

    public static Element element;
    public static NodeList nList;
    public DOMParser() {
    }

    public static void parser (InputStream is){
        try {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);

            element=doc.getDocumentElement();
            element.normalize();

            nList = doc.getElementsByTagName("employee");

        } catch (Exception e) {e.printStackTrace();}
    }

    public static String getValue(String tag, Element element) {
        try {
            NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
            Node node = nodeList.item(0);
            return node.getNodeValue();
        } catch (Exception e)
        {
            Log.e("Unnati ","error in parsing response "+e.toString());
        }
        return  "";
    }

    @Override
    public boolean handleError(DOMError error) {
        return false;
    }
}
