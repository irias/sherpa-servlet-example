package nl.irias;

import java.lang.reflect.Field;

import nl.irias.sherpa.*;

public abstract class SherpaDocHelper {
	public static void describeData(SherpaDoc doc, String sectionName, Class<?>... classes) throws Exception {
		SherpaDoc d = getDoc(doc, sectionName);
		if (d == null) {
			throw new Exception("missing section "+sectionName);
		}

		String s = "\n\n## Data\n\nBelow you'll find the data structures used in the functions of this section.\n";

		for (Class<?> cl : classes) {
			String name = friendlyName(cl.getName());
			s += "\n### " + name + "\n\n";
			for (Field f : cl.getFields()) {
				s += String.format("- `%s`: %s\n", f.getName(), friendlyName(f.getGenericType().getTypeName()));
			}
		}
		d.text += s
			.replace("&", "&amp;")
			.replace("\"", "&quot;")
			.replace("<", "&lt;")
			.replace(">", "&gt;");
	}

	public static String friendlyName(String name) {
		String r  = name.replaceAll("[a-zA-Z0-9]+\\.", "");
		switch (r) {
		default:
			break;

		case "Byte":
		case "Short":
		case "Integer":
		case "Long":
		case "Float":
		case "Double":
		case "Character":
		case "Boolean":
		case "String":
			r = r.toLowerCase();
			break;
		}

		return r;
	}

	public static SherpaDoc getDoc(SherpaDoc doc, String sectionName) {
		if (doc.title.equals(sectionName)) {
			return doc;
		}
		for (SherpaDoc section : doc.sections) {
			section = getDoc(section, sectionName);
			if (section != null) {
				return section;
			}
		}
		return null;
	}
}
