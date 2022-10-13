package akademia.zad3;


import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Wybierz");
        System.out.println("1. Podaj mądrość Kayne");
        System.out.println("2. Wyjście");

        Scanner scanner = new Scanner(System.in);
        String choose;
        do {
            choose = scanner.nextLine();
            if (choose.equals("1")) {
                giveQuote();
            }
        } while (!choose.equals("2"));

    }
    public static void giveQuote() {
        try {
            URL url = new URL("https://api.kanye.rest/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            String text = "";
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder response = new StringBuilder();
            while ((text = bufferedReader.readLine()) != null) {
                response.append(text);
            }
            bufferedReader.close();

            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray = (JSONArray) jsonParser.parse(String.valueOf(response));

            } catch (IOException | ParseException e) {
            System.out.println(e);
        }
    }
}