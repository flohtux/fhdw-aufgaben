package model.meta;

public interface SuccessfullStateMssgs {
    void accept(SuccessfullStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface SuccessfullStateDOWNMssgs extends DebitNoteTransferStateDOWNMssgs, SuccessfullStateMssgs{}
interface SuccessfullStateUPMssgs extends Mssgs, SuccessfullStateMssgs{}
