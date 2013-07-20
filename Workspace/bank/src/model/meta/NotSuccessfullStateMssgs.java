package model.meta;

public interface NotSuccessfullStateMssgs {
    void accept(NotSuccessfullStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface NotSuccessfullStateDOWNMssgs extends DebitNoteTransferStateDOWNMssgs, NotSuccessfullStateMssgs{}
interface NotSuccessfullStateUPMssgs extends Mssgs, NotSuccessfullStateMssgs{}
