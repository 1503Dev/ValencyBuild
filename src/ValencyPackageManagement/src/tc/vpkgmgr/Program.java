package tc.vpkgmgr;


import java.io.IOException;
import java.text.ParseException;

public class Program {

	public static void main(String[] args) throws IOException, ParseException {
		Index.update();
		return;
//		System.out.println("Valency Package Manager - Valency Build Hydrogen [1.0.0.1]");
//		if (args.length == 0){
//			displayhelp();
//			return;
//		}
//		else if (args[0].equalsIgnoreCase("help")){
//			displayhelp();
//			return;
//		}
//
//		switch (args[0].toLowerCase()){
//			case "update":
//				Index.update();
//				System.out.println("更新完成");
//		}

	}

	private static void displayhelp() {
		System.out.println("用法: vpkgmgr <命令> [参数]");
		System.out.println("命令:");
		System.out.println("  install --id <包名> --version [版本号] 安装指定的包");
		System.out.println("  remove --id <包名> --version [版本号] 卸载指定的包");
		System.out.println("  list 列出已安装的包");
		System.out.println("  search --id <包名> 搜索指定的包");
		System.out.println("  update 更新已安装的包");
		System.out.println("  help 显示帮助信息");
	}
}
