package org.mule.modules.slack.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.UriBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author Eddú Meléndez
 *
 */
public class BaseClient {

	public static final String SLACK_API = "https://slack.com/api";

	private Client jerseyClient;

	private ObjectMapper jacksonMapper;

	public BaseClient() {
		this.jerseyClient = ClientBuilder.newClient();
		this.jacksonMapper = new ObjectMapper();
	}

	protected Client getJerseyClient() {
		return this.jerseyClient;
	}
	
	protected UriBuilder getPath() {
		return UriBuilder.fromPath(SLACK_API);
	}

}
