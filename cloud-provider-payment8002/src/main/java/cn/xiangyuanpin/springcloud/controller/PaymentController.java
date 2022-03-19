package cn.xiangyuanpin.springcloud.controller;


import cn.xiangyuanpin.springcloud.entities.CommonResult;
import cn.xiangyuanpin.springcloud.entities.Payment;
import cn.xiangyuanpin.springcloud.service.PaymentService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

       @Value("${server.port}")
    private String serverPort;


  @Autowired
    private PaymentService paymentService;

@PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
       int result=paymentService.create(payment);
       log.info("************插入结果"+result);
       if(result>0){
           return new CommonResult(200,"插入数据库成功,serverPort："+serverPort,result);
       }else{
           return new CommonResult(444,"插入数据库失败",null);
       }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") long id){
       Payment payment=paymentService.getPaymentById(id);
        log.info("************查询结果"+payment);
        if(payment!=null){
            return new CommonResult(200,"查询成功,serverPort："+serverPort,payment);
        }else{
            return new CommonResult(444,"查询失败",null);
        }
    }

    @GetMapping("/payment/feign/timeout")
    public String PaymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
