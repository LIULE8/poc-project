package com.poc.tenant.repository;

import com.poc.tenant.model.Address;
import com.poc.tenant.model.Company;
import com.poc.tenant.model.FieldAssociation;
import com.poc.tenant.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserRepositoryTest {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private AddressRepository addressRepository;
  @Autowired
  private CompanyRepository companyRepository;
  @Autowired
  private FieldAssociationRepository fieldAssociationRepository;

  @Test
  @Transactional
  @Rollback(false)
  public void create_user1() {

    Company c1 = new Company();
    c1.setCompanyName("cccc");
    companyRepository.save(c1);

    FieldAssociation f1 = new FieldAssociation();
    f1.setAssociateId("1");
    f1.setName("asso1111");
    fieldAssociationRepository.save(f1);

    Address a1 = new Address();
    a1.setCity("珠海");
    a1.setArea("香洲");
    Set<Address> addresses = new HashSet<>();
    addresses.add(a1);
    User d2 = new User();
    d2.setName("ss");
    d2.setAge(1001);
    d2.setAddresses(addresses);
    d2.setAssociateId(f1.getAssociateId());
    d2.setCompany(c1);
    addresses.forEach(a -> a.setUser(d2));
    userRepository.save(d2);
  }

  @Test
  @Transactional
  @Rollback(false)
  public void create_user2() {

    Company c2 = new Company();
    c2.setCompanyName("xxxxx");
    companyRepository.save(c2);

    FieldAssociation f1 = new FieldAssociation();
    f1.setAssociateId("2");
    f1.setName("asso2222");
    fieldAssociationRepository.save(f1);

    Address a1 = new Address();
    a1.setCity("佛山");
    a1.setArea("南海");
    a1.setTenantID("789");
    Address a2 = new Address();
    a2.setCity("广州");
    a2.setArea("天河");
    a2.setTenantID("789");
    Set<Address> addresses = new HashSet<>();
    addresses.add(a1);
    addresses.add(a2);
    User d2 = new User();
    d2.setName("leo");
    d2.setAge(11);
    d2.setAddresses(addresses);
    d2.setAssociateId(f1.getAssociateId());
    d2.setTenantID("789");
    d2.setCompany(c2);
    addresses.forEach(a -> a.setUser(d2));
    userRepository.save(d2);
  }

  @Test
  public void should_6() {
    List<User> all = userRepository.findAll();
    log.info("666: " + all.size());
    log.info("666: " + all);
  }

  @Test
  public void should_7() {
    List<User> byNameLike = userRepository.findByNameLike("%ss%");
    log.info("777: " + byNameLike.size());
    log.info("777: " + byNameLike);
  }

  @Test
  @Transactional
  @Rollback(false)
  public void should_delete() {
    addressRepository.deleteAll();
    companyRepository.deleteAll();
    userRepository.deleteAll();
  }


  @Test
  @Transactional
  @Rollback(false)
  public void should_8() {
    Optional<User> userOptional = userRepository.findById(2);
    userOptional.ifPresent(user -> user.setName("修改save"));
  }


  @Test
  @Transactional
  @Rollback(false)
  public void should_9() {
     userRepository.updateName("save");
  }

  @Test
  public void should_10() {
    List<User> all = userRepository.findByName("%s%");
    log.info("1010: " + all.size());
    log.info("1010: " + all);
  }

}
