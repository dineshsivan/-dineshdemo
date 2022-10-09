package com.dinesh.intrvw.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dinesh.intrvw.Entity.Agent;

@Repository
public interface AgentRepo extends CrudRepository<Agent, Long>{

}
