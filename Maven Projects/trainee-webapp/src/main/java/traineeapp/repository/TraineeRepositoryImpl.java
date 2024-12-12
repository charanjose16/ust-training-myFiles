package traineeapp.repository;

import traineeapp.model.Trainee;
import traineeapp.util.JdbcConnection;


import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.*;
import static java.util.Date.*;

public class TraineeRepositoryImpl implements TraineeRepository {

    List<Trainee> trainees = new ArrayList<>();
    Connection connection;

    public TraineeRepositoryImpl(){
         connection= JdbcConnection.createConnection();
    }

    public Trainee save(Trainee trainee) {

        String sql="Insert into trainee(id,name,location,date_joined) values(?,?,?,?)";

        try {
            PreparedStatement statement= connection.prepareStatement(sql);
            statement.setInt(1,trainee.getId());
            statement.setString(2,trainee.getName());
            statement.setString(3,trainee.getLocation());
            statement.setDate(4, java.sql.Date.valueOf(trainee.getJoinedDate()));
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
       return trainee;
    }


    public List<Trainee> getAllTrainees() {

        String sql="select * from trainee";
        List<Trainee> allTrainees;
        try {
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            allTrainees=getTraineesByList(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allTrainees;
    }


    public void deleteTrainee(int id) {
        String sql="Delete from trainee where id="+id;

        try {
            PreparedStatement statement= connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Trainee> getTraineesByList(ResultSet resultSet) {
        Trainee trainee;
        List<Trainee> traineesList=new ArrayList<>();
            try {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String location = resultSet.getString("location");
                    LocalDate date = resultSet.getDate("date_joined").toLocalDate();
                    trainee = new Trainee(id, name, location, date);
                    traineesList.add(trainee);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

         return traineesList;
    }


}



