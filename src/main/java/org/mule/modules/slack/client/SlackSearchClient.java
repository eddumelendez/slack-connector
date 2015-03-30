package org.mule.modules.slack.client;

import org.mule.modules.slack.model.Search;

/**
 * 
 * @author Eddú Meléndez
 *
 */
public interface SlackSearchClient {

	String searchAll(Search search);
	
	String searchFiles(Search search);
	
	String searchMessages(Search search);
	
}
