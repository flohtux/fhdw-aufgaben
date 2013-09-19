package model.meta;

public interface AllCompensationListeMssgsVisitor extends AllCompensationListeDOWNMssgsVisitor, AllCompensationListeUPMssgsVisitor {}


interface AllCompensationListeDOWNMssgsVisitor  {

    public void handleAllCompensationListeSignalChangesMssg(AllCompensationListeSignalChangesMssg event) throws persistence.PersistenceException;
    
}


interface AllCompensationListeUPMssgsVisitor  {

    public void handleAllCompensationListeSignalChangesMssg(AllCompensationListeSignalChangesMssg event) throws persistence.PersistenceException;
    
}
