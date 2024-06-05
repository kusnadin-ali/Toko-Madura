package com.tujuhsembilan.tokomadura.service.customer.implement;

import java.util.Map;
import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tujuhsembilan.tokomadura.config.JwtService;
import com.tujuhsembilan.tokomadura.dto.ResponseUtil79;
import com.tujuhsembilan.tokomadura.dto.users.LoginRequest;
import com.tujuhsembilan.tokomadura.dto.users.LoginResponse;
import com.tujuhsembilan.tokomadura.dto.users.RegisterRequest;
import com.tujuhsembilan.tokomadura.models.Customer;
import com.tujuhsembilan.tokomadura.repository.CustomerRepository;
import com.tujuhsembilan.tokomadura.service.customer.iservice.LoginService;
import com.tujuhsembilan.tokomadura.utils.ResponseUtil;
import com.tujuhsembilan.tokomadura.utils.Constant.CommonConstant.UsersConstant;
import com.tujuhsembilan.tokomadura.utils.Constant.LoggerConstant.ErrorCommonResponse;
import com.tujuhsembilan.tokomadura.utils.Constant.LoggerConstant.SuccessCommonResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final CustomerRepository customerRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final ObjectMapper objectMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ResponseUtil79 register(RegisterRequest request) {
        try {
            Optional<Customer> customerEmailExist = customerRepository.findByEmail(request.getEmail());
            if(customerEmailExist.isPresent()){
                return ResponseUtil.failed(ErrorCommonResponse.EMAIL_EXIST);
            }

            if(!request.getPassword().equals(request.getRePassword())){
                return ResponseUtil.failed(ErrorCommonResponse.REPASSWORD_NOT_VALID);
            }

            Customer newCustomer = Customer.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(UsersConstant.ROLE_CUSTOMER)
                .customerName(request.getCustomerName())
                .build();
            customerRepository.save(newCustomer);

            return ResponseUtil.success(SuccessCommonResponse.SUCCESS_SAVE);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.failed(ErrorCommonResponse.UNKNOWN_ERROR);
        }
    }

    @Override
    public ResponseUtil79 login(LoginRequest request) {
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword()
                )
            );
            Optional<Customer> customer = customerRepository.findByEmail(request.getEmail());

            if(!customer.isPresent()){
                return ResponseUtil.failed(ErrorCommonResponse.EMAIL_OR_PASSWORD_INVALID);
            }

            Map<String, Object> claims = objectMapper.convertValue(customer.get(), new TypeReference<Map<String, Object>>() {});

            return ResponseUtil.success(
                SuccessCommonResponse.SUCCESS_LOGIN,
                LoginResponse.builder()
                    .email(request.getEmail())
                    .role(UsersConstant.isRole(customer.get().getRole()))
                    .userId(customer.get().getCustomerId())
                    .token(jwtService.generateToken(claims, customer.get()))
                    .build()
            );

        } catch (BadCredentialsException e){
            e.printStackTrace();
            return ResponseUtil.failed(ErrorCommonResponse.EMAIL_OR_PASSWORD_INVALID);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.failed(ErrorCommonResponse.UNKNOWN_ERROR);
        }
    }
    
    
}
