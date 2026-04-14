package com.example.aia.service;

import com.example.aia.dto.ChatMessageDTO;
import reactor.core.publisher.Flux;

public interface ChatService {
    Flux<String> stream(ChatMessageDTO chatMessageDTO);
}
