package org.eric.dispatcher;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

import java.io.IOException;

public abstract class Dispatcher {
    protected HttpTransport httpTransport;

    public Dispatcher() {
        this.httpTransport = new NetHttpTransport();
    }

    public Dispatcher(HttpTransport httpTransport) {
        this.httpTransport = httpTransport;
    }

    public HttpRequest buildRequest(String method, GenericUrl url, HttpContent content) throws IOException {
        return httpTransport.createRequestFactory().buildRequest(method, url, content);

    }

    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }
}
