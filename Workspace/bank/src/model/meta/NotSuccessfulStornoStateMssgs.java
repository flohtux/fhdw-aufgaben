package model.meta;

public interface NotSuccessfulStornoStateMssgs {
    void accept(NotSuccessfulStornoStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface NotSuccessfulStornoStateDOWNMssgs extends StornoStateDOWNMssgs, NotSuccessfulStornoStateMssgs{}
interface NotSuccessfulStornoStateUPMssgs extends Mssgs, NotSuccessfulStornoStateMssgs{}
