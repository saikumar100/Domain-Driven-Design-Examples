package com.saikumar.rest.services;

import com.codahale.metrics.health.HealthCheck;

public class ToDoApplicationHealthCheck extends HealthCheck{

	@Override
	protected Result check() throws Exception {
		//TODO:NEED TO ADD HEALTH CHECKS FOR DBCONNECTIVITY etc.,
		return Result.healthy();
	}

}
