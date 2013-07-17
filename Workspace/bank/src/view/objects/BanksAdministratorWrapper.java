package view.objects;


/* Additional import section end */

public class BanksAdministratorWrapper extends AssociationInTreeWrapper {

	public BanksAdministratorWrapper(ViewRoot parent, int index, ViewRoot object) {
		super(parent, index, object);
	}
    
    /*Start of protected part that is not overridden by persistence generator*/
	    public void setIcon(IconRenderer renderer) {
    	this.getWrappedObject().setIcon(renderer);
    }
	
	
	public String toString(){
    	//TODO: Implement toString in wrapper class for association banks in class Administrator
    	return this.getWrappedObject().toString();
    }

    /*End of protected part that is not overridden by persistence generator*/

}
