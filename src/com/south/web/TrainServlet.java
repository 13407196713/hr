package com.south.web;

import com.south.pojo.Train;
import com.south.service.Impl.TrainServiceImpl;
import com.south.service.TrainService;
import com.south.utils.DateUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class TrainServlet extends BaseServlet {
	private TrainService trainService = new TrainServiceImpl();
	public String toAddPage(HttpServletRequest request, HttpServletResponse response) throws Exception	{
		request.getRequestDispatcher("/addtrain.jsp").forward(request, response);
		return null;
	}
	public String trainAdd(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Train train = new Train();
		train.setName(request.getParameter("name"));
		train.setPurpose(request.getParameter("purpose"));
		train.setBegintime(DateUtil.parseToDate(request.getParameter("begintime"), DateUtil.yyyyMMdd));
		train.setEndtime(DateUtil.parseToDate(request.getParameter("endtime"), DateUtil.yyyyMMdd));
		train.setTeacher(request.getParameter("teacher"));
		train.setStudent(request.getParameter("student"));
		train.setDatum(request.getParameter("datum"));
		train.setEducate((byte) 0);
		trainService.saveTrain(train);
		List trainList=trainService.findTrainByEducate("0");
		request.setAttribute("trainList", trainList);
		request.getRequestDispatcher("/listtrain.jsp").forward(request, response);
		return null;
	}
	public String findTrainByEducate(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String educate = request.getParameter("educate");
		List<Train> trainList=trainService.findTrainByEducate(educate);
		request.setAttribute("trainList", trainList);
		request.getRequestDispatcher("/listtrain.jsp").forward(request, response);
		return null;
	}
	public List trainDetail(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String  id = request.getParameter("id");
		Train train = trainService.findTrainById(id);
		request.setAttribute("train", train);
		request.getRequestDispatcher("/detailtrain.jsp").forward(request, response);
		return null;
	}
	public List trainList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List trainList=trainService.findAllTrains();
		request.setAttribute("trainList", trainList);
		request.getRequestDispatcher("/listtrain.jsp").forward(request, response);
		return null;
	}
	public String toUpdatePage(HttpServletRequest request, HttpServletResponse response) throws Exception	{
		String  id = request.getParameter("id");
		Train train =trainService.findTrainById(id);
		request.setAttribute("train", train);
		request.getRequestDispatcher("/updatetrain.jsp").forward(request, response);
		return null;
	}
	public String updateTrain(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Train train = new Train();
		train.setId(Long.valueOf(request.getParameter("id")));
		train.setEffect(request.getParameter("effect"));
		train.setSummarize(request.getParameter("summarize"));
		trainService.updateTrain(train);
		List<Train> trainList=trainService.findTrainByEducate("1");
		request.setAttribute("educate", "1");
		request.setAttribute("trainList", trainList);
		request.getRequestDispatcher("/listtrain.jsp").forward(request, response);
		return null;
	}
	public String deleteTrain(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String id = request.getParameter("id");
		Train train =trainService.findTrainById(id);
		trainService.delete(id);
		List<Train> trainList=trainService.findTrainByEducate(train.getEducate().toString());
		request.setAttribute("educate", train.getEducate().toString());
		request.setAttribute("trainList", trainList);
		request.getRequestDispatcher("/listtrain.jsp").forward(request, response);
		return null;
	}
}
