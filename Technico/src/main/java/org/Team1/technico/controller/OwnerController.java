package org.Team1.technico.controller;

import lombok.AllArgsConstructor;
import org.Team1.technico.model.Owner;
import org.Team1.technico.service.OwnerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor

@RestController
@RequestMapping("/owners")
public class OwnerController {
    private OwnerService service;

    @PostMapping(value = "")
    public Owner create(@RequestBody Owner owner) {
        return service.createOwner(owner);
    }

    @GetMapping("")
    public List<Owner> get() {
        return service.readOwner();
    }

    @GetMapping("/{ownerId}")
    public Owner get(@PathVariable("ownerId") int ownerId) {
        return service.readOwner(ownerId);
    }

    @PutMapping("/{ownerId}")
    public Owner update(@PathVariable("ownerId") int ownerId, @RequestBody Owner owner) {
        return service.updateOwner(ownerId, owner);
    }

    @DeleteMapping("/{ownerId}")
    public boolean delete(@PathVariable("ownerId") int ownerId) {
        return service.deleteOwner(ownerId);
    }


}