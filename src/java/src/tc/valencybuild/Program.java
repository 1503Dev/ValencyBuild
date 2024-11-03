/**
 * 这仅仅只是一个开头。。。
 */

package tc.valencybuild;

import java.io.File;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class Program {

	static String versionInfo = "Hydrogen (JavaSE Edition) [24h44b]";

	public static void main(String[] args) {
		System.out.printf("Valency Build - %s\n", versionInfo);
		try{
			// .Buildfile 检查
			File buildfile = new File(".", ".Buildfile");
			File makefile = new File(".", "Makefile");
			if (buildfile.exists()) {
				System.out.print("VMake : 在本目录找到了.Buildfile，正在使用它作为构建文件\n");
				if (makefile.exists()) {
					System.out.print("VMake : 在本目录找到了Makefile，正在使用它作为构建文件\n");
					System.out.println("VMake : 由于此目录同时存在 'Makefile' 与 '.Buildfile' ， 将优先使用 '.Buildfile'");
				}
			}
			else {
				System.out.print("VMake : 本目录没有 'Makefile' 或是 '.Buildfile'\n");
			}

			if (args.length == 0) {
				System.out.println("用法： java -jar vb.jar <FunctionName> <args...>");
			}
		}catch(IndexOutOfBoundsException e){
			System.out.println("命令语法不正确。");
			System.exit(-1);
		}
	}

}
