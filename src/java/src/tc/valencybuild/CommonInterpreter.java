package tc.valencybuild;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 解释器基础服务。
 * */
public class CommonInterpreter {
	public static String definedReplace(String input, Map<Identifier,String> map){
		String regex = "\\$\\((\\w+)\\)";

		Pattern pattern = Pattern.compile(regex);


		Matcher matcher = pattern.matcher(input);
		StringBuffer sb = new StringBuffer();

		while (matcher.find()) {

			String varName = matcher.group(1);
			String replacement = map.getOrDefault(varName, matcher.group(0));
			matcher.appendReplacement(sb, replacement);
		}


		matcher.appendTail(sb);


		return sb.toString();
	}
}
