package org.restaurante.msusuarios.infrastructure.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.restaurante.msusuarios.application.dto.request.ClientRequestDto;
import org.restaurante.msusuarios.application.dto.response.ClientResponseDto;
import org.restaurante.msusuarios.application.handler.interfaces.IClientHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/client")
@RequiredArgsConstructor
public class ClientRestController {

    private final IClientHandler clientHandler;

    @PostMapping
    public ResponseEntity<Void> saveClient(@RequestBody @Valid ClientRequestDto clientRequestDto) {
        clientHandler.saveClient(clientRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDto> getClient(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clientHandler.getClient(id));
    }
}
