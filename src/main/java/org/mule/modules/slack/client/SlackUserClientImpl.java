package org.mule.modules.slack.client;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

/**
 * 
 * @author Eddú Meléndez
 *
 */
public class SlackUserClientImpl extends BaseClient implements SlackUserClient {

	private final static Logger logger = Logger
			.getLogger(SlackUserClientImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mule.modules.slack.SlackClient#getUserList(java.lang.String)
	 */
	@Override
	public String usersList(String accessToken) throws IOException {
		logger.info("Calling usersGetList - AccessToken: " + accessToken);
		URI uri = getPath().path("/users.list")
				.queryParam("token", accessToken).build();
		Response response = getJerseyClient().target(uri).request().get();
		String object = response.readEntity(String.class);
		logger.info(object);
		return object;
	}

	@Override
	public String usersInfo(String accessToken, String user) {
		logger.info("Calling userGetInfo - AccessToken: " + accessToken);
		URI uri = getPath().path("/users.info")
				.queryParam("token", accessToken).queryParam("user", user)
				.build();
		Response response = getJerseyClient().target(uri).request().get();
		String object = response.readEntity(String.class);
		logger.info(object);
		return object;
	}

}
