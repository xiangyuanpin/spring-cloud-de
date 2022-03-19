package cn.xiangyuanpin.springcloud.controller;


import cn.xiangyuanpin.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {

  @Autowired
    private PaymentService paymentService;


  @GetMapping("/payment/hystrix/ok/{id}")
    public String  paymentInfo_OK(@PathVariable("id") Integer id){
        return paymentService.paymentInfo_OK(id);
    }

  @GetMapping("/payment/hystrix/timeout/{id}")
  public String paymentInfo_TimeOut(@PathVariable("id")  Integer id){
    return paymentService.paymentInfo_TimeOut(id);
  }



}
