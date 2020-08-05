package com.poc.tenant.repository;

import com.poc.tenant.model.TestUUID;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
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
