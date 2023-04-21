package com.example.trainschedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TrainRepository extends JpaRepository<Train,Long> {
    List<Train> findByLineAndDeparture(String line,int departure);
    List<Train> findByLine(String line);
}
