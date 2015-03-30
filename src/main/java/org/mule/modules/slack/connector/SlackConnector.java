/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.slack.connector;

import java.io.IOException;

import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.oauth.OAuth2;
import org.mule.api.annotations.oauth.OAuthAccessToken;
import org.mule.api.annotations.oauth.OAuthConsumerKey;
import org.mule.api.annotations.oauth.OAuthConsumerSecret;
import org.mule.api.annotations.oauth.OAuthProtected;
import org.mule.api.annotations.param.Default;
import org.mule.modules.slack.client.SlackClient;
import org.mule.modules.slack.client.SlackClientImpl;

/**
 * OAuth2 Connection Strategy
 *
 * @author MuleSoft, Inc.
 */
@Connector(name = "slack", friendlyName = "Slack")
@OAuth2(configElementName = "config-type",
		friendlyName = "OAuth2 Configuration",
		authorizationUrl = "https://slack.com/oauth/authorize",
		accessTokenUrl = "https://slack.com/api/oauth.access",
		accessTokenRegex = "\"access_token\":\"([^&]+?)\"",
		expirationRegex = "\"expires_in\":([^&]+?),",
		refreshTokenRegex = "\"refresh_token\":\"([^&]+?)\"")
public class SlackConnector {
	
	/**
	 * Configurable
	 */
	@Configurable
	@Default("value")
	private String myStrategyProperty;

	/**
	 * The OAuth access token
	 */
	@OAuthAccessToken
	private String accessToken;

	/**
	 * The OAuth consumer key
	 */
	@Configurable
	@OAuthConsumerKey
	private String consumerKey;

	/**
	 * The OAuth consumer secret
	 */
	@Configurable
	@OAuthConsumerSecret
	private String consumerSecret;

	/**
	 * Set strategy property
	 *
	 * @param myStrategyProperty
	 *            my strategy property
	 */
	public void setMyStrategyProperty(String myStrategyProperty) {
		this.myStrategyProperty = myStrategyProperty;
	}

	/**
	 * Get property
	 */
	public String getMyStrategyProperty() {
		return this.myStrategyProperty;
	}

	/**
	 * Set accessToken
	 *
	 * @param accessToken
	 *            The accessToken
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * Get accessToken
	 */
	public String getAccessToken() {
		return this.accessToken;
	}

	/**
	 * Set consumerKey
	 *
	 * @param consumerKey
	 *            The consumerKey
	 */
	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}

	/**
	 * Get consumerKey
	 */
	public String getConsumerKey() {
		return this.consumerKey;
	}

	/**
	 * Set consumerSecret
	 *
	 * @param consumerSecret
	 *            The consumerSecret
	 */
	public void setConsumerSecret(String consumerSecret) {
		this.consumerSecret = consumerSecret;
	}

	/**
	 * Get consumerSecret
	 */
	public String getConsumerSecret() {
		return this.consumerSecret;
	}
	
	private SlackClient slackClient;

	public SlackConnector() {
		this.slackClient = new SlackClientImpl("");
	}

	@Processor
	@OAuthProtected
	public void getUserList() throws IOException {
		this.slackClient.getUserList(this.accessToken);
	}

}