package tc.vpkgmgr;

import java.net.MalformedURLException;
import java.net.URL;

public class PackageVersion {
	public Version version;
	public URL location;
	public PackageVersion(String version,String url) throws MalformedURLException {
		this.version = new Version(version);
		this.location = new URL(url);
	}
}
