package net.uberkat.obsidian.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import cpw.mods.fml.client.FMLClientHandler;

import net.minecraft.src.ModLoader;
import net.uberkat.obsidian.common.ObsidianIngots;
import net.uberkat.obsidian.common.ObsidianUtils;

/**
 * Sends information about this mod to the Obsidian Ingots server.
 */
public class ThreadSendData extends Thread
{
	public ThreadSendData()
	{
		setDaemon(true);
		start();
	}
	
	public void run()
	{
		System.out.println("[ObsidianIngots] Initiating server protocol...");
		try {
			InetAddress address = InetAddress.getByName(ObsidianIngots.hostIP);
			Socket socket = new Socket(address, ObsidianIngots.hostPort);
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			writer.println("USER:" + FMLClientHandler.instance().getClient().session.username);
			writer.println("DONE");
			writer.close();
			socket.close();
			try {
				finalize();
			} catch (Throwable e) {
				System.err.println("[ObsidianIngots] Could not end server thread, error was '" + e.getMessage() + ".'");
			}
		} catch (IOException e)
		{
			System.err.println("[ObsidianIngots] Could not connect to server, error was '" + e.getMessage() + ".'");
			try {
				finalize();
			} catch (Throwable e1) {
				System.err.println("[ObsidianIngots] Could not end server thread, error was '" + e.getMessage() + ".'");
			}
		}
	}
}
