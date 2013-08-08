package model.meta;

public interface NotSuccessfulStateMssgs {
    void accept(NotSuccessfulStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface NotSuccessfulStateDOWNMssgs extends DebitTransferStateDOWNMssgs, NotSuccessfulStateMssgs{}
interface NotSuccessfulStateUPMssgs extends Mssgs, NotSuccessfulStateMssgs{}
