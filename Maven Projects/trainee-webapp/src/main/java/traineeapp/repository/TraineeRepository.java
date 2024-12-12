package traineeapp.repository;



import traineeapp.model.Trainee;

import java.util.List;

public interface TraineeRepository {

    public Trainee save(Trainee trainee);

    public List<Trainee> getAllTrainees();

    public void deleteTrainee(int id);

}
