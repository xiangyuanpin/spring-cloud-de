package cn.xiangyuanpin.springcloud.service;


import cn.xiangyuanpin.springcloud.entities.CommonResult;
import cn.xiangyuanpin.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Component
@FeignClient(value="CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") long id);

    @GetMapping("/payment/feign/timeout")
    public String PaymentFeignTimeout();
}
