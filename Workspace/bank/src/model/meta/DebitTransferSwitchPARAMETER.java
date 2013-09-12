package model.meta;

public interface DebitTransferSwitchPARAMETER{
    persistence.PersistentDebit handleDebit() throws persistence.PersistenceException;
    persistence.PersistentTransfer handleTransfer() throws persistence.PersistenceException;
}
