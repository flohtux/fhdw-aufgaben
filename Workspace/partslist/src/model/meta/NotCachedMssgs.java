package model.meta;

public interface NotCachedMssgs {
    void accept(NotCachedMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface NotCachedDOWNMssgs extends StateDOWNMssgs, NotCachedMssgs{}
interface NotCachedUPMssgs extends Mssgs, NotCachedMssgs{}
