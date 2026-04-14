package com.example.aia.service.impl;

import com.example.aia.dto.ChatMessageDTO;
import com.example.aia.service.ChatService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@Service
public class MockChatService implements ChatService {

    @Override
    public Flux<String> stream(ChatMessageDTO chatMessageDTO) {
        List<String> chunks = List.of(
                "正在解析你的需求...",
                "已匹配技能：" + chatMessageDTO.skillCode(),
                "建议补充字段：申请原因、金额、附件",
                "已生成表单草稿，可在右侧动态表单继续编辑"
        );
        return Flux.fromIterable(chunks).delayElements(Duration.ofMillis(400));
    }
}
