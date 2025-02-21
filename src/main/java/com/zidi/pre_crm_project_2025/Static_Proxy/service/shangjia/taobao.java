package com.zidi.pre_crm_project_2025.Static_Proxy.service.shangjia;

import com.zidi.pre_crm_project_2025.Static_Proxy.service.UseSell;
import com.zidi.pre_crm_project_2025.Static_Proxy.service.factory.UsbKingFactory;

public class taobao implements UseSell {
    // 淘宝是一个商家, 代理优盘的销售/ 中介
    private UseSell UseSellFactory = new UsbKingFactory();
    @Override
    public float sell(int amount) {
        // 向厂家发送订单, 告诉厂家我卖了优盘 , 你厂家需要发货
        float price = UseSellFactory.sell(amount);

        // 商家需要加价, 也就是代理要增加价格
        price += 25;

        return price;
    }
}
