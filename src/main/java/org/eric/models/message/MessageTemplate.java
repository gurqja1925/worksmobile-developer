package org.eric.models.message;

import com.google.gson.JsonObject;

public abstract class MessageTemplate {

    protected JsonObject root;

    public MessageTemplate() {
        this.root = new JsonObject();
    }

    public abstract JsonObject getJson();

}
