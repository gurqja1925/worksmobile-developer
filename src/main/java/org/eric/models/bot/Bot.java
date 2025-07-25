package org.eric.models.bot;

import java.util.Collection;

public class Bot {
    Integer botId;
    String botName;
    String photoUrl;
    String description;
    Collection<String> administrators;
    Collection<String> subadministrators;
    Collection<Integer> allowDomains;
    boolean enableCallback;
    Collection<String> callbackEvents;
    String callbackUrl;
    boolean enableGroupJoin;
    String defaultRichmenuId;
    I18nBotNames i18nBotNames;
    I18nDescriptions i18nDescriptions;
    I18nPhotoUrls i18nPhotoUrls;
    String createdTime;
    String modifiedTime;
}
