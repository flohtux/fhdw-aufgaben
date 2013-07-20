package model.meta;

public interface DebitNoteTransferMssgs {
    void accept(DebitNoteTransferMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface DebitNoteTransferDOWNMssgs extends DebitNoteTransferTransactionDOWNMssgs, DebitNoteTransferMssgs{}
interface DebitNoteTransferUPMssgs extends DebitNoteUPMssgs, TransferUPMssgs, DebitNoteTransferMssgs{}
