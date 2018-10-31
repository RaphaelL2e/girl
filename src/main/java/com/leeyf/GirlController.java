package com.leeyf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author:leeyf
 * @date:Created in20:43 2018/9/29
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }

    /**
     * 添加对象
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping(value = "/girls")
    public Girl  girlAdd(@RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){
        Girl girl =new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return  girlRepository.save(girl);
    }

    /**
     * 通过id查询对象
     * 1.0中用findOne
     * 2.0中用findById.get()
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id")Integer id){
        return girlRepository.findOne(id);
    }

    /**
     * 更新对象
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdated(@PathVariable Integer id,
                            @RequestParam String cupSize,
                            @RequestParam Integer age){
        Girl girl =new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);

        return girlRepository.save(girl);
    }

    /**
     * 通过id删除对象
     * 1.0中用delete
     * 2.0中用deleteById
     * @param id
     */
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        girlRepository.delete(id);
    }

    /**
     * 通过其他字段查询对象
     * @param age
     * @return
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    /**
     * 插入俩个对象
     */
    @PostMapping(value = "/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }
}
