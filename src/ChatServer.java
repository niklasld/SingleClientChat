import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    public static void main(String[] args) {
        new ChatServer().runServer();
    }

    private static void runServer() {
        SocketHandler socketHandler = new SocketHandler();

        int port = 1333;

        try {
            ServerSocket serverSocket = new ServerSocket(port);

            while (true) {
                System.out.println("Venter på at oprette forbindelse til klient...");
                Socket socket = serverSocket.accept();
                System.out.println("Forbindelse til klient er oprettet...");

                System.out.println("Forbindelse er startet...");

                socketHandler.handleSockets(socket);
                System.out.println("Forbindelse er sluttet...");
            }

        }

        catch (IOException e){
            e.printStackTrace();
        }

    }


    public static void broadcast(String message, Socket socket) throws IOException {
        DataOutputStream dataOutput;
            dataOutput = new DataOutputStream(socket.getOutputStream());
            dataOutput.writeUTF(message);
            System.out.println(message);
    }
}
