package model.meta;

public interface RequestStateMssgs {
    void accept(RequestStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface RequestStateDOWNMssgs extends StornoStateDOWNMssgs, RequestStateMssgs{}
interface RequestStateUPMssgs extends Mssgs, RequestStateMssgs{}
