package model.meta;

public interface SuccessfulCompensationStateMssgs {
    void accept(SuccessfulCompensationStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface SuccessfulCompensationStateDOWNMssgs extends CompensationStateDOWNMssgs, SuccessfulCompensationStateMssgs{}
interface SuccessfulCompensationStateUPMssgs extends Mssgs, SuccessfulCompensationStateMssgs{}
