package org.eric.resources.gen;

import com.google.gson.JsonElement;
import org.eric.Client;
import org.eric.models.bot.Bot;
import org.eric.requests.CollectionRequest;
import org.eric.requests.ItemRequest;
import org.eric.resources.Resource;

public class BotBase extends Resource {

    public BotBase(Client client) {
        super(client);
    }

    public CollectionRequest<Bot> findAll(){
        return new CollectionRequest<>(this, Bot.class, "/bots", "GET", "bots");
    }

    public ItemRequest<Bot> findById(String botId){
        String path = "/bots/{botId}".replace("{botId}", botId);
        return new ItemRequest<>(this, Bot.class, path, "GET");
    }

    public ItemRequest<Bot> create(){
        return new ItemRequest<>(this, Bot.class, "/bots", "POST");
    }

    public ItemRequest<Bot> update(String botId){
        return new ItemRequest<>(this, Bot.class, "/bots", "PUT");
    }

    public ItemRequest<JsonElement> delete(String botId){
        String path = "/bots/{botId}".replace("{botId}", botId);
        return new ItemRequest<JsonElement>(this, JsonElement.class, "/bots", "DELETE");
    }
}
