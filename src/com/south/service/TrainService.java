package com.south.service;

import com.south.pojo.Train;

import java.util.List;

public interface TrainService {
	void saveTrain(Train train);
	void updateTrain(Train train);
	void delete(String id);
	List findAllTrains();
	Train findTrainById(String id);
	List<Train> findTrainByEducate(String educate);
}
