package cn.xiangyuanpin.springcloud.controller;

import cn.xiangyuanpin.springcloud.entities.CommonResult;
import cn.xiangyuanpin.springcloud.entities.Payment;
import cn.xiangyuanpin.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") long id){
        return paymentFeignService.getPaymentById(id);
    }


    @GetMapping("/consumer/payment/feign/timeout")
    public String PaymentFeignTimeout(){
        return  paymentFeignService.PaymentFeignTimeout();
    }

}
