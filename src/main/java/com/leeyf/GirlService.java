package com.leeyf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author:leeyf
 * @date:Created in19:40 2018/9/30
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;


    @Transactional() //事务回滚操作
    public void insertTwo(){
        try {
            Girl girlA =new Girl();
            girlA.setCupSize("B");
            girlA.setAge(16);
            girlRepository.save(girlA);

            Girl girlB =new Girl();
            girlB.setCupSize("BBBB");
            girlB.setAge(18);
            girlRepository.save(girlB);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
