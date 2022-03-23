package org.Team1.technico.controller;


import lombok.AllArgsConstructor;
import org.Team1.technico.model.Property;
import org.Team1.technico.model.Repair;
import org.Team1.technico.service.PropertyService;
import org.Team1.technico.service.RepairService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/properties")


public class PropertyController {
    private PropertyService propertyService;
    private RepairService repairService;


//    @PostMapping(value = "")
//    public Property create(@RequestBody Property property) {
//        return propertyService.createProperty(property);
//    }


    @GetMapping(value = "")
    public List<Property> get(@RequestParam(name = "vatNumber", required = false) String vatNumber, @RequestParam(name = "identityE9", required = false) String identityE9) {

        if ( !(identityE9.isBlank() || identityE9.equals(null) )|| vatNumber != null && vatNumber != "")
            return propertyService.getByOwnerVatNumberOrIdentityE9(vatNumber, identityE9);


        return propertyService.readProperty();
    }

    @GetMapping("/{propertyId}")
    public Property get(@PathVariable("propertyId") int propertyId) {
        return propertyService.readProperty(propertyId);
    }

    @PutMapping(value = "/{propertyId}")
    public Property update(@PathVariable("propertyId") int propertyId, @RequestBody Property property) {
        return propertyService.updateProperty(propertyId, property);
    }

    @DeleteMapping("/{propertyId}")
    public boolean delete(@PathVariable("propertyId") int propertyId) {
        return propertyService.deleteProperty(propertyId);
    }



    @GetMapping("/{propertyId}/repairs")
    public List<Repair> getRepairsOfProperty(@PathVariable("propertyId") int propertyId) {
        List<Repair> repairs = propertyService.getRepairsByPropertyId(propertyId);
//        List<RepairDto> repairsDto = repairs.stream().
//                map(repair -> new RepairDto(repair.getId(),
//                        repair.getRegistrationDate(),
//                        repair.getCompletionDate(),
//                        repair.getRepairStatus(),
//                        repair.getRepairType(),
//                        repair.getCost(),
//                        repair.getDescription())).toList();
        return repairs;
    }

    @PostMapping("/{propertyId}/repairs")
    public boolean addRepairOfProperty(@PathVariable("propertyId") int propertyId, @RequestBody Repair repair) {
        return repairService.addRepairToProperty(repair, propertyId);
    }
}
