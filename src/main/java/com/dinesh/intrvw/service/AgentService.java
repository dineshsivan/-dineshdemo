package com.dinesh.intrvw.service;

import java.util.List;

import com.dinesh.intrvw.Entity.Agent;

public interface AgentService {
	
	 List<Agent> findAll();

	 Agent find(Long id);

	 Agent save(Agent contact);

	 void delete(Long id);

}
