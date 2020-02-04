package com.itsy.service;

import java.util.List;

import com.itsy.model.Status;

public interface StatusService {
	public List<Status> getAllStatus();
	public Status addStatus(Status c);
	public Status getStatusById(int id);
	public Status updateStatus(Status c );
	public void deleteStatus(int id);
}
