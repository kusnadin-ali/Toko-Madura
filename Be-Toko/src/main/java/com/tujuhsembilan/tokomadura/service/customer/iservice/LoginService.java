package com.tujuhsembilan.tokomadura.service.customer.iservice;

import com.tujuhsembilan.tokomadura.dto.ResponseUtil79;
import com.tujuhsembilan.tokomadura.dto.users.RegisterRequest;

public interface LoginService {
    
    ResponseUtil79 login();

    ResponseUtil79 register(RegisterRequest request);
}
