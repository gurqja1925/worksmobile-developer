package org.eric.resources;

import org.eric.Client;

public abstract class Resource {
    public Client client;
    public Resource(Client client) {
        this.client = client;
    }
}
