package model.meta;

public interface StateMssgs {
    void accept(StateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface StateDOWNMssgs extends Mssgs, StateMssgs{}
interface StateUPMssgs extends NotCachedUPMssgs, CachedUPMssgs, StateMssgs{}
