package com.example.demoextendh2;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest(showSql = true)
class CityEntityTest {
    @Autowired
    private TestEntityManager em;

    @Test
    void test() {
        em.persist(new CityEntity("paris"));
        em.persist(new CityEntity("zanzibar"));
        em.persist(new CityEntity(null));

        List<CityEntity> cities = em.getEntityManager().createQuery("from CityEntity order by name").getResultList();

        Assertions.assertThat(cities)
            .extracting(CityEntity::getName)
            .containsExactly("paris", "zanzibar", null);
    }
}
