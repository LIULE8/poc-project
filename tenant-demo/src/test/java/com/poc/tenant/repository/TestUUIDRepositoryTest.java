package com.poc.tenant.repository;

import com.leo.model.tenant.entity.TestUUID;
import com.leo.model.tenant.repository.TestUUIDRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Slf4j
public class TestUUIDRepositoryTest {

    @Autowired
    private TestUUIDRepository testUUIDRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void test2(){
        TestUUID testUUID = new TestUUID();
        testUUID.setName("1");
        testUUIDRepository.save(testUUID);
    }
}
