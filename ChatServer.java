import java.io.IOException;
import java.net.URI;
//import java.io.FileWriter;
//import java.util.List;
//import java.io.File;
//import java.io.FileReader;
//import java.nio.file.Files;
//import java.nio.file.Paths;

//Lab report 2 Chat Server
//If I enter like ".../add-message?s=<string>&user=<string>", the message will be displayed like : "string(user): string(s)"

class Handler implements URLHandler {
  public String handleRequest(URI url){
        String username = "", message = "";
        //List<String> outputs;

        if (url.getPath().equals("/")) {
        return "it is home page! to add message, use the format: /add-message?s=<string>&user=<string>";
        }
        else{
            if (url.getPath().equals("/add-message")) {
                //FileWriter addSentence = new FileWriter("Thread.txt");

                String[] parameters = url.getQuery().split("&");
                if (parameters[0].substring(0,2).equals("s=")) {
                    message = parameters[0].substring(2, parameters[0].length());
                }
                if (parameters.length==2 && parameters[1].substring(0,5).equals("user=")) {
                    username = parameters[1].substring(5, parameters[1].length());
                }
                /*
                outputs = Files.readAllLines(Paths.get("Thread.txt"));
                addSentence.write(String.format("%s: %s\n", username, message));
                addSentence.close();
                */
                //return String.join("\n", outputs) + "\n" + String.format("%s: %s\n", username, message);

                return String.format("%s: %s\n", username, message);
            }
            return "invalid path!";
        }
    }
}

class ChatServer {
  public static void main(String[] args) throws IOException {

      /* 
      File threadFile = new File("Thread.txt");
      if(!threadFile.exists()){
          threadFile.createNewFile();
      }*/

      if(args.length == 0){
          System.out.println("Missing port number! Try any number between 1024 to 49151");
          return;
      }
      int port = Integer.parseInt(args[0]);
      Server.start(port, new Handler());
    }
}
