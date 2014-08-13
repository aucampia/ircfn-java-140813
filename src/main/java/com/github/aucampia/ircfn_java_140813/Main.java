package com.github.aucampia.ircfn_java_140813;

public class Main
{
	public static final ShutdownHandler shutdownHandler = new ShutdownHandler();
	public static void main( String[] args )
	{
		System.err.println( "begin ..." );
		Runtime.getRuntime().addShutdownHook( shutdownHandler );
		try
		{
			System.err.println( "waiting for shutdown" );
			shutdownHandler.awaitShutdown();
			System.err.println( "got shutdown" );
			Thread.sleep(10);
			System.err.println( "cleanup 001" );
			Thread.sleep(10);
			System.err.println( "cleanup 002" );
			Thread.sleep(10);
			System.err.println( "cleanup 003" );
			Thread.sleep(10);
		}
		catch( InterruptedException e )
		{
			System.err.println( "Got InterruptedException: " + e.getMessage() );
		}
		System.err.println( "end ..." );
	}

}
