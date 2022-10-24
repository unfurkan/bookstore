package com.getir.bookstore.configuration.security;

import com.getir.bookstore.core.customer.model.domain.Customer;
import com.getir.bookstore.core.customer.service.CustomerService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private final CustomerService customerService;

    public CustomUserDetailService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public CustomUserDetail loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Customer> optionalCustomer = customerService.findByEmail(username);

        return optionalCustomer.map(customer -> createCustomUserDetail(customer))
                .stream()
                .findFirst()
                .orElse(null);
    }


    private CustomUserDetail createCustomUserDetail(Customer customer) {

        CustomUserDetail customUserDetail = new CustomUserDetail();

        customUserDetail.setId(customer.getId());
        customUserDetail.setUsername(customer.getEmail());
        customUserDetail.setPassword(customer.getPassword());
        customUserDetail.setEnabled(true);
        customUserDetail.setAccountNonExpired(true);
        customUserDetail.setCredentialsNonExpired(true);
        customUserDetail.setAccountNonLocked(true);

        return customUserDetail;
    }
}
