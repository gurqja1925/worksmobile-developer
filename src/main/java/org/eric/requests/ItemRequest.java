package org.eric.requests;

import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpResponse;
import com.google.common.reflect.TypeToken;
import com.google.gson.JsonObject;
import org.eric.Json;
import org.eric.resources.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class ItemRequest<T> extends Request {
    public ItemRequest(Resource resource, Class<T> elementClass, String path, String method) {
        super(resource, elementClass, path, method);
    }

    public T execute() throws IOException {

        HttpResponse response = this.client.request(this);
        int statusCode = response.getStatusCode();
        if ((statusCode == 201) && response.getContent() == null) {
            return null;
        }

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(response.getContent(), StandardCharsets.UTF_8))) {

            Type type = TypeToken.of(this.elementClass).getType();
            return Json.getInstance().fromJson(reader, type);
        }
    }

    public ItemRequest<T> data(JsonObject data){
        return (ItemRequest<T>) super.data(data);
    }

    public ItemRequest<T> query(Map<String, Object> object) {
        return (ItemRequest<T>) super.query(object);
    }

    public ItemRequest<T> query(String key, Object value) {
        return (ItemRequest<T>) super.query(key, value);
    }

    public ItemRequest<T> data(HttpContent content) {
        return (ItemRequest<T>) super.data(content);
    }
}
