package org.eric.models.message;

import com.google.gson.JsonObject;

public class Text extends MessageTemplate{

    String content;

    public Text(String content) {
        this.content = content;

        JsonObject c = new JsonObject();
        c.addProperty("type", "text");
        c.addProperty("text", this.content);
        this.root.add("content", c);
    }

    @Override
    public JsonObject getJson() {
        return this.root;
    }
}
