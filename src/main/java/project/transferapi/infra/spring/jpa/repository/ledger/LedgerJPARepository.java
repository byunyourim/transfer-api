package project.transferapi.infra.spring.jpa.repository.ledger;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import project.transferapi.domain.ledger.Ledger;
import project.transferapi.domain.ledger.LedgerId;

public interface LedgerJPARepository extends CrudRepository<Ledger, LedgerId> {
    @Query(value = "SELECT :dateTime || LPAD(LEDGER_SEQ.NEXTVAL, '4', '0') FROM DUAL", nativeQuery = true)
    Long nextId(@Param("dateTime") String dateTime);
}
