package com.south.dao;

import com.south.pojo.Train;

import java.util.List;

public interface TrainDao {
	void save(Train train);
	List findAllTrains();
	List<Train> findTrainByEducate(String educate);
	Train findTrainById(String id);
	void updateTrain(Train train);
	void delete(String id);
}
