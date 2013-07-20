package model.meta;

public interface TransferMssgs {
    void accept(TransferMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface TransferDOWNMssgs extends DebitNoteTransferDOWNMssgs, TransferMssgs{}
interface TransferUPMssgs extends Mssgs, TransferMssgs{}
