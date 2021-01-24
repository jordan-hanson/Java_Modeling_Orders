package com.lambdaschool.modelingorders.services;

import com.lambdaschool.modelingorders.models.Agent;

public interface AgentServices {
    Agent save(Agent agent);

    Agent findAgentById(long agentid);
}
