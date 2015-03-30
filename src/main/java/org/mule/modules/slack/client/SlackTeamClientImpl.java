package org.mule.modules.slack.client;

import java.net.URI;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

/**
 * 
 * @author Eddú Meléndez
 *
 */
public class SlackTeamClientImpl extends BaseClient implements SlackTeamClient {

	private final static Logger logger = Logger
			.getLogger(SlackTeamClientImpl.class);

	@Override
	public String teamAccessLogs(String accessToken, String count, String page) {
		logger.info("Calling team.accessLogs - AccessToken: " + accessToken);
		URI uri = getPath().path("/team.accessLogs")
				.queryParam("token", accessToken).build();
		Response response = getJerseyClient().target(uri).request().get();
		String object = response.readEntity(String.class);
		logger.info(object);
		return object;
	}

	@Override
	public String teamInfo(String accessToken) {
		logger.info("Calling team.info - AccessToken: " + accessToken);
		URI uri = getPath().path("/team.info").queryParam("token", accessToken)
				.build();
		Response response = getJerseyClient().target(uri).request().get();
		String object = response.readEntity(String.class);
		logger.info(object);
		return object;
	}

}
