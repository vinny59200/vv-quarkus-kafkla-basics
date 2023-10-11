package org.acme.kafka.processor;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.smallrye.reactive.messaging.annotations.Blocking;

/**
 * A bean consuming data from the "vv-channel" Kafka topic (mapped to "requests" channel) and giving out a random msg.
 * The result is pushed to the "quotes" Kafka topic.
 */
@ApplicationScoped
public class VVConsumer {

    @Incoming("requests")
    @Outgoing("quotes")
    @Blocking
    public String process(String msg) throws InterruptedException {
        // simulate some hard working task
        Thread.sleep(200);
        System.out.println(msg);
        return msg;
    }
}
