import java.io.IOException;
import java.net.URI;

//Lab report 2 Chat Server
//If I enter like ".../add-message?s=<string>&user=<string>", the message will be displayed like : "string(user): string(s)"

class Handler implements URLHandler {
  
  public String handleRequest(URI url) {
    String username = "", message = "";

    if (url.getPath().equals("/")) {
        return String.format("%s: %s", username, message);
    } 
    else {
        if (url.getPath().contains("/add-message")) {
            String[] strs = url.getQuery().split("=");
            if (strs[0].equals("s")) {
                message = strs[1];
                return String.format("%s: ", username);
            }
            if(strs[2].equals("user")){
                username = strs[3];
                return String.format("%s\n", username);
            }
        }
        return "Enter the valid path!\n";
        }
    }
}

class ChatServer {
  public static void main(String[] args) throws IOException {
      if(args.length == 0){
          System.out.println("Missing port number! Try any number between 1024 to 49151");
          return;
      }
      int port = Integer.parseInt(args[0]);
      Server.start(port, new Handler());
    }
}
