package org.eric.requests;

import com.google.api.client.http.HttpResponse;
import com.google.common.reflect.TypeToken;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.eric.Json;
import org.eric.models.ResponseMetaData;
import org.eric.models.ResultCollection;
import org.eric.resources.Resource;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class CollectionRequest<T> extends Request {
    String key;
    public CollectionRequest(Resource resource, Class elementClass, String path, String method, String key) {
        super(resource, elementClass, path, method);
        this.key = key;
    }

    public ResultCollection<T> execute() throws IOException {
        return this.executeRaw();
    }

    public ResultCollection<T> executeRaw() throws IOException {
        HttpResponse response = this.client.request(this);
        JsonObject root = JsonParser.parseString(response.parseAsString()).getAsJsonObject();

        ResponseMetaData meta = null;
        if (root.has("responseMetaData")) {
            meta = Json.getInstance().fromJson(
                    root.get("responseMetaData"), ResponseMetaData.class
            );
        }

        JsonElement element = root.get(key);
        if (element == null || !element.isJsonArray()) {
            throw new IllegalStateException("Expected JSON array under key: " + key);
        }

        Type listType = new TypeToken<List<T>>(){}.getType();
        List<T> dataList = Json.getInstance().fromJson(element, listType);

        ResultCollection<T> result = new ResultCollection<>();
        result.data = dataList;
        result.responseMetaData = meta;

        return result;
    }
}
