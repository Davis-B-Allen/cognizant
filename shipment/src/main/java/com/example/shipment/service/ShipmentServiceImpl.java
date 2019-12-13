package com.example.shipment.service;

import com.example.shipment.model.Shipment;
import com.example.shipment.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    @Autowired
    ShipmentRepository shipmentRepository;

    @Override
    public Shipment findShipmentByTrackingNumber(Long trackingNumber) {
        System.out.println(trackingNumber);
        return shipmentRepository.findByTrackingNumber(trackingNumber);
    }

    @Override
    public Shipment create(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }
}
