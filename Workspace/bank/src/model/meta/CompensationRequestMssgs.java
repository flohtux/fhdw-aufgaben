package model.meta;

public interface CompensationRequestMssgs {
    void accept(CompensationRequestMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface CompensationRequestDOWNMssgs extends Mssgs, CompensationRequestMssgs{}
interface CompensationRequestUPMssgs extends Mssgs, CompensationRequestMssgs{}
