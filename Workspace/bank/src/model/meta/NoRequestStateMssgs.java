package model.meta;

public interface NoRequestStateMssgs {
    void accept(NoRequestStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface NoRequestStateDOWNMssgs extends StornoStateDOWNMssgs, NoRequestStateMssgs{}
interface NoRequestStateUPMssgs extends Mssgs, NoRequestStateMssgs{}
