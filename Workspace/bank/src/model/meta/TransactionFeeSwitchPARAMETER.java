package model.meta;

public interface TransactionFeeSwitchPARAMETER{
    persistence.PersistentFixTransactionFee handleFixTransactionFee() throws persistence.PersistenceException;
    persistence.PersistentMixedFee handleMixedFee() throws persistence.PersistenceException;
    persistence.PersistentProcentualFee handleProcentualFee() throws persistence.PersistenceException;
}
