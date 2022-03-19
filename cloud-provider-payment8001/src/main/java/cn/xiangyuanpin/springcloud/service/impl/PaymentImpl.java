package cn.xiangyuanpin.springcloud.service.impl;

import cn.xiangyuanpin.springcloud.dao.PaymentDao;
import cn.xiangyuanpin.springcloud.entities.Payment;
import cn.xiangyuanpin.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaymentImpl implements PaymentService {

@Autowired
   private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create( payment);
    }

    @Override
    public Payment getPaymentById(long id) {
       return paymentDao.getPaymentById(id);
    }
}
