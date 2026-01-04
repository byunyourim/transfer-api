package project.transferapi.repository.account;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import project.transferapi.domain.account.Account;
import project.transferapi.domain.account.AccountId;

public interface AccountJPARepository extends CrudRepository<Account, AccountId> {
    @Query( value = "SELECT :dateTime || LPAD(PRODUCT_SEQ.NEXTVAL, '4', '0') FROM DUAL", nativeQuery = true )
    Long nextId( @Param("dateTime") String dateTime );
}
