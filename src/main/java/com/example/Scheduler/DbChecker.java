package com.example.Scheduler;

import org.apache.catalina.WebResource;
import org.glassfish.jersey.client.ClientProperties;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * Created by dilanka on 1/1/17.
 */

@Service
public class DbChecker {

    @Value("${couchdb.url}")
    private String couchdbUrl;

    private int lastSequenceNumber  = 0;

    public JSONObject getDbUpdates(){

        Client client = ClientBuilder.newClient();
        WebTarget myResource = client.target(couchdbUrl+"_changes").queryParam("since", lastSequenceNumber);
        String response = myResource.request(MediaType.TEXT_PLAIN).get(String.class);
        JSONObject responseObject = new JSONObject(response);

        lastSequenceNumber = responseObject.getInt("last_seq");
        return responseObject;
    }

}
