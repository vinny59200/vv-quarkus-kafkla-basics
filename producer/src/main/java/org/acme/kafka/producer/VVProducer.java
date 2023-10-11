package org.acme.kafka.producer;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@Path( "/api/v1" )
public class VVProducer {

    @Channel( "vv-channel" )
    Emitter<String> quoteRequestEmitter;

    /**
     * Endpoint to generate a new msg request id and send it to "vv-channel" Kafka topic using the emitter.
     */
    @GET
    @Path( "/messages/{msg}" )
    @Produces( MediaType.TEXT_PLAIN )
    public String createRequest(String msg) {
//        String msg = "wesh";
        quoteRequestEmitter.send( msg );
        return msg;
    }

}
