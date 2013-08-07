package model.meta;

public interface NotExecutableStateMssgs {
    void accept(NotExecutableStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface NotExecutableStateDOWNMssgs extends DebitTransferStateDOWNMssgs, NotExecutableStateMssgs{}
interface NotExecutableStateUPMssgs extends Mssgs, NotExecutableStateMssgs{}
