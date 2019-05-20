package com.akram.sahbi;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Main {
	
	static final long MEGABYTE_FACTOR = 1024L * 1024L;
	
	public static void main(String[] args) {
		System.out.println("Starting A* to solve 8-puzzle");
		
		//long start = System.currentTimeMillis();
		LocalDateTime startTime = LocalDateTime.now();
		AStar aStar = new AStar("1","2","5","3","4","0","6","7","8");
		boolean success = aStar.solve();
		LocalDateTime endTime = LocalDateTime.now();
		
		if(success)
		{
			System.out.println("\t\t\tStatistics:");
			System.out.println("Path to goal: " + aStar.getCurrentNode().getPathToGoal());
			System.out.println("Cost to goal: " + aStar.getCurrentNode().getCostOfPath());
			System.out.println("Nodes expanded: "+aStar.getExploredNodes().size());
			System.out.println("Search depth: " + aStar.getCurrentNode().getSearchDepth());
			System.out.println("Max Search depth: " + aStar.getCurrentNode().getMaxSearchDepth());
			
			
			//long hours = startTime.until( endTime, ChronoUnit.HOURS);
			long seconds = startTime.until( endTime, ChronoUnit.SECONDS);
			if(seconds == 0)
			{
				long milliSeconds = startTime.until( endTime, ChronoUnit.MILLIS);
				System.out.println("running time:  "+ milliSeconds+" MILLISECONDS");
			}
			else
			{
				System.out.println("running time:  "+ seconds+" SECONDS");
			}
			final long MEGABYTE_FACTOR = 1024L * 1024L;
			final DecimalFormat ROUNDED_DOUBLE_DECIMALFORMAT;
			DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
		    otherSymbols.setDecimalSeparator('.');
		    otherSymbols.setGroupingSeparator(',');
		    ROUNDED_DOUBLE_DECIMALFORMAT = new DecimalFormat("####0.00", otherSymbols);
		    ROUNDED_DOUBLE_DECIMALFORMAT.setGroupingUsed(false);
		    double totalMiB = bytesToMiB(getUsedMemory());
		    System.out.println(String.format("Max memory usage: %s Megabytes", totalMiB)); ;
			
		}
		else
		{
			System.err.println("no solution found!");
		}
		

	}
	public static long getTotalMemory() {
	    return Runtime.getRuntime().totalMemory();
	}
	
	private static double bytesToMiB(long bytes) {
	    return ((double) bytes / MEGABYTE_FACTOR);
	}
	
	public static long getMaxMemory() {
	    return Runtime.getRuntime().maxMemory();
	}

	public static long getUsedMemory() {
	    return getTotalMemory() - getFreeMemory();
	}


	public static long getFreeMemory() {
	    return Runtime.getRuntime().freeMemory();
	}

}
