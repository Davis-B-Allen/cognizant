package com.example.shipment.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.example.shipment.model.Shipment;
import com.example.shipment.repository.ShipmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ShipmentServiceTest {


    @InjectMocks
    ShipmentServiceImpl shipmentService;

    @Mock
    ShipmentRepository shipmentRepository;

    @InjectMocks
    private Shipment shipment;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        shipment.setId(1L);
        shipment.setName("name");
        shipment.setTrackingNumber(101L);
    }

    @Test
    public void findShipmentByTrackingNumber_RecordExists_ReturnsShipment() {
        Long trackingNumber = 101L;
        shipment.setTrackingNumber(trackingNumber);
        when(shipmentRepository.findByTrackingNumber(anyLong())).thenReturn(shipment);

        Shipment foundShipment = shipmentService.findShipmentByTrackingNumber(trackingNumber);

        assertThat(foundShipment).isEqualTo(shipment);
    }

    @Test
    public void create_ValidShipment_SavesAndReturnsShipment() {
        Long trackingNumber = 101L;
        shipment.setTrackingNumber(trackingNumber);
        when(shipmentRepository.save(any())).thenReturn(shipment);

        Shipment savedShipment = shipmentService.create(shipment);

        assertThat(savedShipment).isEqualTo(shipment);
    }

}
