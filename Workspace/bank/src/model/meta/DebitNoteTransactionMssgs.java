package model.meta;

public interface DebitNoteTransactionMssgs {
    void accept(DebitNoteTransactionMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface DebitNoteTransactionDOWNMssgs extends Mssgs, DebitNoteTransactionMssgs{}
interface DebitNoteTransactionUPMssgs extends DebitNoteUPMssgs, TrancactionUPMssgs, DebitNoteTransactionMssgs{}
