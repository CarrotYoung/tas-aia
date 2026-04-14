package com.example.aia.service.impl;

import com.example.aia.dto.SkillDTO;
import com.example.aia.service.SkillService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InMemorySkillService implements SkillService {
    @Override
    public List<SkillDTO> listSkills() {
        return List.of(
                new SkillDTO("expense_apply", "费用报销", "用于员工费用报销表单生成与校验"),
                new SkillDTO("interview_eval", "面试评估", "用于结构化面试反馈表单生成")
        );
    }
}
