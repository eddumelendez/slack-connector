package org.mule.modules.slack.client;

import java.net.URI;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

public class SlackAuthClientImpl extends BaseClient implements SlackAuthClient {

	private final static Logger logger = Logger
			.getLogger(SlackAuthClientImpl.class);
	
	@Override
	public String authTest(String accessToken) {
		logger.info("Calling usersGetList - AccessToken: " + accessToken);
		URI uri = getPath().path("/auth.test")
				.queryParam("token", accessToken).build();
		Response response = getJerseyClient().target(uri).request().get();
		String object = response.readEntity(String.class);
		logger.info(object);
		return object;
	}

}
