package model.meta;

public interface LimitTypeMssgs {
    void accept(LimitTypeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface LimitTypeDOWNMssgs extends Mssgs, LimitTypeMssgs{}
interface LimitTypeUPMssgs extends NoLimitUPMssgs, LimitUPMssgs, LimitTypeMssgs{}
