package org.mule.modules.connection.strategy;

import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.oauth.OAuth2;
import org.mule.api.annotations.oauth.OAuthAccessToken;
import org.mule.api.annotations.oauth.OAuthConsumerKey;
import org.mule.api.annotations.oauth.OAuthConsumerSecret;

@OAuth2(configElementName = "config-type",
		friendlyName = "OAuth2 Configuration",
		authorizationUrl = "https://slack.com/oauth/authorize",
		accessTokenUrl = "https://slack.com/api/oauth.access",
		accessTokenRegex = "\"access_token\":\"([^&]+?)\"",
		expirationRegex = "\"expires_in\":([^&]+?),",
		refreshTokenRegex = "\"refresh_token\":\"([^&]+?)\"")
public class SlackOauthStrategy {

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

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getConsumerKey() {
		return consumerKey;
	}

	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}

	public String getConsumerSecret() {
		return consumerSecret;
	}

	public void setConsumerSecret(String consumerSecret) {
		this.consumerSecret = consumerSecret;
	}

}
