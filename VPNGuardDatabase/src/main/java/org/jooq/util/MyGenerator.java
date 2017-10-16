package org.jooq.util;

import java.util.List;

import org.jooq.EnumType;
import org.jooq.Schema;
import org.jooq.util.postgres.PostgresDatabase;

public class MyGenerator extends JavaGenerator {
	public MyGenerator() {
	}

	@Override
	protected void generateEnum(EnumDefinition e, JavaWriter out) {
		String className = getStrategy().getJavaClassName(e, GeneratorStrategy.Mode.ENUM);
		List<String> interfaces = out.ref(getStrategy().getJavaClassImplements(e, GeneratorStrategy.Mode.ENUM));
		this.printPackage(out, e);
		generateEnumClassJavadoc(e, out);
		printClassAnnotations(out, e.getSchema());
		interfaces.add(out.ref(EnumType.class));
		out.println("public enum %s[[before= implements ][%s]] {", new Object[] { className, interfaces });
		List<String> literals = e.getLiterals();
		for (int i = 0; i < literals.size(); ++i) {
			String literal = literals.get(i);
			String terminator = i == literals.size() - 1 ? ";" : ",";
			String identifier = GenerationUtil.convertToIdentifier(literal, language);
			if (identifier.equals(getStrategy().getJavaPackageName(e).replaceAll("\\..*", ""))) {
				identifier = identifier + "_";
			}
			if (identifier.equals("_"))
				identifier = "NONE";
			out.println();
			out.tab(1).println("%s(\"%s\")%s", new Object[] { identifier, literal, terminator });
		}
		out.println();
		out.tab(1).println("private final %s literal;", new Object[] { String.class });
		out.println();
		out.tab(1).println("private %s(%s literal) {", new Object[] { className, String.class });
		out.tab(2).println("this.literal = literal;");
		out.tab(1).println("}");
		out.tab(1).overrideInherit();
		out.tab(1).println("public %s getSchema() {", new Object[] { Schema.class });
		Object[] arrobject = new Object[1];
		arrobject[0] = e.isSynthetic() || !(e.getDatabase() instanceof PostgresDatabase) ? "null"
				: out.ref(getStrategy().getFullJavaIdentifier(e.getSchema()), 2);
		out.tab(2).println("return %s;", arrobject);
		out.tab(1).println("}");
		out.tab(1).overrideInherit();
		out.tab(1).println("public %s getName() {", new Object[] { String.class });
		Object[] arrobject2 = new Object[1];
		arrobject2[0] = e.isSynthetic() ? "null" : "\"" + e.getName().replace("\"", "\\\"") + "\"";
		out.tab(2).println("return %s;", arrobject2);
		out.tab(1).println("}");
		out.tab(1).overrideInherit();
		out.tab(1).println("public %s getLiteral() {", new Object[] { String.class });
		out.tab(2).println("return literal;");
		out.tab(1).println("}");
		generateEnumClassFooter(e, out);
		out.println("}");
	}

}
