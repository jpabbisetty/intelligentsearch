package com.dharbor.workflow.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.dharbor.workflow.model.ActivityActionRequest;
import com.dharbor.workflow.model.CasePatchDetails;
import com.dharbor.workflow.model.EntityCountResponse;
import com.dharbor.workflow.model.InstancesByQueueResponse;
import com.dharbor.workflow.model.InstancesByQueueResponseChild;
import com.dharbor.workflow.model.RolesOfNextActivityResponse;
import com.dharbor.workflow.model.UserResponse;
import com.dharbor.workflow.model.WorkflowHistoryInstanceResponse;
import com.dharbor.workflow.model.WorkflowInitiateRequest;
import com.dharbor.workflow.model.WorkflowInstanceRequest;
import com.dharbor.workflow.model.WorkflowInstanceResponse;
import com.dharbor.workflow.model.WorkflowMilestoneResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/definitions")
public class SETWorkflowController {
	
	private final Logger logger = LoggerFactory.getLogger(SETWorkflowController.class);
	
	    @Autowired
	    private RestTemplate restTemplate;
	    
	    @Value("${set.fusion.url}")
		private String url;
	    
	    @Value("${des.url}")
	    private String desUrl;
	    
	    @Value("${setfusion.client.appid}")
		private String appTokenId;

	
	    @ResponseStatus(HttpStatus.OK)
	    @PutMapping(value = "/{definitionId}/runtime/suspend", produces = MediaType.APPLICATION_JSON_VALUE)
	    @ApiResponses(value = { @ApiResponse(code = 409, message = "CONFLICT") })
	    public WorkflowInstanceResponse suspendWorkflow(
	            @PathVariable("definitionId") String workflowDefId,
	            @RequestBody WorkflowInstanceRequest workflowInstanceRequest,
	            @RequestHeader(value="X-TENANT-ID") String subscriptionId,
				@RequestHeader(value="Authorization") String authtoken) {
	    	
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
	    	headers.set("X-TENANT-ID", subscriptionId);
			headers.set("Authorization", authtoken);
	    	
	    	HttpEntity entity = new HttpEntity<WorkflowInstanceRequest>(workflowInstanceRequest, headers);
	    	
	    	String urlString = url+"/workflow-service/definitions/"+workflowDefId+"/runtime/suspend";
	    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(urlString);
	    	
	        return restTemplate.exchange(builder.toUriString(), HttpMethod.PUT, entity, WorkflowInstanceResponse.class).getBody();
	    }

	    @ResponseStatus(HttpStatus.OK)
	    @PutMapping(value = "/{definitionId}/runtime/resume", produces = MediaType.APPLICATION_JSON_VALUE)
	    @ApiResponses(value = { @ApiResponse(code = 409, message = "CONFLICT") })
	    public WorkflowInstanceResponse resumeWorkflow(
	            @PathVariable("definitionId") String workflowDefId,
	            @RequestBody WorkflowInstanceRequest workflowInstanceRequest,
	            @RequestHeader(value="X-TENANT-ID") String subscriptionId,
				@RequestHeader(value="Authorization") String authtoken) {
	    	
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
	    	headers.set("X-TENANT-ID", subscriptionId);
			headers.set("Authorization", authtoken);
	    	
	    	HttpEntity entity = new HttpEntity<WorkflowInstanceRequest>(workflowInstanceRequest, headers);
	    	
	    	String urlString = url+"/workflow-service/definitions/"+workflowDefId+"/runtime/resume";
	    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(urlString);
	    	
	        return restTemplate.exchange(builder.toUriString(), HttpMethod.PUT, entity, WorkflowInstanceResponse.class).getBody();
	    }
	    
	    @PutMapping(value = "/{definitionId}/runtime/terminate", produces = MediaType.APPLICATION_JSON_VALUE)
	    public WorkflowInstanceResponse terminateWorkflow(
	            @PathVariable("definitionId") String workflowDefId,
	            @RequestBody WorkflowInstanceRequest workflowInstanceRequest,
	            @RequestHeader(value="X-TENANT-ID") String subscriptionId,
	            @RequestHeader(value="Authorization") String authtoken) {
	    	
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
	    	headers.set("X-TENANT-ID", subscriptionId);
			headers.set("Authorization", authtoken);
	    	
	    	HttpEntity entity = new HttpEntity<WorkflowInstanceRequest>(workflowInstanceRequest, headers);
	    	
	    	String urlString = url+"/workflow-service/definitions/"+workflowDefId+"/runtime/terminate";
	    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(urlString);
	    	
	        return restTemplate.exchange(builder.toUriString(), HttpMethod.PUT, entity, WorkflowInstanceResponse.class).getBody();	       
	    }
	    
