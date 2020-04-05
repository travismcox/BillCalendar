/**
 * 
 */
package main;

/**
 * @author traviscox
 *
 */
public class CollectionOfListCollections {

	private ListCollection billListCollection;
	private ListCollection incomeListCollection;
	public CollectionOfListCollections() {
		initializeCollections();
	}
	private void initializeCollections() {
		billListCollection = new ListCollection();
		incomeListCollection = new ListCollection();
	}
	/**
	 * @return the billListCollection
	 */
	public ListCollection getBillListCollection() {
		return billListCollection;
	}
	/**
	 * @param billListCollection the billListCollection to set
	 */
	public void setBillListCollection(ListCollection billListCollection) {
		this.billListCollection = billListCollection;
	}
	/**
	 * @return the incomeListCollection
	 */
	public ListCollection getIncomeListCollection() {
		return incomeListCollection;
	}
	/**
	 * @param incomeListCollection the incomeListCollection to set
	 */
	public void setIncomeListCollection(ListCollection incomeListCollection) {
		this.incomeListCollection = incomeListCollection;
	}
	
	
}
