package model.meta;

public interface InternalFeeMssgs {
    void accept(InternalFeeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface InternalFeeDOWNMssgs extends Mssgs, InternalFeeMssgs{}
interface InternalFeeUPMssgs extends Mssgs, InternalFeeMssgs{}
