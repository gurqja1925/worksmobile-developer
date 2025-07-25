package org.eric.resources.gen;

import org.eric.Client;
import org.eric.models.contact.Contact;
import org.eric.requests.ItemRequest;
import org.eric.resources.Resource;

public class DirectoryBase extends Resource {

    public DirectoryBase(Client client) {
        super(client);
    }

    public ItemRequest<Contact> getContact(String contactId){
        String path = "/contacts/{contactId}".replace("{contactId}", contactId);
        return new ItemRequest<Contact>(this, Contact.class, path, "GET");
    }
}
