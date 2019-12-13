package com.example.clientfe.service;

import com.example.clientfe.client.ShipmentClient;
import com.example.clientfe.model.Shipment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ShipmentServiceImpl.class, ShipmentClient.class})
public class ShipmentServiceTest {

    @Autowired
    ShipmentService shipmentService;

    @MockBean
    ShipmentClient shipmentClient;

    private Shipment shipment;

    public ShipmentServiceTest() {
        shipment = new Shipment();
    }

    @BeforeEach
    public void init() {
        shipment.setId(1L);
        shipment.setName("name");
        shipment.setTrackingNumber(101L);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findShipmentByTrackingNumber_RecordExists_ReturnsShipment() {
        Long trackingNumber = 101L;
        shipment.setTrackingNumber(trackingNumber);
        when(shipmentClient.findShipmentByTrackingNumber(anyLong())).thenReturn(shipment);

        Shipment foundShipment = shipmentService.findShipmentByTrackingNumber(trackingNumber);

        assertThat(foundShipment).isEqualTo(shipment);
    }

    @Test
    public void create_ValidShipment_SavesAndReturnsShipment() {
        Long trackingNumber = 101L;
        shipment.setTrackingNumber(trackingNumber);
        when(shipmentClient.create(any())).thenReturn(shipment);

        Shipment savedShipment = shipmentService.create(shipment);

        assertThat(savedShipment).isEqualTo(shipment);
    }
}
