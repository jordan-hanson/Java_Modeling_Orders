package com.lambdaschool.modelingorders.services;

import com.lambdaschool.modelingorders.models.Agent;
import com.lambdaschool.modelingorders.repositories.AgentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value= "agentServices")
public class AgentServicesImp implements AgentServices{

    @Autowired
    private AgentsRepository agentsRepository;

    @Transactional
    @Override
    public Agent save(Agent agent) {
        return agentsRepository.save(agent);
    }

    @Override
    public Agent findAgentById(long agentid) {
        return agentsRepository.findById(agentid)
                .orElseThrow(() -> new EntityNotFoundException("Agent " + agentid + " not found."));
    }
}
