package com.example.clientfe.service;

import com.example.clientfe.client.ShipmentClient;
import com.example.clientfe.model.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    @Autowired
    ShipmentClient shipmentClient;

    @Override
    public Shipment findShipmentByTrackingNumber(Long trackingNumber) {
        return shipmentClient.findShipmentByTrackingNumber(trackingNumber);
    }

    @Override
    public Shipment create(Shipment shipment) {
        return shipmentClient.create(shipment);
    }
}
