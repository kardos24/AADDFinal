package tags;

import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;
import javax.servlet.jsp.tagext.VariableInfo;

public class VarCatalogosTagTEI extends TagExtraInfo {
	public VariableInfo[] getVariableInfo(TagData data) {
		return new VariableInfo[] {
				new VariableInfo("nombre", "java.lang.String", true,
						VariableInfo.NESTED),
				new VariableInfo("web", "java.lang.String", true,
						VariableInfo.NESTED)};
	}
}
