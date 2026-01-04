package project.transferapi.repository;

import com.querydsl.jpa.JPQLTemplates;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JPAFactoryConfig {
    @PersistenceContext
    private EntityManager em;

    @Bean
    public JPAQueryFactory setJPAQueryFactory() {
        return new JPAQueryFactory(JPQLTemplates.DEFAULT, em );
    }
}
