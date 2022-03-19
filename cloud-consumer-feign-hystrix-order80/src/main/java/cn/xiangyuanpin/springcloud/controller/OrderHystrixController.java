package cn.xiangyuanpin.springcloud.controller;


import cn.xiangyuanpin.springcloud.service.PaymentHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

@GetMapping("")
    public String  paymentInfo_OK(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfo_OK(id);
    }

    public String paymentInfo_TimeOut(@PathVariable("id")  Integer id){
       return  paymentHystrixService.paymentInfo_TimeOut(id);
    }


}
