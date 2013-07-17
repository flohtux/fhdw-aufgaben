package persistence;

import java.util.Iterator;
import java.util.Vector;
import java.util.HashMap;

import model.UserException;

public abstract class SearchListRoot<T extends AbstractPersistentRoot> {

	static public class DecoratorIterator<U> implements java.util.Iterator<U> {
		private Iterator<? extends persistence.Decoratees> internalIterator;
		public DecoratorIterator(java.util.Iterator<? extends persistence.Decoratees> internalIterator){
			this.internalIterator = internalIterator;
		}
		public boolean hasNext() {
			return this.internalIterator.hasNext();
		}
		@SuppressWarnings("unchecked")
		public U next() {
			return (U) this.internalIterator.next().createDecorator();
		}
		public void remove() {
			this.internalIterator.remove();
		}
	}


	protected Vector<T> data;

	protected SearchListRoot(){
		this.data = new Vector<T>();
	}
	protected SearchListRoot(SearchListRoot<T> list){
		this.data = list.data;
	}
	public void add (T entry) throws PersistenceException, UserException {
		this.data.add(entry);
	}
	public void add(SearchListRoot<T> list) throws PersistenceException, UserException{
		java.util.Iterator<T> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public void addUnique (T entry) throws PersistenceException, UserException {
		if (this.data.contains(entry)) return;
		this.data.add(entry);
	}
	public void addUnique(SearchListRoot<T> list) throws PersistenceException, UserException {
		java.util.Iterator<T> entries = list.iterator();
		while (entries.hasNext()){
			this.addUnique(entries.next());
		}
	}
	public long getLength() throws PersistenceException{
		return this.data.size();
	}
	public Iterator<T> iterator() throws PersistenceException {
		return data.iterator();
	}
	public T findFirst (persistence.Predcate<T> predicate) throws PersistenceException{
		Iterator<T> i = this.iterator();
		while (i.hasNext()){
			T current = i.next();
			if (predicate.test(current)) return current;
		}
		return null;
	}
	public SearchListRoot<T> findAll (persistence.Predcate<T> predicate) throws PersistenceException{
		SearchListRoot<T> result = new SearchListRoot<T>(){};
		Iterator<T> i = this.iterator();
		while (i.hasNext()){
			T current = i.next();
			if (predicate.test(current)) result.data.add(current);
		}
		return result;
	}
	public void filter (persistence.Predcate<T> predicate) throws PersistenceException{
		Iterator<T> i = this.iterator();
		while (i.hasNext()){
			T current = i.next();
			if (!predicate.test(current)) i.remove();
		}
	}
	public void removeFirstFailure (persistence.Predcate<T> predicate) throws PersistenceException{
		Iterator<T> i = this.iterator();
		while (i.hasNext()){
			T current = i.next();
			if (!predicate.test(current)) {
				i.remove();
				return;
			}
		}
	}
	public void removeFirstSuccess (persistence.Predcate<T> predicate) throws PersistenceException{
		Iterator<T> i = this.iterator();
		while (i.hasNext()){
			T current = i.next();
			if (predicate.test(current)) {
				i.remove();
				return;
			}
		}
	}
	public void applyToAll (persistence.Procdure<T> procedure) throws PersistenceException{
		Iterator<T> i = this.iterator();
		while (i.hasNext()){
			T current = i.next();
			procedure.doItTo(current);
		}
	}
	public <R> R aggregate (persistence.Aggregtion<T,R> aggregation) throws PersistenceException{
		R result = aggregation.neutral();
		Iterator<T> i = this.iterator();
		while (i.hasNext()){
			T current = i.next();
			result = aggregation.compose(result,current);
		}
		return result;
	}
	public <E extends model.UserException> T findFirstException (persistence.PredcateException<T, E> predicate) throws PersistenceException, E{
		Iterator<T> i = this.iterator();
		while (i.hasNext()){
			T current = i.next();
			if (predicate.test(current)) return current;
		}
		return null;
	}
	public <E extends model.UserException> SearchListRoot<T> findAllException (persistence.PredcateException<T, E> predicate) throws PersistenceException, E{
		SearchListRoot<T> result = new SearchListRoot<T>(){};
		Iterator<T> i = this.iterator();
		while (i.hasNext()){
			T current = i.next();
			if (predicate.test(current)) result.data.add(current);
		}
		return result;
	}
	public <E extends model.UserException> void filterException (persistence.PredcateException<T, E> predicate) throws PersistenceException, E{
		Iterator<T> i = this.iterator();
		while (i.hasNext()){
			T current = i.next();
			if (!predicate.test(current)) i.remove();
		}
	}
	public <E extends model.UserException> void removeFirstFailureException (persistence.PredcateException<T, E> predicate) throws PersistenceException, E{
		Iterator<T> i = this.iterator();
		while (i.hasNext()){
			T current = i.next();
			if (!predicate.test(current)){
				i.remove();
				return;
			}
		}
	}
	public <E extends model.UserException> void removeFirstSuccessException (persistence.PredcateException<T, E> predicate) throws PersistenceException, E{
		Iterator<T> i = this.iterator();
		while (i.hasNext()){
			T current = i.next();
			if (predicate.test(current)){
				i.remove();
				return;
			}
		}
	}
	public <E extends model.UserException> void applyToAllException (persistence.ProcdureException<T, E> procedure) throws PersistenceException, E{
		Iterator<T> i = this.iterator();
		while (i.hasNext()){
			T current = i.next();
			procedure.doItTo(current);
		}
	}
	public <R,E extends model.UserException> R aggregateException (persistence.AggregtionException<T,R, E> aggregation) throws PersistenceException, E{
		R result = aggregation.neutral();
		Iterator<T> i = this.iterator();
		while (i.hasNext()){
			T current = i.next();
			result = aggregation.compose(result,current);
		}
		return result;
	}
	public <R extends AbstractPersistentRoot> SearchListRoot<R> productFunction (Fnction<T,R> function, boolean unique) throws PersistenceException, UserException{
		SearchListRoot<R> result = new SearchListRoot<R>(){};
		Iterator<T> entries = this.iterator();
		while (entries.hasNext()){
			T current = entries.next();
			R value = function.apply(current);
			if (value != null){
				if (unique) result.addUnique(value);
				else result.add(value);				
			}
		}
		return result;
	}
	public <R extends AbstractPersistentRoot> SearchListRoot<R> productMultiValuedFunction (Fnction<T, SearchListRoot<R>> function, boolean unique) throws PersistenceException, UserException{
		SearchListRoot<R> result = new SearchListRoot<R>(){};
		Iterator<T> entries = this.iterator();
		while (entries.hasNext()){
			T current = entries.next();
			SearchListRoot<R> value = function.apply(current);
			if (unique) result.addUnique(value); 
			else result.add(value);
		}
		return result;
	}
	public Vector<String> getVector(int depth, int essentialLevel, boolean forGUI, TDObserver tdObserver, boolean asLeaf, boolean withLeafInfo) throws PersistenceException{
		return this.getVector(new HashMap<String, Object>(), depth, essentialLevel, forGUI, tdObserver, asLeaf, withLeafInfo);
	}
	public Vector<String> getVector(java.util.HashMap<String, Object> allResults, int depth, int essentialLevel, boolean forGUI, TDObserver tdObserver, boolean asLeaf, boolean withLeafInfo) throws PersistenceException {
		Vector<String> result = new Vector<String>();
		Iterator<T> entries = this.iterator();
		while (entries.hasNext()){
			T current = entries.next();
			if (!asLeaf && depth > 1){
				current.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
			}else{
				if (forGUI && current.hasEssentialFields())
					current.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
			}
			result.add(current.createProxiInformation(asLeaf, withLeafInfo));
		}
		return result;
	}

	/*@SuppressWarnings("unchecked")
	public Vector<HashMap> getVector(int depth) throws PersistenceException {
		Vector<HashMap> result = new Vector<HashMap>();
		Iterator<T> entries = this.iterator();
		while (entries.hasNext()){
			AbstractPersistentRoot current = entries.next();
			long currentId = current.getId();
			long currentClassId = current.getClassId();
			HashMap<String,Object> hashtableEntry = new HashMap<String,Object>();
			if (depth == 0) {
				hashtableEntry.put("id", new Long(currentId).toString());
				hashtableEntry.put("classId", new Long(currentClassId).toString());
			}else{
				hashtableEntry = PersistentProxi.createProxi(currentId, currentClassId).toHashtable(depth - 1);
			}
			result.add(hashtableEntry);
		}
		return result;
	}*/
}
