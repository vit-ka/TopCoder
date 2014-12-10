public class NamingConvention {
	
	public String toCamelCase(String variableName) {
		String[] split = variableName.split("_");
		for (int i = 1; i < split.length; i++) {
			split[i] = Character.toUpperCase(split[i].charAt(0)) + split[i].substring(1);
		}

		return String.join("", split);
	}
}
