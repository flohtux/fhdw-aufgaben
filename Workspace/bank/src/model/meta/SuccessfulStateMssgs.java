package model.meta;

public interface SuccessfulStateMssgs {
    void accept(SuccessfulStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface SuccessfulStateDOWNMssgs extends DebitTransferStateDOWNMssgs, SuccessfulStateMssgs{}
interface SuccessfulStateUPMssgs extends Mssgs, SuccessfulStateMssgs{}
