package com.lambdaschool.modelingorders.controllers;


import com.lambdaschool.modelingorders.models.Agent;
import com.lambdaschool.modelingorders.services.AgentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/agent")
public class AgentController {

    @Autowired
    private AgentServices agentServices;

    @GetMapping(value = "/agents/{agentid}", produces = "application/json")
    public ResponseEntity<?> findAllById(@PathVariable long agentid){
        Agent agent = agentServices.findAgentById(agentid);
        return new ResponseEntity<>(agent, HttpStatus.OK);
    }
}
