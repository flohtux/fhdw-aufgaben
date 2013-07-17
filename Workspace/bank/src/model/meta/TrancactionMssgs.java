package model.meta;

public interface TrancactionMssgs {
    void accept(TrancactionMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface TrancactionDOWNMssgs extends DebitNoteTransactionDOWNMssgs, TrancactionMssgs{}
interface TrancactionUPMssgs extends Mssgs, TrancactionMssgs{}
