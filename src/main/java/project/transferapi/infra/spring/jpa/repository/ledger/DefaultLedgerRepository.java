package project.transferapi.infra.spring.jpa.repository.ledger;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import project.transferapi.application.DateUtil;
import project.transferapi.domain.ledger.Ledger;
import project.transferapi.domain.ledger.LedgerId;
import project.transferapi.domain.ledger.LedgerRepository;

@Repository
@RequiredArgsConstructor
public class DefaultLedgerRepository implements LedgerRepository {
    private final LedgerJPARepository repository;

    /**
     * 원장 ID 조회
     * @return LedgerId
     */
    @Override
    public LedgerId nextId() {
        return LedgerId.of(repository.nextId(DateUtil.nowSequenceDateTimeString()));
    }

    /**
     * 원장 저장
     * @param ledger 원장 정보
     * @return Ledger
     */
    @Override
    public Ledger save(Ledger ledger) {
        return repository.save(ledger);
    }
}
