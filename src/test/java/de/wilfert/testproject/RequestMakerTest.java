package de.wilfert.testproject;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class RequestMakerTest {

    @Test
    void makeRequestLong() {
        // set headers
        HashMap<String, String> headers = new HashMap<>();
        try {
            HttpResponse<String> resp = RequestMaker.makeRequest("https://v2.jokeapi.dev/joke/Programming?format=json", RequestMaker.RequestMethod.GET, "", headers);
            if (resp.statusCode() == 200)
                System.out.printf("Long Response: %s", resp.body());
        } catch (URISyntaxException | IOException | InterruptedException e) {
            fail();
        }
    }

    @Test
    void testMakeRequestShort() {
        try {
            HttpResponse<String> resp = RequestMaker.makeRequest("https://v2.jokeapi.dev/joke/Programming?format=json");
            if (resp.statusCode() == 200)
                System.out.printf("Long Response: %s", resp.body());
        } catch (URISyntaxException | IOException | InterruptedException e) {
            fail();
        }
    }
}