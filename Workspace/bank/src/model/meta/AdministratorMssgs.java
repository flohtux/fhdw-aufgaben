package model.meta;

public interface AdministratorMssgs {
    void accept(AdministratorMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface AdministratorDOWNMssgs extends ServiceDOWNMssgs, AdministratorMssgs{}
interface AdministratorUPMssgs extends Mssgs, AdministratorMssgs{}
