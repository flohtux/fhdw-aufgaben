package model.meta;

public interface TransactionMssgs {
    void accept(TransactionMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface TransactionDOWNMssgs extends DebitTransferTransactionDOWNMssgs, TransactionMssgs{}
interface TransactionUPMssgs extends Mssgs, TransactionMssgs{}
