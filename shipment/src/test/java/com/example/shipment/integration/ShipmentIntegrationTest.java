package com.example.shipment.integration;

import com.example.shipment.model.Shipment;
import com.example.shipment.repository.ShipmentRepository;
import com.example.shipment.service.ShipmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class ShipmentIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ShipmentRepository shipmentRepository;

    private Shipment shipment;
    private ObjectMapper objectMapper;

    public ShipmentIntegrationTest() {
        shipment = new Shipment();
        objectMapper = new ObjectMapper();
    }

    @BeforeEach
    public void init() {
        shipment.setName("Name");
        shipment.setTrackingNumber(101L);
    }

//    @Test
//    @Transactional
//    public void findShipmentByTrackingNumber_RecordExists_ReturnsShipment() throws Exception {
//        String shipmentJson = objectMapper.writeValueAsString(shipment);
//        System.out.println(shipmentJson);
//
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .post("/shipment/addshipment")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(shipmentJson);
//
//        mockMvc.perform(requestBuilder)
//                .andExpect(status().isOk())
//                .andExpect(content().json(shipmentJson));
//    }

    @Test
    @Transactional
    public void create_ValidShipment_SavesAndReturnsShipment() throws Exception {
        shipment.setId(1L);
        String shipmentJson = objectMapper.writeValueAsString(shipment);
        System.out.println(shipmentJson);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/shipment/addshipment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(shipmentJson);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json(shipmentJson));
    }


}
