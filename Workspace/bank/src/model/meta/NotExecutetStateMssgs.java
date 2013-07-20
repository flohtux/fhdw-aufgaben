package model.meta;

public interface NotExecutetStateMssgs {
    void accept(NotExecutetStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface NotExecutetStateDOWNMssgs extends DebitNoteTransferStateDOWNMssgs, NotExecutetStateMssgs{}
interface NotExecutetStateUPMssgs extends Mssgs, NotExecutetStateMssgs{}
