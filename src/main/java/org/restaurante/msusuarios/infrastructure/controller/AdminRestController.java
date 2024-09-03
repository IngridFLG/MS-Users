package org.restaurante.msusuarios.infrastructure.controller;

import org.restaurante.msusuarios.application.dto.request.OwnerRequestDto;
import org.restaurante.msusuarios.application.dto.response.OwnerResponseDto;
import org.restaurante.msusuarios.application.handler.interfaces.IAdminHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user/admin")
@RequiredArgsConstructor
public class AdminRestController {
    
    private final IAdminHandler adminHandler;

    @PostMapping
    public ResponseEntity<Void> saveOwner(@RequestBody @Valid OwnerRequestDto ownerRequestDto) {
        adminHandler.saveOwner(ownerRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/owner/{id}")
    public ResponseEntity<OwnerResponseDto> getOwner(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(adminHandler.getOwner(id));
    }
}
