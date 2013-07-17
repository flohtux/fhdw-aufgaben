package model.meta;

public interface ComponentMssgsVisitor extends ComponentDOWNMssgsVisitor, ComponentUPMssgsVisitor {}


interface ComponentDOWNMssgsVisitor extends ProductDOWNMssgsVisitor, MaterialDOWNMssgsVisitor {

    
}


interface ComponentUPMssgsVisitor  {

    
}
