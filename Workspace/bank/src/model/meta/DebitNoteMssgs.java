package model.meta;

public interface DebitNoteMssgs {
    void accept(DebitNoteMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface DebitNoteDOWNMssgs extends DebitNoteTransferDOWNMssgs, DebitNoteMssgs{}
interface DebitNoteUPMssgs extends Mssgs, DebitNoteMssgs{}
