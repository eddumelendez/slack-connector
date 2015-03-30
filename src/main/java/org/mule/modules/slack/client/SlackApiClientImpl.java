package org.mule.modules.slack.client;

import java.io.IOException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.apache.log4j.Logger;

/**
 * 
 * @author Eddú Meléndez
 *
 */
public class SlackApiClientImpl extends BaseClient implements SlackApiClient {

	private final static Logger logger = Logger
			.getLogger(SlackApiClientImpl.class);

	@Override
	public String apiTest(String error, String foo) throws IOException {
		logger.info("Calling apiTest");
		UriBuilder uriBuilder = getPath().path("/api.test");

		if (error != null) {
			uriBuilder.queryParam("error", error);
		}
		if (foo != null) {
			uriBuilder.queryParam("foo", foo);
		}
		Response response = getJerseyClient().target(uriBuilder.build())
				.request().get();
		String object = response.readEntity(String.class);
		logger.info(object);
		return object;
	}
}
