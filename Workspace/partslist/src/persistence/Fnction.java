package persistence;

import model.UserException;

public interface Fnction<Domain, Codomain> {
	public Codomain apply(Domain d) throws PersistenceException, UserException;
}
