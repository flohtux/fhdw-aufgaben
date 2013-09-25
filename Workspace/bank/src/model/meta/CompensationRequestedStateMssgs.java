package model.meta;

public interface CompensationRequestedStateMssgs {
    void accept(CompensationRequestedStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface CompensationRequestedStateDOWNMssgs extends DebitTransferStateDOWNMssgs, CompensationRequestedStateMssgs{}
interface CompensationRequestedStateUPMssgs extends Mssgs, CompensationRequestedStateMssgs{}
