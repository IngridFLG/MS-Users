package org.restaurante.msusuarios.infrastructure.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.restaurante.msusuarios.application.dto.request.EmployeeRequestDto;
import org.restaurante.msusuarios.application.dto.response.EmployeeResponseDto;
import org.restaurante.msusuarios.application.handler.interfaces.IOwnerHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/owner")
@RequiredArgsConstructor
public class OwnerRestController {

    private final IOwnerHandler ownerHandler;

    @PostMapping
    public ResponseEntity<Void> saveOwner(@RequestBody @Valid EmployeeRequestDto employeeRequestDto) {
        ownerHandler.saveEmployee(employeeRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/employee/{email}")
    public ResponseEntity<EmployeeResponseDto> getEmployee(@PathVariable("email") String email) {
        return ResponseEntity.status(HttpStatus.OK).body(ownerHandler.getEmployee(email));
    }

}
