package tc.vpkgmgr;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.*;

public class Index {
	public static File indexFile = new File(combine(System.getProperty("user.home"), ".valency"));
	static String github_index = "";
	static String gitee_index = "";
	public List<Package> versions;
	public Version indexVersion;
	public String mirror;
	public Date lastUpdate;

	public Index() {

	}

	static String combine(String... paths) {
		java.nio.file.Path combinedPath = Paths.get("");
		for (String path : paths) {
			combinedPath = combinedPath.resolve(Paths.get(path));
		}
		return combinedPath.toString();
	}

	public static Index update() throws IOException, ParseException {
		if (indexFile.exists()) {
			var json = new JSONObject(new String(java.nio.file.Files.readAllBytes(indexFile.toPath())));
			var nowtime = new Date();
			if (json.has("lastUpdate")) {
				var lastUpdate = parseDate(json.getString("lastUpdate"));
				if (lastUpdate.after(nowtime)) {
					var index = new Index();
					index.indexVersion = new Version(json.getString("version"));
					index.versions = parsePackageList(json.getJSONArray("packages"));
				}
				else {
					System.out.println("当前源是最新的。");
				}
			}
		} else {
			downloadFile(github_index, indexFile.getAbsolutePath());
			update();
		}
		return null;
	}

	private static List<Package> parsePackageList(JSONArray packages) throws MalformedURLException {
		var list = new ArrayList<Package>();
		for(int i = 0 ; i < packages.length(); i++) {
			var item = packages.getJSONObject(i);
			var pkg = new Package();
			pkg.id = item.getString("id");
			pkg.author = item.getString("author");
			var versions = new ArrayList<PackageVersion>();
			for (int j = 0; j < item.getJSONArray("versions").length(); j++) {
				var version = item.getJSONArray("versions").getJSONObject(j);
				versions.add(new PackageVersion(version.getString("version"), version.getString("url")));
			}
			pkg.versions = versions;
			list.add(pkg);
		}
		return list;
	}

	public void changeMirror(String url) {

	}

	private static void downloadFile(String fileURL, String savefile) throws IOException {
		// 要下载的文件的URL
		URL url = new URL(fileURL);
		// 要保存的本地文件路径
		File file = new File(savefile);

		// 打开URL连接
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		// 设置请求方法
		httpConn.setRequestMethod("GET");
		// 设置连接超时时间
		httpConn.setConnectTimeout(5000);
		// 设置读取超时时间
		httpConn.setReadTimeout(5000);
		// 建立实际的连接
		httpConn.connect();

		// 检查HTTP响应码
		int responseCode = httpConn.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			// 创建文件输出流
			FileOutputStream fos = new FileOutputStream(file);
			// 创建缓冲区
			byte[] buffer = new byte[4096];
			int len;

			// 从URL读取数据并写入文件
			InputStream is = httpConn.getInputStream();
			while ((len = is.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
			// 关闭流
			fos.close();
			is.close();


		} else {
			throw new IOException("当前源：HTTP response code: " + responseCode);
		}

		// 断开连接
		httpConn.disconnect();
	}

	/**
	 * 解析形如 "20221010" 的日期字符串，并将其转换为 Date 对象。
	 *
	 * @param dateString 日期字符串，格式为 "yyyyMMdd"
	 * @return 解析后的 Date 对象
	 * @throws ParseException 如果日期字符串格式不正确或解析失败
	 */
	public static Date parseDate(String dateString) throws ParseException {
		// 定义日期格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

		// 解析日期字符串

		return dateFormat.parse(dateString);
	}

	/**
	 * 将 Date 对象格式化为 "yyyyMMdd" 格式的日期字符串。
	 *
	 * @param date Date 对象
	 * @return 格式化后的日期字符串
	 */
	public static String formatDate(Date date) {
		// 定义日期格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

		// 格式化 Date 对象

		return dateFormat.format(date);
	}

}
