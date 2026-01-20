package project.transferapi.infra.spring.jpa.generator;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class DefaultGenerator implements IdentifierGenerator {
    public static final String SEQUENCE_NAME = "sequence";

    private String query = "SELECT %s || LPAD(%s.NEXTVAL, '4', '0') FROM DUAL";

    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) {




        return null;
    }
}
