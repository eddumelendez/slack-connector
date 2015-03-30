package org.mule.modules.slack.client;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author Eddú Meléndez
 *
 */
public class SlackClientImpl implements SlackClient {

	private final static Logger logger = Logger
			.getLogger(SlackClientImpl.class);

	private String apiUrl;

	private Client jerseyClient;
	private ObjectMapper jacksonMapper;

	public SlackClientImpl(String apiUrl) {
		this.apiUrl = StringUtils.isEmpty(apiUrl) ? "https://slack.com/api"
				: apiUrl;
		jerseyClient = ClientBuilder.newClient();
		jacksonMapper = new ObjectMapper();
	}

	/* (non-Javadoc)
	 * @see org.mule.modules.slack.SlackClient#getUserList(java.lang.String)
	 */
	@Override
	public String getUserList(String accessToken) throws IOException {
		logger.info("Calling usersGetList - AccessToken: " + accessToken);
		URI uri = UriBuilder.fromPath(apiUrl).path("/users.list").queryParam("token", accessToken).build();
		Response response = jerseyClient.target(uri).request().get();
		String object = response.readEntity(String.class);
		logger.info(object);
		return object;
	}

}
