package com.poc.tenant.repository;

import com.poc.tenant.model.Company;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void should_8() {
        // 如果不在子表中加，用子表查询，不会加条件
        List<Company> all = companyRepository.findAll();
        log.info("888: " + all.size());
        log.info("888: " + all);
    }
}
