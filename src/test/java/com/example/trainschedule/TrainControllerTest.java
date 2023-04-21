package com.example.trainschedule;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TrainController.class)
public class TrainControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    @MockBean
    TrainRepository trainRecordRepository;
    Train RECORD_1 = new Train(1L, "Yonge", 930, 1030);
    Train RECORD_2 = new Train(2L, "yonge", 1300, 1400);

    @Test
    public void getAllTrains() throws Exception {
        List<Train> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2));

        Mockito.when(trainRecordRepository.findAll()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/schedule")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",notNullValue()));
    }

    @Test
    public void getByLineAndDeparture() throws Exception {
        Mockito.when(trainRecordRepository.findByLineAndDeparture("barrie",1300)).thenReturn(null);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/schedule/barrie/1300")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$",nullValue()));
    }

}
