package net.uberkat.obsidian.common;

public class ThreadGetData extends Thread
{
	public ThreadGetData()
	{
		setDaemon(true);
		start();
	}
	
	public void run()
	{
		ObsidianIngots.latestVersionNumber = ObsidianUtils.getLatestVersion();
		ObsidianIngots.recentNews = ObsidianUtils.getRecentNews();
		System.out.println("[ObsidianIngots] Successfully retrieved data from server.");
		try {
			finalize();
		} catch(Throwable t) {
			System.out.println("[ObsidianIngots] Unable to finalize server data.");
		}
	}
}
