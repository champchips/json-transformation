package task.java_method.json_transformation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.time.LocalDate;

public class BookJsonTransformer {

    /**
     * Transforms the input JSON string representing a book.
     * 1. Converts the "title" to uppercase.
     * 2. Adds a new key-value pair: "isNewRelease" indicating if the book was published in the last 10 years.
     *
     * @param jsonString the input JSON string
     * @return the transformed JSON string
     */
    public static String transformBookJson(String jsonString) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement jsonElement = JsonParser.parseString(jsonString);
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        // Convert the title to uppercase
        String title = jsonObject.get("title").getAsString().toUpperCase();
        jsonObject.addProperty("title", title);

        // Determine if the book is a new release
        int currentYear = LocalDate.now().getYear();
        int yearPublished = jsonObject.get("yearPublished").getAsInt();
        boolean isNewRelease = (currentYear - yearPublished) <= 10;

        // Add the "isNewRelease" field
        jsonObject.addProperty("isNewRelease", isNewRelease);

        // Transform JsonObject to Json String Format as a Return Value
        return gson.toJson(jsonObject);
    }

    public static void main(String[] args) {
        /*Case yearPublished older more than 10 years*/
        String jsonInputSample1 =
                "{\"bookId\": 123, \"title\": \"The Great Gatsby\", \"author\": \"F. Scott Fitzgerald\", \"yearPublished\": 1925}";
        /*Case yearPublished older less than or equals 10 years*/
        String jsonInputSample2 =
                "{\"bookId\": 456, \"title\": \"all character should be uppercase\", \"author\": \"Thanawat P.\", \"yearPublished\": 2014}";
        System.out.println(BookJsonTransformer.transformBookJson(jsonInputSample1));
        System.out.println(BookJsonTransformer.transformBookJson(jsonInputSample2));
    }
}

