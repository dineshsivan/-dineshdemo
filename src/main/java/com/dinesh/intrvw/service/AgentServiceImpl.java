package com.dinesh.intrvw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dinesh.intrvw.Entity.Agent;
import com.dinesh.intrvw.repo.AgentRepo;

@Service
public class AgentServiceImpl implements AgentService {

	@Autowired
	AgentRepo agentRepo;

	@Override
	public List<Agent> findAll() {
		return (List<Agent>) agentRepo.findAll();
	}

	@Override
	public Agent find(Long id) {

		return agentRepo.findById(id).get();
	}

	@Override
	public Agent save(Agent agent) {
		return agentRepo.save(agent);
	}

	@Override
	public void delete(Long id) {
		agentRepo.deleteById(id);

	}

}
