package uppaal;

import java.util.Iterator;

import org.jdom.Element;

public class Query {
	
	private String formula;
	private String comment;
	
	public Query() {
		super();
	}
	
	public Query(Element queryElement) {
		super();
		@SuppressWarnings("unchecked")
		Iterator<Element> i = queryElement.getChildren().iterator();
		while (i.hasNext()) {
			Element child = i.next();
			if (child.getName().equals("formula")) {
				this.formula = child.getValue().trim();
			} else if (child.getName().contentEquals("comment")) {
				this.comment = child.getValue().trim();
			}
		}
	}
	
	/**
	 * @return the formula
	 */
	public String getFormula() {
		return formula;
	}
	/**
	 * @param formula the formula to set
	 */
	public void setFormula(String formula) {
		this.formula = formula;
	}
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	public Element generateXMLElement() {
		Element result = new Element("query");
		
		Element formula = new Element("formula");
		formula.addContent(this.formula);
		result.addContent(formula);
		
		Element comment = new Element("comment");
		comment.addContent(this.comment);
		result.addContent(comment);
		
		return result;
	}
	
	

}
