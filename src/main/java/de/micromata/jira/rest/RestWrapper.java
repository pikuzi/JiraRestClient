package de.micromata.jira.rest;



import java.net.URI;
import java.util.List;
import java.util.Map;

import de.micromata.jira.rest.domain.BasicProjectBean;
import de.micromata.jira.rest.domain.CommentSummaryBean;
import de.micromata.jira.rest.domain.ComponentBean;
import de.micromata.jira.rest.domain.IssueBean;
import de.micromata.jira.rest.domain.IssueTypeBean;
import de.micromata.jira.rest.domain.JqlSearchResultBean;
import de.micromata.jira.rest.domain.ProjectBean;
import de.micromata.jira.rest.domain.StatusBean;
import de.micromata.jira.rest.domain.TransitionBean;
import de.micromata.jira.rest.domain.UserBean;
import de.micromata.jira.rest.domain.VersionBean;
import de.micromata.jira.rest.jql.JqlSearchBean;
import de.micromata.jira.rest.util.RestException;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 28.02.13
 * Time: 11:18
 * To change this template use File | Settings | File Templates.
 */
public interface RestWrapper {

	/**
	 * Returns true if the transition update on an Issue success.
	 * 
	 * @param jiraRestClient = the connected client
	 * @param issueKey = the issue key
	 * @param transitionId = the transition id
	 * @return success state
	 * @throws RestException
	 */
	public boolean updateIssueTransitionByKey(JiraRestClient jiraRestClient, String issueKey, int transitionId) throws RestException;
	
	/**
	 * Returns available transitions for an Issue in a map with transition id and properties.
	 * 
	 * @param jiraRestClient = the connected client
	 * @param issueKey = the issue key
	 * @return map of transition id and properties
	 * @throws RestException
	 */
	public Map<Integer, TransitionBean> getIssueTransitionsByKey(JiraRestClient jiraRestClient, String issueKey) throws RestException;
	
	/**
	 * Returns the logged in remote user.
	 * 
	 * @param jiraRestClient = the connected client
	 * @return logged in user
	 * @throws RestException
	 */
    public UserBean getLoggedInRemoteUser(JiraRestClient jiraRestClient) throws RestException;

    /**
	 * Returns a list of all projects.
	 * 
	 * @param jiraRestClient = the connected client 
	 * @return list of projects
	 * @throws RestException 
	 */
    public List<BasicProjectBean> getAllProjects(JiraRestClient jiraRestClient) throws RestException;

    /**
     * Returns a full representation of the project for the given key.
     * 
     * @param jiraRestClient = the connected client
     * @param projectKey = the project key
     * @return all informations for the project
     * @throws RestException
     */
    public ProjectBean getProjectByKey(JiraRestClient jiraRestClient, String projectKey) throws RestException;

    /**
     * Returns a list of all issues for the given project.
     * 
     * @param jiraRestClient = the connected client
     * @param projectKey = the project key
     * @return JQL search results
     * @throws RestException
     */
    public JqlSearchResultBean getIssuesForProject(JiraRestClient jiraRestClient, String projectKey) throws RestException;

    /**
     * Performs an extended search for issues given by the project.
     * 
     * @param jiraRestClient = the connected client
     * @param jqlBean = JQL requirements for an extended search  
     * @return list of issues
     * @throws RestException
     */
    public JqlSearchResultBean searchIssuesForProject(JiraRestClient jiraRestClient, JqlSearchBean jsb) throws RestException;

    /**
     * Returns a full representation of the issue for the given issue key.
     * 
     * @param jiraRestClient = the connected client
     * @param issueKey = issue key
     * @return all informations for the issue
     * @throws RestException
     */
    public IssueBean getIssueByKey(JiraRestClient jiraRestClient, String issueKey) throws RestException;

    /**
     * Test the REST connection with login data.
     * 
     * @param uri = the URI for the server where JIRA is running
     * @param username = login name 
     * @param password = login password
     * @return true if the connection success
     * @throws RestException 
     */
    public boolean testRestConnection(URI uri, String username, String password) throws RestException;

    /**
     * Returns a summarized representation of all comments for the given issue.
     * 
     * @param jiraRestClient = the connected client
     * @param issueKey = issue key
     * @return summarized representation of all comments
     * @throws RestException
     */
	public CommentSummaryBean getCommentsByIssue(JiraRestClient jiraRestClient,
			String issueKey) throws RestException;

	/**
	 * Returns a list of all versions for a project.
	 * @param jiraRestClient = the connected client
	 * @param projectKey = the project key
	 * @return list of versions
	 * @throws RestException
	 */
	public List<VersionBean> getProjectVersions(JiraRestClient jiraRestClient,
			String projectKey) throws RestException;

	/**
	 * Returns a list of all components for a project.
	 * 
	 * @param jiraRestClient = the connected client
	 * @param projectKey = the project key
	 * @return list of components
	 * @throws RestException
	 */
	public List<ComponentBean> getProjectComponents(JiraRestClient jiraRestClient,
			String projectKey) throws RestException;

	/**
	 * Returns a list of all issue types visible to the connected client.
	 * 
	 * @param jiraRestClient = the connected client
	 * @return list of issue types 
	 * @throws RestException
	 */
    public List<IssueTypeBean> getIssueTypes(JiraRestClient jiraRestClient) throws RestException;

    /**
     * Returns a list of all statuses.
     * 
     * @param jiraRestClient = the connected client 
     * @return list of statuses
     * @throws RestException
     */
    public List<StatusBean> getStates(JiraRestClient jiraRestClient) throws RestException;

}
