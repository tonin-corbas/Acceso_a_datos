package org.example;

import org.json.JSONObject;
import org.json.XML;

public class Json2Xml {
    public String convertirJsonAXml(JSONObject jsonObject) throws Exception {
        try {
            return XML.toString(jsonObject);
        } catch (Exception e) {
            throw new Exception("Error al convertir JSON a XML: " + e.getMessage());
        }
    }
}
