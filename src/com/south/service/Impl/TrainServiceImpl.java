package com.south.service.Impl;

import com.south.dao.Impl.TrainDaoImpl;
import com.south.dao.TrainDao;
import com.south.pojo.Train;
import com.south.service.TrainService;

import java.util.List;

public class TrainServiceImpl implements TrainService {
	private TrainDao trainDao = new TrainDaoImpl();
	@Override
	public void saveTrain(Train train) {
		trainDao.save(train);
	}
	@Override
	public void updateTrain(Train train) {
		trainDao.updateTrain(train);
	}
	@Override
	public void delete(String id) {
		trainDao.delete(id);
	}
	@Override
	public List findAllTrains() {
		return trainDao.findAllTrains();
	}
	@Override
	public List<Train> findTrainByEducate(String educate) {
		return trainDao.findTrainByEducate(educate);
	}
	@Override
	public Train findTrainById(String id) {
		return trainDao.findTrainById(id);
	}
}
