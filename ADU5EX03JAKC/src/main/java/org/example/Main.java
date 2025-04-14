package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.json.JSONObject;
import org.json.XML;

public class Main {
    private static final String DATABASE_NAME =  "AD2025";
    private static final String COLLECTION_NAME = "correccio";
    private static final String MONGO_URI = "mongodb+srv://user:passguord@cluster0.to9ja.mongodb.net/";

    public static void main(String[] args) {
        // Crear cliente MongoDB
        try (MongoClient mongoClient = MongoClients.create(MONGO_URI)) {
            // Conectar a la base de datos
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

            // Verificar si hay documentos
            if (collection.countDocuments() == 0) {
                System.out.println("La colección está vacía. Inserta datos antes de ejecutar.");
                return;
            }

            // Recuperar documentos y convertirlos a XML
            try (MongoCursor<Document> cursor = collection.find().iterator()) {
                while (cursor.hasNext()) {
                    Document doc = cursor.next();
                    JSONObject json = new JSONObject(doc.toJson()); // Convertir BSON a JSON
                    String xml = XML.toString(json, "element");     // Convertir JSON a XML con raíz <element>
                    System.out.println("XML generado:\n" + xml + "\n");
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
