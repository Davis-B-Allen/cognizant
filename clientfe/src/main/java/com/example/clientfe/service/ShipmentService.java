package com.example.clientfe.service;

import com.example.clientfe.model.Shipment;

public interface ShipmentService  {
    Shipment findShipmentByTrackingNumber(Long trackingNumber);

    Shipment create(Shipment shipment);
}
