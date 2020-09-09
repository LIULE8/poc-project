package com.poc.tenant.repository;

import com.leo.model.tenant.entity.Company;
import com.leo.model.tenant.repository.CompanyRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

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
