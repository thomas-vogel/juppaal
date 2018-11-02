package uppaal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom.Element;

public class Queries {

	private List<Query> queries = new ArrayList<Query>();

	public Queries() {

	}

	public Queries(Element queriesElement) {
		@SuppressWarnings("unchecked")
		Iterator<Element> i = queriesElement.getChildren().iterator();
		while (i.hasNext()) {
			Element child = i.next();
			if (child.getName().equals("query")) {
				Query query = new Query(child);
				this.queries.add(query);
			}
		}
	}

	public List<Query> getQueries() {
		return this.queries;
	}

	public Element generateXMLElement() {
		Element result = new Element("queries");
		for (Query q : this.queries) {
			result.addContent(q.generateXMLElement());
		}
		
		return result;
	}

}
