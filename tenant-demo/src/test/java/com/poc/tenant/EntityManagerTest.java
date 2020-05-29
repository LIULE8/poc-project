package com.poc.tenant;

import com.poc.tenant.model.*;
import com.poc.tenant.result.MultipulSelectResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.criteria.*;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class EntityManagerTest {
  @Autowired
  private EntityManager entityManager;

  /**
   * 测试从子表出发，是否触发父表的@where
   *
   * <p>父表不触发，自己有的话会触发
   */
  @Test
  public void should_1() {
    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Address> query = builder.createQuery(Address.class);
    Root<Address> root = query.from(Address.class);
    Join<Address, User> userJoin = root.join(Address_.user, JoinType.INNER);
//    query.where(builder.like(userJoin.get(User_.name), "%s%"));
    List<Address> resultList = entityManager.createQuery(query).getResultList();
    log.info("result: " + resultList.size());
    log.info("result: " + resultList);
  }

  /** native sql 测试从子表出发，是否触发父表的@where -- 父表不触发，自己也不触发 */
  @Test
  public void should_3() {
    List resultList =
        entityManager.createNativeQuery("select * from address", Tuple.class).getResultList();
    log.info("result: " + resultList.size());
  }

  /**
   * user表有@where， 会触发
   */
  @Test
  public void should_2() {
    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<MultipulSelectResult> query = builder.createQuery(MultipulSelectResult.class);
    Root<FieldAssociation> fRoot = query.from(FieldAssociation.class);
    Root<User> uRoot = query.from(User.class);
    query.where(
        builder.equal(fRoot.get(FieldAssociation_.associateId), uRoot.get(User_.associateId)));
    query.multiselect(
        uRoot.get(User_.id).alias("userId"),
        uRoot.get(User_.name).alias("userName"),
        uRoot.get(User_.age),
        uRoot.get(User_.associateId),
        fRoot.get(FieldAssociation_.name).alias("fieldName"));
    List<MultipulSelectResult> resultList = entityManager.createQuery(query).getResultList();
    log.info("result: " + resultList.size());
    log.info("result: " + resultList);
  }


  @Test
  @Transactional
  @Rollback(false)
  public void should_4() {
    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaUpdate<User> update = builder.createCriteriaUpdate(User.class);
    Root<User> root = update.from(User.class);
    update.where(builder.equal(root.get(User_.name), "leo"));
    update.set(root.get(User_.name), "修改save");
    entityManager.createQuery(update).executeUpdate();
  }


  @Test
  @Transactional
  @Rollback(false)
  public void should_5() {
    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Long> query = builder.createQuery(Long.class);
    Root<User> root = query.from(User.class);
    query.select(builder.count(root));
    Long singleResult = entityManager.createQuery(query).getSingleResult();
    System.out.println(singleResult);
  }
}
