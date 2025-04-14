package org.example;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    public static void main(String[] args) {
        String xmlFilePath = "ADU5EX02JAKC/XMLoriginal.xml";
        String jsonFilePath = "ADU5EX02JAKC/JSONconvertido.json";
        String convertedXmlFilePath = "ADU5EX02JAKC/XMLreconvertido.xml";

        try {
            // Crear archivos si no existen
            if (!Files.exists(Paths.get(xmlFilePath))) {
                Files.createFile(Paths.get(xmlFilePath));
                Files.writeString(Paths.get(xmlFilePath), "<root></root>", StandardOpenOption.TRUNCATE_EXISTING);
                System.out.println("Archivo XML creado: " + xmlFilePath);
            }
            if (!Files.exists(Paths.get(jsonFilePath))) {
                Files.createFile(Paths.get(jsonFilePath));
                Files.writeString(Paths.get(jsonFilePath), "{}", StandardOpenOption.TRUNCATE_EXISTING);
                System.out.println("Archivo JSON creado: " + jsonFilePath);
            }
            if (!Files.exists(Paths.get(convertedXmlFilePath))) {
                Files.createFile(Paths.get(convertedXmlFilePath));
                Files.writeString(Paths.get(convertedXmlFilePath), "<root></root>", StandardOpenOption.TRUNCATE_EXISTING);
                System.out.println("Archivo XML convertido creado: " + convertedXmlFilePath);
            }

            // Leer el archivo XML original
            String xmlContent = Files.readString(Paths.get(xmlFilePath));
            System.out.println("Contenido original XML:\n" + xmlContent);

            // Convertir XML a JSON y guardar en un archivo
            Xml2Json xml2Json = new Xml2Json();
            JSONObject jsonObject = xml2Json.convertirXmlAJson(xmlContent);
            Files.writeString(Paths.get(jsonFilePath), jsonObject.toString(4), StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("\nContenido convertido a JSON y guardado en " + jsonFilePath);

            // Leer el archivo JSON generado
            String jsonContent = Files.readString(Paths.get(jsonFilePath));
            System.out.println("\nContenido del archivo JSON:\n" + jsonContent);

            // Convertir JSON a XML y guardar en un archivo
            Json2Xml json2Xml = new Json2Xml();
            String convertedXml = json2Xml.convertirJsonAXml(new JSONObject(jsonContent));
            Files.writeString(Paths.get(convertedXmlFilePath), convertedXml, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("\nContenido convertido de nuevo a XML y guardado en " + convertedXmlFilePath);

            // Mostrar el contenido XML final
            System.out.println("\nContenido del archivo XML convertido:\n" + convertedXml);

        } catch (IOException e) {
            System.err.println("Error de entrada/salida: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
