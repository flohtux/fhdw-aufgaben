package model.meta;

public interface MaterialMssgs {
    void accept(MaterialMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MaterialDOWNMssgs extends ComponentDOWNMssgs, MaterialMssgs{}
interface MaterialUPMssgs extends Mssgs, MaterialMssgs{}
