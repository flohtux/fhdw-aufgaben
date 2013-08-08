package model.meta;

public interface SuccessfulStornoStateMssgs {
    void accept(SuccessfulStornoStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface SuccessfulStornoStateDOWNMssgs extends StornoStateDOWNMssgs, SuccessfulStornoStateMssgs{}
interface SuccessfulStornoStateUPMssgs extends Mssgs, SuccessfulStornoStateMssgs{}
