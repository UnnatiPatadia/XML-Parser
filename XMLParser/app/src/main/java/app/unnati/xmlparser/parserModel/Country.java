package app.unnati.xmlparser.parserModel;

import java.io.Serializable;

public class Country implements Serializable {

    public static String id;
    public static String name;
    public static String capital;

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        Country.id = id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Country.name = name;
    }

    public static String getCapital() {
        return capital;
    }

    public static void setCapital(String capital) {
        Country.capital = capital;
    }
}
