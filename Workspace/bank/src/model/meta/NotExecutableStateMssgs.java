package model.meta;

public interface NotExecutableStateMssgs {
    void accept(NotExecutableStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface NotExecutableStateDOWNMssgs extends DebitNoteTransferStateDOWNMssgs, NotExecutableStateMssgs{}
interface NotExecutableStateUPMssgs extends Mssgs, NotExecutableStateMssgs{}
