/**
 *
 * 这仅仅只是一个开头。。。
 *
 * */

package tc.valencybuild;

import java.util.*;
import java.util.regex.*;

/**
 *
 * */
public class Program {

	public static void main(String[] args)

	{
		System.out.println("Valency Build Hydrogen");

	}

	static String parse(String input){


		Map<String, String> variables = new HashMap<>();
		variables.put("CONST", "value"); 


		String regex = "\\$\\((\\w+)\\)";

		Pattern pattern = Pattern.compile(regex);


		Matcher matcher = pattern.matcher(input);
		StringBuffer sb = new StringBuffer();

		while (matcher.find()) {

			String varName = matcher.group(1);
			String replacement = variables.getOrDefault(varName, matcher.group(0));
			matcher.appendReplacement(sb, replacement);
		}


		matcher.appendTail(sb);


		return sb.toString();
	}
}
