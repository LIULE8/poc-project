package com.poc.tenant.repository;

import com.leo.model.tenant.entity.Address;
import com.leo.model.tenant.repository.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class AddressRepositoryTest {

    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void should_8() {
        // 如果不在子表中加，用子表查询，不会加条件
        List<Address> all = addressRepository.findAll();
        log.info("888: " + all.size());
        log.info("888: " + all);
    }

    @Test
    public void should_9() {
        List<Address> byAreaLike = addressRepository.findByAreaLike("%南%");
        log.info("999: " + byAreaLike.size());
        log.info("999: " + byAreaLike);
    }

}
