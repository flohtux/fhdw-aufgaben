package model.meta;

public interface CompensationListeMssgsVisitor extends CompensationListeDOWNMssgsVisitor, CompensationListeUPMssgsVisitor {}


interface CompensationListeDOWNMssgsVisitor  {

    public void handleCompensationListeAddCompensationMssg(CompensationListeAddCompensationMssg event) throws persistence.PersistenceException;
    public void handleCompensationListeRemoveCompensationMssg(CompensationListeRemoveCompensationMssg event) throws persistence.PersistenceException;
    
}


interface CompensationListeUPMssgsVisitor  {

    public void handleCompensationListeAddCompensationMssg(CompensationListeAddCompensationMssg event) throws persistence.PersistenceException;
    public void handleCompensationListeRemoveCompensationMssg(CompensationListeRemoveCompensationMssg event) throws persistence.PersistenceException;
    
}
