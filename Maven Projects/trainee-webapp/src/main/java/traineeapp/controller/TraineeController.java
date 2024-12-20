package traineeapp.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import traineeapp.model.Trainee;
import traineeapp.repository.TraineeRepository;
import traineeapp.repository.TraineeRepositoryImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/trainees/*")
public class TraineeController extends HttpServlet {

    TraineeRepository traineeRepository;
    public void init() throws ServletException {
        traineeRepository = new TraineeRepositoryImpl();
    }



    protected void addTrainee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id=Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String location = req.getParameter("location");
        LocalDate joinedDate = LocalDate.parse(req.getParameter("joinedDate"));
        Trainee trainee=new Trainee(id,name,location,joinedDate);
       traineeRepository.save(trainee);
        List<Trainee> trainees=traineeRepository.getAllTrainees();
        req.setAttribute("trainees",trainees);
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/AddTrainee.jsp");
        requestDispatcher.forward(req,resp);


    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path=req.getRequestURI();
        if(path.contains("/add")){
            addTrainee(req,resp);
        }
        else if(path.contains("/get")){
            getAllTrainees(req,resp);
        } else if (path.contains("/delete")) {
            deleteTrainee(req,resp);
        }

    }

    protected void getAllTrainees(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException{
        List<Trainee> trainees=traineeRepository.getAllTrainees();
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/view.jsp");
        req.setAttribute("trainees",trainees);
        requestDispatcher.forward(req,resp);
  }

  protected void deleteTrainee(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{

      int id=Integer.parseInt(req.getParameter("id"));
      traineeRepository.deleteTrainee(id);
      resp.sendRedirect("trainees/get");
  }
}
