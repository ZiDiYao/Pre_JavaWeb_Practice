package com.zidi.pre_crm_project_2025.Static_Proxy.service.factory;

import com.zidi.pre_crm_project_2025.Static_Proxy.service.UseSell;

public class UsbKingFactory implements UseSell {

    @Override
    public float sell(int amount) {
        // 厂家一个优盘 85
        return 85;
    }
}
