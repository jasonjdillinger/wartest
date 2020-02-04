package com.itsy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itsy.dao.StatusDao;
import com.itsy.model.Status;

@Service
public class StatusServiceImpl implements StatusService {

	@Autowired
	private StatusDao statusDao;

	@Override
	public List<Status> getAllStatus() {
		// TODO Auto-generated method stub
		return statusDao.findAll();
	}

	@Override
	public Status addStatus(Status c) {
		// TODO Auto-generated method stub
		return statusDao.save(c);
	}

	@Override
	public Status getStatusById(int id) {
		// TODO Auto-generated method stub
		return statusDao.findById(id).get();
	}

	@Override
	public Status updateStatus(Status c) {
		// TODO Auto-generated method stub
		return statusDao.save(c);
	}

	@Override
	public void deleteStatus(int id) {
		// TODO Auto-generated method stub
		statusDao.deleteById(id);
	}

}
