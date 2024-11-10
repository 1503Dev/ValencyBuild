package tc.vpkgmgr;

public class Version{
	public int major;
	public int minor;
	public int patch;
	public int build;

	public Version(String version){
		String[] parts = version.split("\\.");
		if(parts.length == 4){
			major = Integer.parseInt(parts[0]);
			minor = Integer.parseInt(parts[1]);
			patch = Integer.parseInt(parts[2]);
			build = Integer.parseInt(parts[3]);
		}
	}

	public Version(int major, int minor, int patch, int build){
		this.major = major;
		this.minor = minor;
		this.patch = patch;
		this.build = build;
	}

	@Override
	public String toString(){
		return String.format("%d.%d.%d.%d", major, minor, patch, build);
	}
}
