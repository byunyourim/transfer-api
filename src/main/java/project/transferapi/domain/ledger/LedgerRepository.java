package project.transferapi.domain.ledger;

public interface LedgerRepository {
    LedgerId nextId();

    Ledger save(Ledger ledger);
}