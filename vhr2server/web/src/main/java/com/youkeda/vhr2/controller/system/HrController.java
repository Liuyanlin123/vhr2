package com.youkeda.vhr2.controller.system;

import com.youkeda.vhr2.model.Hr;
import com.youkeda.vhr2.model.ResponseBean;
import com.youkeda.vhr2.model.Role;
import com.youkeda.vhr2.service.HrService;
import com.youkeda.vhr2.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/hr")
public class HrController {
    @Autowired
    HrService hrService;
    @Autowired
    RoleService roleService;
    @GetMapping("/")
    public List<Hr> getAllHrs(String keywords) {
        return hrService.getAllHrs(keywords);
    }

    @PutMapping("/")
    public ResponseBean updateHr(@RequestBody Hr hr) {
        if (hrService.updateHr(hr) == 1) {
            return ResponseBean.ok("更新成功!");
        }
        return ResponseBean.error("更新失败!");
    }
    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PutMapping("/role")
    public ResponseBean updateHrRole(Integer hrid, Integer[] rids) {
        if (hrService.updateHrRole(hrid, rids)) {
            return ResponseBean.ok("更新成功!");
        }
        return ResponseBean.error("更新失败!");
    }

    @DeleteMapping("/{id}")
    public ResponseBean deleteHrById(@PathVariable Integer id) {
        if (hrService.deleteHrById(id) == 1) {
            return ResponseBean.ok("删除成功!");
        }
        return ResponseBean.error("删除失败!");
    }
}
