package com.youkeda.vhr2.controller.system.basic;

import com.youkeda.vhr2.model.JobLevel;
import com.youkeda.vhr2.model.ResponseBean;
import com.youkeda.vhr2.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/system/basic/joblevel")
public class JobLevelController {
    @Autowired
    JobLevelService jobLevelService;
    @GetMapping("/")
    public List<JobLevel> getAllJobLevels() {
        return jobLevelService.getAllJobLevels();
    }

    @PostMapping("/")
    public ResponseBean addJobLevel(@RequestBody JobLevel jobLevel) {
        if (jobLevelService.addJobLevel(jobLevel) == 1) {
            return ResponseBean.ok("添加成功!");
        }
        return ResponseBean.error("添加失败!");
    }

    @PutMapping("/")
    public ResponseBean updateJobLevelById(@RequestBody JobLevel jobLevel) {
        if (jobLevelService.updateJobLevelById(jobLevel) == 1) {
            return ResponseBean.ok("更新成功!");
        }
        return ResponseBean.error("更新失败!");
    }

    @DeleteMapping("/{id}")
    public ResponseBean deleteJobLevelById(@PathVariable Integer id) {
        if (jobLevelService.deleteJobLevelById(id) == 1) {
            return ResponseBean.ok("删除成功!");
        }
        return ResponseBean.error("删除失败!");
    }

    @DeleteMapping("/")
    public ResponseBean deleteJobLevelsByIds(Integer[] ids) {
        if (jobLevelService.deleteJobLevelsByIds(ids) == ids.length) {
            return ResponseBean.ok("删除成功!");
        }
        return ResponseBean.error("删除失败!");
    }
}