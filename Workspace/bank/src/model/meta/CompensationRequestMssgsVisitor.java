package model.meta;

public interface CompensationRequestMssgsVisitor extends CompensationRequestDOWNMssgsVisitor, CompensationRequestUPMssgsVisitor {}


interface CompensationRequestDOWNMssgsVisitor  {

    public void handleCompensationRequestChangeStateCompensationRequestStateMssg(CompensationRequestChangeStateCompensationRequestStateMssg event) throws persistence.PersistenceException;
    
}


interface CompensationRequestUPMssgsVisitor  {

    public void handleCompensationRequestChangeStateCompensationRequestStateMssg(CompensationRequestChangeStateCompensationRequestStateMssg event) throws persistence.PersistenceException;
    
}
