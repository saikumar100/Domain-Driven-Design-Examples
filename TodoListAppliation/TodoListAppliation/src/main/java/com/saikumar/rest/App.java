package com.saikumar.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.saikumar.rest.controller.TodoListController;
import com.saikumar.rest.services.ToDoApplicationHealthCheck;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
 
/*
 * This is the start of Application
 * 
 * 
 * */
public class App extends Application<Configuration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
 
    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }
 
    @Override
    public void run(Configuration c, Environment e) throws Exception {
        LOGGER.info("Registering REST resources");
        e.jersey().register(new TodoListController(e.getValidator()));
        e.healthChecks().register("TodoApplication HealthCheck" , new ToDoApplicationHealthCheck());
    }
 
    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
} 