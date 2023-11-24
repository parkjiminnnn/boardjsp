import java.io.IOException;
import java.util.*;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/broadcasting/{chatroomID}")
public class Broadsocket {
    
    private static Map<Integer, Set<Session>> chatRooms = new HashMap<>();

    @OnMessage
    public void onMessage(String message, Session session, @PathParam("chatroomID") Integer chatroomID) throws IOException {
        System.out.println("onMessage 호출");
        System.out.println(message);

        Set<Session> roomClients = chatRooms.get(chatroomID);
        if (roomClients != null) {
            synchronized (roomClients) {
                for (Session client : roomClients) {
                    if (!client.equals(session)) {
                        client.getBasicRemote().sendText(message);
                    }
                }
            }
        }
    }

    @OnOpen
    public void onOpen(Session session, @PathParam("chatroomID") Integer chatroomID) {
        System.out.println("onOpen 호출");
        // Add session to the connected sessions set
        System.out.println(session);

        // Create the chat room if it doesn't exist
        chatRooms.putIfAbsent(chatroomID, Collections.synchronizedSet(new HashSet<Session>()));

        Set<Session> roomClients = chatRooms.get(chatroomID);
        roomClients.add(session);
    }

    @OnClose
    public void onClose(Session session, @PathParam("chatroomID") Integer chatroomID) {
        System.out.println("onClose 호출");
        // Remove session from the connected sessions set
        Set<Session> roomClients = chatRooms.get(chatroomID);
        if (roomClients != null) {
            roomClients.remove(session);
        }
    }
}

