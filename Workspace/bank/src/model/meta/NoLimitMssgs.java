package model.meta;

public interface NoLimitMssgs {
    void accept(NoLimitMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface NoLimitDOWNMssgs extends LimitTypeDOWNMssgs, NoLimitMssgs{}
interface NoLimitUPMssgs extends Mssgs, NoLimitMssgs{}
