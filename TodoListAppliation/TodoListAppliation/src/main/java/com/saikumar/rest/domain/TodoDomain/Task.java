package com.saikumar.rest.domain.TodoDomain;

import java.util.concurrent.atomic.AtomicLong;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.saikumar.rest.domain.TodoDomain.valueObjects.TaskName;

public class Task {
	
	
	private Long id = Math.abs(idTaskCounter.getAndDecrement());
	
	private static AtomicLong idTaskCounter = new AtomicLong();
	
	@NotBlank
	@Length(min = 2, max = 255)
	private String name;
	private String description;

	public Task() {

	}

	public Task(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static Long createID() {
		return idTaskCounter.getAndIncrement();
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

}
