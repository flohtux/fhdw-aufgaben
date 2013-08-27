package model.meta;

public interface NotExecutedStateMssgs {
    void accept(NotExecutedStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface NotExecutedStateDOWNMssgs extends DebitTransferStateDOWNMssgs, NotExecutedStateMssgs{}
interface NotExecutedStateUPMssgs extends Mssgs, NotExecutedStateMssgs{}
