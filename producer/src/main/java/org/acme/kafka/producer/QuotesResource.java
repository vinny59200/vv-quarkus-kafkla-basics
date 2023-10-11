package org.acme.kafka.producer;

import java.util.UUID;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.acme.kafka.model.Quote;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import io.smallrye.mutiny.Multi;

@Path( "/api/v1" )
public class QuotesResource {

    @Channel( "vv-channel" )
    Emitter<String> quoteRequestEmitter;

    /**
     * Endpoint to generate a new msg request id and send it to "vv-channel" Kafka topic using the emitter.
     */
    @GET
    @Path( "/message/{msg}" )
    @Produces( MediaType.TEXT_PLAIN )
    public String createRequest(String msg) {
//        String msg = "wesh";
        quoteRequestEmitter.send( msg );
        return msg;
    }

//    @Channel( "quotes" )
//    Multi<Quote> quotes;
//
//    /**
//     * Endpoint retrieving the "quotes" Kafka topic and sending the items to a server sent event.
//     */
//    @GET
//    @Produces( MediaType.SERVER_SENT_EVENTS ) // denotes that server side events (SSE) will be produced
//    public Multi<Quote> stream() {
//        return quotes.log();
//    }
}
