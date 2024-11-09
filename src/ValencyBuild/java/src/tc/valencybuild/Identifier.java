package tc.valencybuild;

import java.util.regex.Pattern;

public class Identifier {
	private static final Pattern VALID_IDENTIFIER_PATTERN = Pattern.compile("^[a-zA-Z_$][a-zA-Z_$0-9]*$");
	private String name;

	public Identifier(String name) {
		if (isValidIdentifier(name)) {
			throw new IllegalArgumentException("Invalid identifier name: " + name);
		}
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (isValidIdentifier(name)) {
			throw new IllegalArgumentException("Invalid identifier name: " + name);
		}
		this.name = name;
	}

	private boolean isValidIdentifier(String name) {
		return !VALID_IDENTIFIER_PATTERN.matcher(name).matches() || isJavaKeyword(name);
	}

	private boolean isJavaKeyword(String name) {

		String[] keywords = {
				"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const",
				"continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float",
				"for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native",
				"new", "package", "private", "protected", "public", "return", "short", "static", "strictfp",
				"super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void",
				"volatile", "while"
		};
		for (String keyword : keywords) {
			if (keyword.equals(name)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return name;
	}
}
