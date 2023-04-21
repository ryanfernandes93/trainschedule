package com.example.trainschedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class TrainController {

    @Autowired
    private TrainService trainService;
    @GetMapping("/schedule")
    private List<Train> getAllTrains(){
        return trainService.getAllTrains();
    }
    @RequestMapping(value = "/schedule/{line}", method = RequestMethod.GET)
    private ResponseEntity getByLine(@PathVariable("line") String line){
        List<Train> trains=new ArrayList<>();
        trains=trainService.getByLine(line);
        if(!trains.isEmpty()){
            ResponseEntity<List<Train>> trainsList = new ResponseEntity<>(trains, HttpStatus.OK);
            return trainsList;
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/schedule/{line}/{departure}")
    private ResponseEntity getByLineAndDeparture(@PathVariable("line") String line,@PathVariable("departure") String departure){
        String time="";
        int deptime;
        //convert the time to 24hrs
        if(departure.contains(":")){
            try{
                SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
                SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mma");
                Date date = parseFormat.parse(departure);
                //System.out.println(parseFormat.format(date) + " = " + );
                deptime=Integer.parseInt(displayFormat.format(date).toString().replaceAll(":",""));
            }
            catch(Exception e) {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        }
        else{
            deptime=Integer.parseInt(departure);
        }
        List<Train> trains=new ArrayList<>();
        trains=trainService.getByLine(line);
        if(!trains.isEmpty()){
            ResponseEntity<List<Train>> trainsList = new ResponseEntity<>(trainService.findByLineAndDeparture(line,deptime), HttpStatus.OK);
            return trainsList;
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
