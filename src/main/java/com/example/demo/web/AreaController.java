package com.example.demo.web;

import com.example.demo.entity.Area;
import com.example.demo.service.AreaService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/superadmin")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/areas", method = {RequestMethod.GET, RequestMethod.POST})
    private Map<String, Object> listArea() {
        Map<String, Object> map = new HashMap<>();
        List<Area> areas = areaService.queryArea();
        map.put("status","");
        map.put("area_list", areas);
        return map;
    }

    /**
     * 添加区域信息
     *
     * @param areaName
     * @param priority
     * @return
     */
    @RequestMapping(value = "/addarea", method = RequestMethod.POST)
    private Map<String, Object> addArea(@RequestParam("area_name") String areaName, @RequestParam("priority") Integer priority) {
        Area area = new Area();
        area.setAreaName(areaName);
        area.setPriority(priority);
        area.setCreateTime(new Date());
        area.setLastEditTime(new Date());
        Map<String, Object> modelMap = new HashMap<>();
        // 添加区域信息
        modelMap.put("status",200);
        modelMap.put("success", areaService.insertArea(area));
        return modelMap;
    }
}
