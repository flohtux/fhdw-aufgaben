package model.meta;

public interface CompensationStateMssgs {
    void accept(CompensationStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface CompensationStateDOWNMssgs extends Mssgs, CompensationStateMssgs{}
interface CompensationStateUPMssgs extends WaitingCompensationStateUPMssgs, SuccessfulCompensationStateUPMssgs, DeclinedCompensationStateUPMssgs, CompensationStateMssgs{}
