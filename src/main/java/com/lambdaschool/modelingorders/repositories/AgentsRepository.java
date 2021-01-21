package com.lambdaschool.modelingorders.repositories;

import com.lambdaschool.modelingorders.models.Agent;
import org.springframework.data.repository.CrudRepository;

public interface AgentsRepository extends CrudRepository<Agent, Long> {
}
