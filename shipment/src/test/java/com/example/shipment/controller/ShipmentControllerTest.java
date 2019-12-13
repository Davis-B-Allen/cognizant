package com.example.shipment.controller;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.shipment.model.Shipment;
import com.example.shipment.service.ShipmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ShipmentController.class)
public class ShipmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ShipmentService shipmentService;

    private Shipment shipment;
    private ObjectMapper objectMapper;

    public ShipmentControllerTest() {
        shipment = new Shipment();
        objectMapper = new ObjectMapper();
    }

    @BeforeEach
    public void init() {
        shipment.setId(1L);
        shipment.setName("Name");
        shipment.setTrackingNumber(101L);
    }

    @Test
    public void findShipmentByTrackingNumber_RecordExists_ReturnsShipment() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/shipment/101")
                .accept(MediaType.APPLICATION_JSON);

        when(shipmentService.findShipmentByTrackingNumber(anyLong())).thenReturn(shipment);
        String shipmentJson = objectMapper.writeValueAsString(shipment);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json(shipmentJson));
    }

    @Test
    public void create_ValidShipment_SavesAndReturnsShipment() throws Exception {
        String shipmentJson = objectMapper.writeValueAsString(shipment);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/shipment/addshipment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(shipmentJson);

        when(shipmentService.create(any())).thenReturn(shipment);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json(shipmentJson));
    }
}
