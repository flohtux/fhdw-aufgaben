package model.meta;

public interface LimitMssgs {
    void accept(LimitMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface LimitDOWNMssgs extends LimitTypeDOWNMssgs, LimitMssgs{}
interface LimitUPMssgs extends Mssgs, LimitMssgs{}
