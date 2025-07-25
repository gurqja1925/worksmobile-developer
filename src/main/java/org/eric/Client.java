package org.eric;

import com.google.api.client.http.*;
import org.eric.dispatcher.AccessTokenDispatcher;
import org.eric.dispatcher.Dispatcher;
import org.eric.requests.Request;
import org.eric.resources.Bot;
import org.eric.resources.Directory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/*
* lineworks developer main class
* */
public class Client {

    public Dispatcher dispatcher;
    public Directory directory;
    public Bot bot;
    public static final Map<String, Object> DEFAULTS = new HashMap<String, Object>() {{
        put("base_url", "https://www.worksapis.com/v1.0");
    }};

    public Client(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
        this.directory = new Directory(this);
        this.bot = new Bot(this);
    }

    public static Client accessToken(String accessToken) {
        return new Client(new AccessTokenDispatcher(accessToken));
    }

    public HttpResponse request(Request request) throws IOException {
        GenericUrl url = new GenericUrl("https://www.worksapis.com/v1.0" + request.path);
        HttpContent content = null;
        if (request.content != null) {
            // Multipart, etc body
            content = request.content;
        } else if (request.method.equals("POST") || request.method.equals("PUT")) {
            // JSON body
            content = new ByteArrayContent("application/json",
                    request.data.toString().getBytes(StandardCharsets.UTF_8));
        }

        HttpRequest httpRequest = this.dispatcher.buildRequest(request.method, url, content);
        try {
            return httpRequest.execute();
        } catch (HttpResponseException e) {
            throw new RuntimeException(e);
        }
    }

}
