package pro.kensait.java.advanced.lsn_8_1_1;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class Main_ContextClassLoader {
    public static void main(String[] args) {
        Properties props = new Properties();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStream is = classloader
                .getResourceAsStream("config/MyResource.properties")) {
            props.load(new InputStreamReader(is, StandardCharsets.UTF_8));
            String name = props.getProperty("name");
            int age = Integer.parseInt(props.getProperty("age"));
            String address = props.getProperty("address");
            System.out.println(name + ", " + age + ", " + address);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}