package chat;

import se.scalablesolutions.akka.actor.ActorRef;
import se.scalablesolutions.akka.actor.UntypedActor;
import chat.actors.ChatClient;
import chat.actors.ChatService;

/**
 * Test runner emulating a chat session.
 */
public class Runner {
	public static void main(String[] args) {
		// Create ChatServer
		ActorRef server = UntypedActor.actorOf(ChatService.class);
		server.start();

		// Create ChatClient
		ChatClient client = new ChatClient("Alex");
		client.login();

		client.post("Hi there...");
		System.out.println("***\nCHAT LOG:\n\t"
				+ client.getChatLog().getLogString("\n\t") + "\n***");

		client.post("Hi again...");
		System.out.println("***\nCHAT LOG:\n\t"
				+ client.getChatLog().getLogString("\n\t") + "\n***");

		client.logout();
	}
}