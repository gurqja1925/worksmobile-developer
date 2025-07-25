package org.eric.requests;

import com.google.api.client.http.HttpContent;
import com.google.gson.JsonObject;
import org.eric.Client;
import org.eric.resources.Resource;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public abstract class Request {
    private static Logger logger = null;

    public String method;
    public String path;
    public JsonObject data;
    public Map<String, Object> query;
    public HttpContent content;

    protected Client client;
    protected Class elementClass; // required due to type erasure?

    /**
     * @param resource     Parent resource instance
     * @param elementClass The model class that this request returns
     * @param path         HTTP API endpoint path
     * @param method       HTTP API endpoint method
     */
    public Request(Resource resource, Class elementClass, String path, String method) {
        this.client = resource.client;
        this.elementClass = elementClass;
        this.path = path;
        this.method = method;
        this.content = null;
        this.data = null;
        this.query = new HashMap<>();
    }

    public Request query(Map<String, Object> query) {
        this.query = query;
        return this;
    }

    public Request query(String key, Object value) {
        this.query.put(key, value);
        return this;
    }

    public Request data(HttpContent content) {
        this.content = content;
        return this;
    }

    public Request data(JsonObject data) {
        this.data = data;
        return this;
    }

}
