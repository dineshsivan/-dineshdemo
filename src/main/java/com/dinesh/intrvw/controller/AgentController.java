package com.dinesh.intrvw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dinesh.intrvw.Entity.Agent;
import com.dinesh.intrvw.service.AgentService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController("v1")
public class AgentController {

	@Autowired
	AgentService service;

	@ApiOperation(value = "Creates an Agent", responseContainer = "Agent")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal server error occurred") })
	@PostMapping(value = "/agents")
	public Agent createContact(@RequestBody Agent contact) {
		return service.save(contact);
	}

	@ApiOperation(value = "Retrieves all agents.", responseContainer = "List<Agent>")
	@RequestMapping(method = RequestMethod.GET, value = "/agents")
	List<Agent> findAll() {
		return service.findAll();
	}

	@ApiOperation(value = "Finds agent by id", responseContainer = "Agent")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal server error occurred") })
	@ApiParam(value = "Agent's {id}", required = true)
	@GetMapping(value = "/agents/{id}")
	public Agent findContact(@PathVariable("id") Long id) {
		return service.find(id);
	}
	
	  @ApiOperation(value = "Deletes agent by Id", responseContainer = "void")
	  
	  @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
	  
	  @ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 404,
	  message = "Not Found"),
	  
	  @ApiResponse(code = 500, message = "Internal server error occurred") })
	  
	  @ApiParam(value = "Agent's {id}", required = true)
	  
	  @DeleteMapping(value = "/agents/{id}") public void
	  deleteContact(@PathVariable("id") Long id) { service.delete(id); }
	 
	//test

}
