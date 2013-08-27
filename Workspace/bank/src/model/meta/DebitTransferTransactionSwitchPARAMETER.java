package model.meta;

public interface DebitTransferTransactionSwitchPARAMETER{
    persistence.PersistentTransaction handleTransaction() throws persistence.PersistenceException;
    persistence.PersistentTransfer handleTransfer() throws persistence.PersistenceException;
    persistence.PersistentDebit handleDebit() throws persistence.PersistenceException;
}
