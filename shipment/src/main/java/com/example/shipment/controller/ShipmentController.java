package com.example.shipment.controller;

import com.example.shipment.model.Shipment;
import com.example.shipment.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("shipment")
public class ShipmentController {

    @Autowired
    ShipmentService shipmentService;


    @GetMapping("/{trackingNumber}")
    public Shipment findShipmentByTrackingNumber(@PathVariable Long trackingNumber) {
        return shipmentService.findShipmentByTrackingNumber(trackingNumber);
    }

    @PostMapping("/addshipment")
    public Shipment create(@RequestBody Shipment shipment) {
        return shipmentService.create(shipment);
    }

}
