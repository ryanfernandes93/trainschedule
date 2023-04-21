package com.example.trainschedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainService {
    @Autowired
    private TrainRepository trainRepository;

    public List<Train> getAllTrains(){
        List<Train> trains=new ArrayList<>();
        trainRepository.findAll().forEach(
                train -> trains.add(train));

        return trains;
    }

    public List<Train> getByLine(String line){
        List<Train> trains=new ArrayList<>();
        trainRepository.findByLine(line).forEach(train -> trains.add(train));
        return trains;
    }

    public List<Train> findByLineAndDeparture(String line,int departure){
        List<Train> trains=new ArrayList<>();
        trainRepository.findByLineAndDeparture(line,departure).forEach(train -> trains.add(train));
        return trains;
    }

}
