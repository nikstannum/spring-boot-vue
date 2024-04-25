package org.example.web;

import org.example.service.MessageService;
import org.example.service.dto.MessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/messages")
public class MessageRestController {

    private final MessageService service;

    public MessageRestController(MessageService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageDto create(@RequestBody MessageDto dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<MessageDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public MessageDto getById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public MessageDto update(@PathVariable("id") Long id, @RequestBody MessageDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
    }

}
