package udemy.springboot;

import org.springframework.beans.factory.annotation.Value;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public final class Constants {
    public static final String JDBC = getJDBC();

    @Value("")
    public static String kkk;

    private static String getJDBC() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        try (InputStream inputStream = classLoader.getResourceAsStream("application.properties")) {

            assert inputStream != null;
            InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader);

            for (String line; (line = reader.readLine()) != null; ) {
                if (line.split("=")[0].equals("jdbc.url")) {
                    return line.split("=")[1];
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
