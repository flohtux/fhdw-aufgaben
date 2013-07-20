package model.meta;

public interface ExecutedStateMssgs {
    void accept(ExecutedStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ExecutedStateDOWNMssgs extends DebitNoteTransferStateDOWNMssgs, ExecutedStateMssgs{}
interface ExecutedStateUPMssgs extends Mssgs, ExecutedStateMssgs{}
