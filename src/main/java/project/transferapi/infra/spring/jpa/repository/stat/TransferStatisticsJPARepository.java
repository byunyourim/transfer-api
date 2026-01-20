package project.transferapi.infra.spring.jpa.repository.stat;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import project.transferapi.domain.stat.TransferStatistics;
import project.transferapi.domain.stat.TransferStatisticsId;

public interface TransferStatisticsJPARepository extends CrudRepository<TransferStatistics, TransferStatisticsId> {
    @Query( value = "SELECT :dateTime || LPAD(TRANSFER_STATISTICS_SEQ.NEXTVAL, '4', '0') FROM DUAL", nativeQuery = true )
    Long nextId( @Param("dateTime") String dateTime );
}
