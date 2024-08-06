package task.java_method.json_transformation;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookJsonTransformerTest {

    @Test
    public void testTransformBookJson_TitleToUpperCase() {
        String jsonInput = "{\"bookId\": 123, \"title\": \"The Great Gatsby\", \"author\": \"F. Scott Fitzgerald\", \"yearPublished\": 1925}";
        String expectedOutput = "{\"bookId\":123,\"title\":\"THE GREAT GATSBY\",\"author\":\"F. Scott Fitzgerald\",\"yearPublished\":1925,\"isNewRelease\":false}";

        String transformedJson = BookJsonTransformer.transformBookJson(jsonInput);

        JsonObject expectedJsonObject = JsonParser.parseString(expectedOutput).getAsJsonObject();
        JsonObject actualJsonObject = JsonParser.parseString(transformedJson).getAsJsonObject();

        assertEquals(expectedJsonObject, actualJsonObject, "The title should be converted to uppercase and isNewRelease should be correctly added.");
    }

    @Test
    public void testTransformBookJson_IsNewReleaseTrue() {
        String jsonInput = "{\"bookId\": 456, \"title\": \"all character should be uppercase\", \"author\": \"Thanawat P.\", \"yearPublished\": 2014}";
        String expectedOutput = "{\"bookId\":456,\"title\":\"ALL CHARACTER SHOULD BE UPPERCASE\",\"author\":\"Thanawat P.\",\"yearPublished\":2014,\"isNewRelease\":true}";

        String transformedJson = BookJsonTransformer.transformBookJson(jsonInput);

        JsonObject expectedJsonObject = JsonParser.parseString(expectedOutput).getAsJsonObject();
        JsonObject actualJsonObject = JsonParser.parseString(transformedJson).getAsJsonObject();

        assertEquals(expectedJsonObject, actualJsonObject, "The title should be converted to uppercase and isNewRelease should be true.");
    }

    @Test
    public void testTransformBookJson_IsNewReleaseFalse() {
        String jsonInput = "{\"bookId\": 789, \"title\": \"Some Old Book\", \"author\": \"Old Author\", \"yearPublished\": 2000}";
        String expectedOutput = "{\"bookId\":789,\"title\":\"SOME OLD BOOK\",\"author\":\"Old Author\",\"yearPublished\":2000,\"isNewRelease\":false}";

        String transformedJson = BookJsonTransformer.transformBookJson(jsonInput);

        JsonObject expectedJsonObject = JsonParser.parseString(expectedOutput).getAsJsonObject();
        JsonObject actualJsonObject = JsonParser.parseString(transformedJson).getAsJsonObject();

        assertEquals(expectedJsonObject, actualJsonObject, "The title should be converted to uppercase and isNewRelease should be false.");
    }
}