package ru.bellintegrator.practice.soldier.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.soldier.service.SoldierService;
import ru.bellintegrator.practice.soldier.view.SoldierView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/", produces = APPLICATION_JSON_VALUE)
public class SoldierController {

    private final SoldierService soldierService;

    @Autowired
    public SoldierController(SoldierService soldierService) {
        this.soldierService = soldierService;
    }

    @ApiOperation(value = "addSoldier", nickname = "addSoldier", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/soldier")
    public void person(@RequestBody SoldierView soldier) {
        soldierService.add(soldier);
    }

    @ApiOperation(value = "getSoldierss", nickname = "getSoldiers", httpMethod = "GET")
    @GetMapping("/soldier")
    public List<SoldierView> soldiers() {
        return soldierService.soldiers();
    }
}
