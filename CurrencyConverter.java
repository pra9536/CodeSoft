import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CurrencyConverter {
    public static void main(String[] args) throws JSONException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type currency to convert from: ");
        String convertFrom = sc.nextLine();
        System.out.println("Type currency to convert to: ");
        String convertTo = sc.nextLine();
        System.out.println("Type quantity to convert: ");
        BigDecimal quantity = sc.nextBigDecimal();

        String urlString = "https://api.exchangerate.host/convert?access_key=78e565af3a840cfb45bf738da04746bd&from="
                + convertFrom.toUpperCase() + "&to=" + convertTo.toUpperCase() + "&amount=" + quantity;

        OkHttpClient client = new OkHttpClient();

        try {
            Request request = new Request.Builder()
                    .url(urlString)
                    .get()
                    .build();

            Response response = client.newCall(request).execute();

            String stringResponse = response.body().string();

            JSONObject jsonObject = new JSONObject(stringResponse);

            if (jsonObject.getBoolean("success")) {
                BigDecimal result = BigDecimal.valueOf(jsonObject.getDouble("result"));
                System.out.println("Converted Amount: " + result + " " + convertTo.toUpperCase());
            } else {
                System.out.println("Error: " + jsonObject.getJSONObject("error").getString("info"));
            }

            response.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
