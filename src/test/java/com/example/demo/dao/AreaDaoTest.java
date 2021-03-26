package com.example.demo.dao;

import com.example.demo.entity.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    public void queryArea() {
        List<Area> areas = areaDao.queryArea();
        System.out.println(areas.size());
    }

    @Test
    public void queryAreaById() {
    }

    @Test
    public void insertArea() {
        //创建一个区域对象
        Area area = new Area();
        area.setAreaName("测试区域3");
        area.setCreateTime(new Date());
        area.setPriority(3);
        //将该对象实例添加入库
        int effectedNum = areaDao.insertArea(area);
        //检测影响行数
        assertEquals(1, effectedNum);
        //校验总数是否+1
        List<Area> areaList = areaDao.queryArea();
        assertEquals(3, areaList.size());
    }

    @Test
    public void updateArea() {
    }

    @Test
    public void deleteArea() {
    }
}