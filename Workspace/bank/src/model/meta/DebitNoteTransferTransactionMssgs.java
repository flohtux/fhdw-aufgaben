package model.meta;

public interface DebitNoteTransferTransactionMssgs {
    void accept(DebitNoteTransferTransactionMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface DebitNoteTransferTransactionDOWNMssgs extends Mssgs, DebitNoteTransferTransactionMssgs{}
interface DebitNoteTransferTransactionUPMssgs extends DebitNoteTransferUPMssgs, TransactionUPMssgs, DebitNoteTransferTransactionMssgs{}
