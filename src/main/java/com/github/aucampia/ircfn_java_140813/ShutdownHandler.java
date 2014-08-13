package com.github.aucampia.ircfn_java_140813;

public class ShutdownHandler
	extends Thread
{
	private Boolean shutdown = new Boolean( false );
	private final Object shutdownMonitor = new Object();

	void awaitShutdown()
		throws InterruptedException
	{
		System.err.println( "ShutdownHandler#awaitShutdown():entry" );
		synchronized( this.shutdownMonitor )
		{
			while( this.shutdown.booleanValue() == false )
				this.shutdownMonitor.wait();
		}
	}

	Boolean isShutdown()
	{
		synchronized( this.shutdownMonitor )
		{
			return new Boolean( this.shutdown );
		}
	}

	void shutdown()
	{
		System.err.println( "ShutdownHandler#shutdown():entry" );
		synchronized( this.shutdownMonitor )
		{
			this.shutdown = true;
			this.shutdownMonitor.notifyAll();
		}
	}

	@Override
	public void run()
	{
		System.err.println( "ShutdownHandler#run():entry" );
		this.shutdown();
	}
};
