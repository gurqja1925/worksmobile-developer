package org.eric.resources;

import com.google.gson.JsonElement;
import org.eric.Client;
import org.eric.requests.ItemRequest;
import org.eric.resources.gen.BotBase;

public class Bot extends BotBase {
    public Bot(Client client) {
        super(client);
    }

    public ItemRequest<JsonElement> reissueSecret (String botId){
        String path = "/bots/{botId}/secret".replace("{botId}", botId);
        return new ItemRequest<>(this, JsonElement.class, path, "POST");
    }

    public ItemRequest<JsonElement> sendUserMessage(String botId, String userId){
        String path = "/bots/{botId}/users/{userId}/messages"
                .replace("{botId}", botId)
                .replace("{userId}", userId)
                ;
        return new ItemRequest<>(this, JsonElement.class, path, "POST");
    }

    public ItemRequest<JsonElement> sendChannelMessage(String botId, String channelId){
        String path = "/bots/{botId}/channels/{channelId}/messages"
                .replace("{botId}", botId)
                .replace("{channelId}", channelId)
                ;
        return new ItemRequest<>(this, JsonElement.class, path, "POST");
    }
}
