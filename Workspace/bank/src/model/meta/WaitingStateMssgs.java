package model.meta;

public interface WaitingStateMssgs {
    void accept(WaitingStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface WaitingStateDOWNMssgs extends CompensationRequestStateDOWNMssgs, WaitingStateMssgs{}
interface WaitingStateUPMssgs extends Mssgs, WaitingStateMssgs{}
