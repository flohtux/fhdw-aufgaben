package model.meta;

public interface TransactionFeeSwitchPARAMETER{
    persistence.PersistentMixedFee handleMixedFee() throws persistence.PersistenceException;
    persistence.PersistentFixTransactionFee handleFixTransactionFee() throws persistence.PersistenceException;
    persistence.PersistentProcentualFee handleProcentualFee() throws persistence.PersistenceException;
}
