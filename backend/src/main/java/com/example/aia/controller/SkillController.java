package com.example.aia.controller;

import com.example.aia.dto.ApiResponse;
import com.example.aia.dto.SkillDTO;
import com.example.aia.service.SkillService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping
    public ApiResponse<List<SkillDTO>> list() {
        return ApiResponse.ok(skillService.listSkills());
    }
}
