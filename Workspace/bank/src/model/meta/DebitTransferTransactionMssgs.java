package model.meta;

public interface DebitTransferTransactionMssgs {
    void accept(DebitTransferTransactionMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface DebitTransferTransactionDOWNMssgs extends Mssgs, DebitTransferTransactionMssgs{}
interface DebitTransferTransactionUPMssgs extends DebitTransferUPMssgs, TransactionUPMssgs, DebitTransferTransactionMssgs{}
