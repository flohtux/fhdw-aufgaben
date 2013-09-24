package model.meta;

public interface WaitingCompensationStateMssgs {
    void accept(WaitingCompensationStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface WaitingCompensationStateDOWNMssgs extends CompensationStateDOWNMssgs, WaitingCompensationStateMssgs{}
interface WaitingCompensationStateUPMssgs extends Mssgs, WaitingCompensationStateMssgs{}
