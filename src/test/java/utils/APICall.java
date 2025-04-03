package utils;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


public class APICall {
    static String clientID = "6D731D9A3CAA44BB8FA814DB2E12AFF7";
    static String clientSecret = "3ff6a26122985710b5c0b883ab9ff4fbc0ab1eb379459701a9e365eb2b85c822";
    static String url = "https://xray.cloud.getxray.app/api/v2/authenticate";
    public static String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5hbnQiOiJiNmNhZGQwNS1lMzQxLTNmMTctYjU1Zi00OTM0MTI4MWQ4MmEiLCJhY2NvdW50SWQiOiI3MTIwMjA6Njk3ZWFkNGYtNWYwOC00YTQ1LTk2MmUtZTNiN2IzNWNjYzdlIiwiaXNYZWEiOmZhbHNlLCJpYXQiOjE3NDM1NzkxNTUsImV4cCI6MTc0MzY2NTU1NSwiYXVkIjoiNkQ3MzFEOUEzQ0FBNDRCQjhGQTgxNERCMkUxMkFGRjciLCJpc3MiOiJjb20ueHBhbmRpdC5wbHVnaW5zLnhyYXkiLCJzdWIiOiI2RDczMUQ5QTNDQUE0NEJCOEZBODE0REIyRTEyQUZGNyJ9.dSiyO75wq1fw9vb8wr1ROdfxa2gWdmrLaneksGSbAAU";
    static String generatedToken;


    public static void main(String[] args) {

//        generatedToken = generateToken();
//        generateToken();
//
//        getFeatures(token);

          jsonExportXray(token);
    }


    public static String generateToken(){

        HttpClient client = HttpClient.newHttpClient();

        String jsonInputString = "{ \"client_id\": \""+clientID+"\", \"client_secret\": \""+clientSecret+"\" }";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonInputString))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

            //generatedToken = response.body().replace("\"","");

            return response.body().replace("\"","");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    public static void getFeatures(String token){

        try {

            String issueKey = "POEI20252-623";
            String outputFile = "features.zip";

            HttpClient client = HttpClient.newBuilder()
                    .followRedirects(HttpClient.Redirect.NORMAL)
                    .build();

            String apiUrl = "https://xray.cloud.getxray.app/api/v2/export/cucumber?keys=" + issueKey;

            System.out.println("Token utilisé: " + token);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .header("Authorization", "Bearer " + token)
                    .GET()
                    .build();

            // Téléchargement du fichier binaire
            HttpResponse<Path> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofFile(Paths.get(outputFile))
            );

            System.out.println("Status code: " + response.statusCode());
            System.out.println("Fichier téléchargé: " + response.body().toAbsolutePath());


            dezipFichier("features.zip", "src/test/resources/importedFeatures");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }




    }


    public static void dezipFichier(String cheminZip, String dossierDestination) {
        File dossierDest = new File(dossierDestination);

        // Crée le dossier de destination s'il n'existe pas
        if (!dossierDest.exists()) {
            dossierDest.mkdirs();
        }

        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(cheminZip))) {
            ZipEntry entry;
            // Lire les entrées du fichier ZIP
            while ((entry = zipInputStream.getNextEntry()) != null) {
                File fichierDest = new File(dossierDestination, entry.getName());

                // Créer des sous-dossiers si nécessaire
                if (entry.isDirectory()) {
                    fichierDest.mkdirs();
                } else {
                    // Extraire le fichier
                    try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fichierDest))) {
                        byte[] buffer = new byte[1024];
                        int longueur;
                        while ((longueur = zipInputStream.read(buffer)) != -1) {
                            bos.write(buffer, 0, longueur);
                        }
                    }
                }
                zipInputStream.closeEntry();
            }
            System.out.println("Les fichiers ont été extraits avec succès dans " + dossierDestination);
        } catch (IOException e) {
            System.err.println("Erreur lors de la décompression : " + e.getMessage());
        }
    }


    public static void jsonExportXray(String token){
        String jsonFilePath = "target/combined.json";
        String apiUrl = "https://xray.cloud.getxray.app/api/v2/import/execution/cucumber";

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(20))
                .build();

        HttpResponse<String> response = null;
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + token)
                    .POST(HttpRequest.BodyPublishers.ofFile(Path.of(jsonFilePath)))
                    .build();

            response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Response Body: " + response.body());

    }
}

