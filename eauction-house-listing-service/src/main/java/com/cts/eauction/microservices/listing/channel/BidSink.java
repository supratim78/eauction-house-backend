package com.cts.eauction.microservices.listing.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.SubscribableChannel;

@SuppressWarnings("deprecation")
public interface BidSink extends Sink {

	/**
	 * Input channel name.
	 */
	String BIDINPUT = "bidinput";

	/**
	 * @return input channel.
	 */
	@Input(BidSink.BIDINPUT)
	SubscribableChannel bidinput();
}