	    @GetMapping(value = "/{definitionId}/runtime/status")
	    @ApiResponses(value = { @ApiResponse(code = 404, message = "INSTANCE_NOT_FOUND") })
	    public List<WorkflowInstanceResponse> getInstanceById(@PathVariable("definitionId") String workflowDefId,
	                                                          @RequestParam(required = false) String instanceId,
	                                                          @RequestParam(required = false) String entityId,
	                                                          @RequestHeader(value="X-TENANT-ID") String subscriptionId,
	                                                          @RequestHeader(value="Authorization") String authtoken) {
	    	
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
	    	headers.set("X-TENANT-ID", subscriptionId);
	    	headers.set("Authorization", authtoken);
	    	
	    	HttpEntity entity = new HttpEntity<>(headers);
	    	
	    	String urlString = url+"/workflow-service/definitions/"+workflowDefId+"/runtime/status";
	    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(urlString)
	    			.queryParam("entityId", entityId)
	    			.queryParam("instanceId", instanceId);
	    	
	        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, new ParameterizedTypeReference<List<WorkflowInstanceResponse>>(){}).getBody();
	    }
	    
	    @ResponseStatus(HttpStatus.OK)
	    @PutMapping(value = "/{definitionId}/activity/{activityDefId}/runtime", produces = MediaType.APPLICATION_JSON_VALUE)
	    @ApiResponses(value = { @ApiResponse(code = 409, message = "CONFLICT") })
	    public List<WorkflowInstanceResponse> performActivityAction(
	            @PathVariable("definitionId") String workflowDefId,
	            @PathVariable("activityDefId") String activityDefId,
	            @RequestBody List<ActivityActionRequest> activityActionRequests,
	            @RequestParam String action,
	            @RequestHeader(value="X-TENANT-ID") String subscriptionId,
	            @RequestHeader(value="Authorization") String authtoken) {
	    	
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
	    	headers.set("X-TENANT-ID", subscriptionId);
	    	headers.set("Authorization", authtoken);
	    	
	    	HttpEntity entity = new HttpEntity<List<ActivityActionRequest>>(activityActionRequests, headers);
	    	
	    	String urlString = url+"/workflow-service/definitions/"+workflowDefId+"/activity/"+activityDefId+"/runtime";
	    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(urlString)
	    			.queryParam("action", action);
	    	
	        return restTemplate.exchange(builder.toUriString(), HttpMethod.PUT, entity, new ParameterizedTypeReference<List<WorkflowInstanceResponse>>(){}).getBody();
	    }
	    
	    @GetMapping(value = "/{definitionId}/runtime/history", produces = MediaType.APPLICATION_JSON_VALUE)
	    @ApiResponses(value = { @ApiResponse(code = 404, message = "INSTANCE_NOT_FOUND") })
	    public List<WorkflowHistoryInstanceResponse> getInstanceHistory(@PathVariable("definitionId") String definitionId,
	    		                                                        @RequestParam(required = false) String instanceId,
	    		                                                        @RequestParam(required = false) String entityId,
	                                                                    @RequestHeader(value="X-TENANT-ID") String subscriptionId) {
	    	
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
	    	headers.set("X-TENANT-ID", subscriptionId);
	    	
	    	HttpEntity entity = new HttpEntity<WorkflowInstanceRequest>(headers);
	    	ParameterizedTypeReference<List<WorkflowHistoryInstanceResponse>>  parameterizedTypeReference = new ParameterizedTypeReference<List<WorkflowHistoryInstanceResponse>>(){};
	    	
	    	String urlString = url+"/workflow-service/definitions/"+definitionId+"/runtime/history";
	    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(urlString)
	    			.queryParam("instanceId", instanceId)
	    		    .queryParam("entityId", entityId);
	    	
	        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, parameterizedTypeReference).getBody();
	    }
	    
	    @GetMapping("/{workflowDefId}/user/instances/count")
	    @ApiResponses(value = { @ApiResponse(code = 404, message = "NO_USER_FOUND") })
	    public EntityCountResponse getEntityCount(@PathVariable("workflowDefId") String workflowDefId,
	                                              @RequestHeader(value="X-TENANT-ID") String subscriptionId,
	                                              @RequestHeader(value="Authorization") String authToken,
	                                              @RequestParam String queue)  {
	    	
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
	    	headers.set("X-TENANT-ID", subscriptionId);
	    	headers.set("Authorization", authToken);
	    	
	    	HttpEntity entity = new HttpEntity<WorkflowInstanceRequest>(headers);
	    	
	    	String urlString = url+"/workflow-service/definitions/"+workflowDefId+"/user/instances/count";
	    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(urlString)
	    			.queryParam("queue", queue);
	    			
	        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, EntityCountResponse.class).getBody();
	    }
	    
	    @GetMapping("/{workflowDefId}/activity/{activityDefId}/currentactivityusers")
	    @ApiResponses(value = { @ApiResponse(code = 404, message = "NO_USER_FOUND") })
	    public RolesOfNextActivityResponse getUsersByActivity(@PathVariable("workflowDefId") String workflowDefId,
	                                                          @PathVariable("activityDefId") String activityDefId,
	                                                          @RequestHeader(value="X-TENANT-ID") String subscriptionId,
	                                                          @RequestHeader(value="Authorization") String authToken,
	                                                          @RequestParam(required = false) String workload,
	                                                          Pageable pageable)  {
	    	
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
	    	headers.set("X-TENANT-ID", subscriptionId);
	    	headers.set("Authorization", authToken);
	    	
	    	HttpEntity entity = new HttpEntity<WorkflowInstanceRequest>(headers);
	    	
	    	String urlString = url+"/workflow-service/definitions/"+workflowDefId+"/activity/"+activityDefId+"/currentactivityusers";
	    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(urlString)
	    			.queryParam("workload", workload)
	    	        .queryParam("page", 0)
	                .queryParam("size", Integer.MAX_VALUE);
	    	System.out.println("currentactivityusers:"+ builder.toUriString());
	        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, RolesOfNextActivityResponse.class).getBody();
	    }

	    @GetMapping("/{workflowDefId}/activity/{activityDefId}/nextactivityusers")
	    @ApiResponses(value = { @ApiResponse(code = 404, message = "NO_USER_FOUND") })
	    public List<RolesOfNextActivityResponse> getNextUsersByActivity(@PathVariable("workflowDefId") String workflowDefId,
	                                                                    @PathVariable("activityDefId") String activityDefId,
	                                                                    @RequestHeader(value="X-TENANT-ID") String subscriptionId,
	                                                                    @RequestHeader(value="Authorization") String authToken,
	                                                                    @RequestParam(required = false) String instanceId,
	                                                                    @RequestParam(required = false) String entityId,
	                                                                    @RequestParam(required = false) String workload,
	                                                                    Pageable pageable)  {
	    	
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
	    	headers.set("X-TENANT-ID", subscriptionId);
	    	headers.set("Authorization", authToken);
	    	
	    	HttpEntity entity = new HttpEntity<WorkflowInstanceRequest>(headers);
	    	ParameterizedTypeReference<List<RolesOfNextActivityResponse>>  parameterizedTypeReference = new ParameterizedTypeReference<List<RolesOfNextActivityResponse>>(){};
	    	
	    	String urlString = url+"/workflow-service/definitions/"+workflowDefId+"/activity/"+activityDefId+"/nextactivityusers";
	    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(urlString)
	    			.queryParam("instanceId", instanceId)
	    		    .queryParam("entityId", entityId)
	    	        .queryParam("workload", workload)
	    	        .queryParam("page", 0)
	    	        .queryParam("size", Integer.MAX_VALUE);
	    	
	        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, parameterizedTypeReference).getBody();
	    }

	    @GetMapping("/{workflowDefId}/activity/{activityDefId}/updatedby")
	    @ApiResponses(value = { @ApiResponse(code = 404, message = "NO_USER_FOUND") })
	    public UserResponse getAssignedByUsersForActivity(@PathVariable("workflowDefId") String workflowDefId,
	                                                      @PathVariable("activityDefId") String activityDefId,
	                                                      @RequestParam(required = false) String instanceId,
	                                                      @RequestParam(required = false) String entityId,
	                                                      @RequestHeader(value="X-TENANT-ID") String subscriptionId) {
	    	
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
	    	headers.set("X-TENANT-ID", subscriptionId);
	    	
	    	HttpEntity entity = new HttpEntity<WorkflowInstanceRequest>(headers);
	    	
	    	String urlString = url+"/workflow-service/definitions/"+workflowDefId+"/activity/"+activityDefId+"/completedby";
	    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(urlString)
	    			.queryParam("instanceId", instanceId)
	    		    .queryParam("entityId", entityId);
	    	
	    
	        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, UserResponse.class).getBody();
	    }
	    
	    
	    @GetMapping("/{workflowDefId}/user/instances")
	    @ApiResponses(value = { @ApiResponse(code = 404, message = "NO_INSTANCES_FOUND") })
	    public InstancesByQueueResponse getUserQueues(@PathVariable("workflowDefId") String workflowDefId,
	                                                  @RequestHeader(value="X-TENANT-ID") String subscriptionId,
	                                                  @RequestHeader(value="Authorization") String authToken,
	                                                  @RequestParam String queue,
	                                                  Pageable pageable,
	                                                  PagedResourcesAssembler<InstancesByQueueResponseChild> pagedAssembler)  {
	    	
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
	    	headers.set("X-TENANT-ID", subscriptionId);
	    	headers.set("Authorization", authToken);
	    	
	    	HttpEntity entity = new HttpEntity<>(headers);
	    	System.out.println("pageableeeeeee:"+ pageable);
	    	String urlString = url+"/workflow-service/definitions/"+workflowDefId+"/user/instances";
	    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(urlString)
	    			.queryParam("queue", queue)
	    			.queryParam("page", pageable.getPageNumber())
	    	        .queryParam("size", pageable.getPageSize());

	    	return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, InstancesByQueueResponse.class).getBody();
	    }
	    
	    
	    @GetMapping("/ADMCases")
	    public String getCases(@RequestParam String CaseID)  {
	    	
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
	    	
	    	HttpEntity entity = new HttpEntity<>(headers);
	    	
	    	String urlString = desUrl+"/search/findByCaseIDIn";
	    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(urlString).queryParam("CaseID", CaseID);

	    	return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class).getBody();
	    }
	    
	    //@PatchMapping("/ADMCases")
	    @PostMapping(value="/ADMCases", headers="Content-Type=application/json")
	    public String updateCaseStatus(@RequestParam String CaseID,
	    		                       @RequestBody CasePatchDetails body)  {
	    	
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
	    	headers.setContentType(MediaType.APPLICATION_JSON);
	    	
	    	HttpEntity entity = new HttpEntity<CasePatchDetails>(body,headers);
	    	
	    	String urlString = desUrl+"/"+CaseID;
	    	//String urlString1 = "http://10.8.12.157:8090/aDM_Cases/"+CaseID;
	    	logger.info("DES URL:"+ urlString);
			HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
			RestTemplate template = new RestTemplate();
			template.setRequestFactory(requestFactory);
	    	return template.patchForObject(urlString, entity, String.class);

	    }
	    
	    
	    @ResponseStatus(HttpStatus.OK)
	    @PutMapping(value = "/{definitionId}/runtime", produces = MediaType.APPLICATION_JSON_VALUE)
	    @ApiResponses(value = { @ApiResponse(code = 409, message = "CONFLICT") })
	    public List<WorkflowInstanceResponse> performActivityAction(
	            @PathVariable("definitionId") String workflowDefId,
	            @RequestBody List<ActivityActionRequest> activityActionRequests,
	            @RequestParam String action,
	            @RequestHeader(value="Authorization") String authToken,
	            @RequestHeader(value="X-TENANT-ID") String subscriptionId) {
	    	
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
	    	headers.set("X-TENANT-ID", subscriptionId);
	    	headers.set("Authorization", authToken);
	    	
	    	HttpEntity entity = new HttpEntity<List<ActivityActionRequest>>(activityActionRequests, headers);
	    	
	    	ParameterizedTypeReference<List<WorkflowInstanceResponse>>  parameterizedTypeReference = new ParameterizedTypeReference<List<WorkflowInstanceResponse>>(){};
	    	
	    	String urlString = url+"/workflow-service/definitions/"+workflowDefId+"/runtime";
	    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(urlString).queryParam("action", action);

	    	return restTemplate.exchange(builder.toUriString(), HttpMethod.PUT, entity, parameterizedTypeReference).getBody();

	    }
	    
	    
	    @GetMapping("/{workflowDefId}/runtime/milestones")
	    public List<WorkflowMilestoneResponse> getMilestonesByInstancesById(@PathVariable("workflowDefId") String workflowDefId,
	                                                                        @RequestParam(required = false) String instanceId,
	                                                                        @RequestParam(required = false) String entityId,	                                                                        
	                                                                        @RequestHeader(value="X-TENANT-ID") String subscriptionId) {

	    	HttpHeaders headers = new HttpHeaders();
	    	headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
	    	headers.set("X-TENANT-ID", subscriptionId);
	    	
	    	HttpEntity entity = new HttpEntity<>(headers);
	    	
	    	ParameterizedTypeReference<List<WorkflowMilestoneResponse>>  parameterizedTypeReference = new ParameterizedTypeReference<List<WorkflowMilestoneResponse>>(){};
	    	
	    	String urlString = url+"/workflow-service/definitions/"+workflowDefId+"/runtime/milestones";
	    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(urlString)
	    			.queryParam("instanceId", instanceId)
	    		    .queryParam("entityId", entityId);

	    	return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, parameterizedTypeReference).getBody();
	    }
	    
	    @GetMapping("/{workflowDefId}/runtime/consultedUsers")
	    public List<UserResponse> returnPreviouslyConsultedUsers(@PathVariable("workflowDefId") String workflowDefId,
	                                                       @RequestHeader(value="X-TENANT-ID") String subscriptionId,
	                                                       @RequestHeader(value="Authorization") String authToken)  {

	    	HttpHeaders headers = new HttpHeaders();
	    	headers.set("X-TENANT-ID", subscriptionId);
	    	headers.set("Authorization", authToken);
	    	
	    	HttpEntity entity = new HttpEntity<>(headers);
	    	
            ParameterizedTypeReference<List<UserResponse>>  parameterizedTypeReference = new ParameterizedTypeReference<List<UserResponse>>(){};
	    	
	    	String urlString = url+"/workflow-service/definitions/"+workflowDefId+"/runtime/consultedUsers";
	    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(urlString);

	    	return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, parameterizedTypeReference).getBody();
	    	
	    }
	    
	    /*
	     ****************************************************************************************************************
	     *   WORKFLOW RUNTIME - Instance actions
	     ****************************************************************************************************************
	     */

	    @ApiOperation(value = "Initiate workflow", notes = "Initiate the workflow")
	    @ResponseStatus(HttpStatus.CREATED)
	    @PostMapping(value = "/{definitionId}/runtime/initiate", produces = MediaType.APPLICATION_JSON_VALUE)
	    @ApiResponses(value = { @ApiResponse(code = 409, message = "CONFLICT") })
	    public List<WorkflowInstanceResponse> initiateWorkflow(
	            @PathVariable("definitionId") String workflowDefId,
	            @RequestBody List<WorkflowInitiateRequest> workflowInitiateRequests,
	            @RequestHeader(value="X-TENANT-ID") String subscriptionId,
	            @RequestHeader(value="Authorization") String authToken
	            ) {
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.set("X-TENANT-ID", subscriptionId);
	    	headers.set("Authorization", authToken);
	    	headers.add("Content-Type", "application/json");
	    	HttpEntity entity = new HttpEntity<List<WorkflowInitiateRequest>>(workflowInitiateRequests,headers);
	    
	    	String urlString = url+"/workflow-service/definitions/"+workflowDefId+"/runtime/initiate";
	    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(urlString);
            ParameterizedTypeReference<List<WorkflowInstanceResponse>>  parameterizedTypeReference = new ParameterizedTypeReference<List<WorkflowInstanceResponse>>(){};

	    	return this.restTemplate.exchange(builder.toUriString(), HttpMethod.POST,entity,parameterizedTypeReference).getBody();
	    }
	    
	    
	    /*
	     ****************************************************************************************************************
	     *   Get Encrypted Password
	     ****************************************************************************************************************
	     */
	    
	    @PostMapping("/crypto/encryptText")
		@ResponseStatus(HttpStatus.CREATED)
		public ResponseEntity<String> getEncryptText(@RequestBody Map<String, String> textToEncrypt) {
			logger.info("Getting aoth tockent password");
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "application/json");
			HttpEntity entity = new HttpEntity(textToEncrypt, headers);		
			return this.restTemplate.postForEntity(url+"/security-service/crypto/encryptText", entity, String.class);
		}
	    
	    
	    
	    /*
	     ****************************************************************************************************************
	     *   Get OAuth Token for given username and password
	     ****************************************************************************************************************
	     */
	    @PostMapping("/oauth/token")
		public ResponseEntity<Object> getOauthToken(@RequestHeader(value="X-TENANT-ID") String subscriptionId, @RequestParam Map<String, String> params) {	
			HttpHeaders headers = new HttpHeaders();
			headers.add("X-TENANT-ID", subscriptionId);
			headers.add("Content-Type", "application/json");
			headers.add("Authorization",appTokenId);
			HttpEntity entity = new HttpEntity(params,headers);	
			if(params.get("roleName") != null){
				return this.restTemplate.postForEntity(url+"/security-service/oauth/token?grant_type="+params.get("grant_type")+"&username="+params.get("username")+"&password="+params.get("password")+"&roleName="+params.get("roleName"), entity, Object.class);
			}else{
				return this.restTemplate.postForEntity(url+"/security-service/oauth/token?grant_type="+params.get("grant_type")+"&username="+params.get("username")+"&password="+params.get("password"), entity, Object.class);
			}
			
		}




}
