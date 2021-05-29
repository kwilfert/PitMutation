package de.wilfert.testproject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A Wrapper for the HTTPRequest class in Java, adapted to suite the needs of
 * a simple RestAPI (as appearing in github.com/michael-kessler/rest2020api)
 * -always adds headers for Content-Type json
 * -always adds header for caching
 */
public class RequestMaker {
    public static HttpResponse<String> makeRequest(String url, RequestMethod method, String body,
                                                   HashMap<String, String> headers) throws URISyntaxException, IOException, InterruptedException {

        final URI uri = new URI(url);
        final HttpRequest.Builder requestBuilder = HttpRequest.newBuilder(uri);

        if (headers != null) {
            for (String key : headers.keySet()) {
                String value = headers.get(key).toString();
                requestBuilder.setHeader(key, value);
            }
        }

        // All usual headers setup beforehand
        requestBuilder.setHeader("Content-Type", "application/json");
        requestBuilder.setHeader("Cache-Control", "private, max-age=84600, must-revalidate");

        switch (method) {
            case GET:
                requestBuilder.GET();
                break;
            case POST:
                // body has to be of JSON Format fo this to work
                assert body != "";
                requestBuilder.POST(HttpRequest.BodyPublishers.ofString(body));
                break;
            case PUT:
                // body has to be of JSON Format fo this to work
                assert body != "";
                requestBuilder.PUT(HttpRequest.BodyPublishers.ofString(body));
                break;
            default:
                requestBuilder.GET();
                break;
        }

        //the wrapped Java Request and Response
        final HttpRequest request = requestBuilder.build();
        final HttpResponse.BodyHandler<String> asString = HttpResponse.BodyHandlers.ofString();

        final HttpClient httpClient = HttpClient.newHttpClient();
        final HttpResponse<String> response = httpClient.send(request, asString);

        printResponseInfo(response);

        return response;
    }

    /**
     * Convenience Method for simple GET requests without header or custom body
     */
    public static HttpResponse<String> makeRequest(String url)
            throws URISyntaxException, IOException, InterruptedException {
        return makeRequest(url, RequestMethod.GET, "", new HashMap<String, String>());
    }

    /**
     * A MakeRequest Response containing -StatusCode -The String Body -HTTP Headers
     */
    public class Response {
        public Response(final HttpResponse<String> response) {
            this.statusCode = "" + response.statusCode();
            this.body = response.body();
            this.headers = response.headers().map();
        }

        final String statusCode;
        final String body;
        final Map<String, List<String>> headers;
    }

    /**
     * The usual Request Methods, for usage in MakeRequest
     */
    public static enum RequestMethod {
        GET, POST, PUT, PATCH;
    }

    /**
     * Method used for debugging
     *
     * @param response HTTP String response
     */
    private static void printResponseInfo(final HttpResponse<String> response) {

        final int responseCode = response.statusCode();
        final String responseBody = response.body();
        final HttpHeaders headers = response.headers();

        System.out.println("Status: " + responseCode);
        System.out.println("Body: " + responseBody);
        System.out.println("Headers: " + headers.map());
    }
}
