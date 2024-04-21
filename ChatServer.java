import java.io.IOException;
import java.net.URI;

//Lab report 2 Chat Server
//If I enter like ".../add-message?s=<string>&user=<string>", the message will be displayed like : "string(user): string(s)"

class Counter implements URLHandler {
  int num = 0;
  public String handleRequest(URI url) {
    System.out.println(url);
    if (url.getPath().equals("/add-message")){ 
      String username="", message = "";
      if(url.getPath().contains("s=")){
        username = url.getPath().substring(url.getPath().indexOf("s=")+2, url.getPath().indexOf("&"));
      }
      if(url.getPath().contains("&user=")){
        username = url.getPath().substring(url.getPath().indexOf("user=")+5, url.getPath().length()-1);
      }
      return username + ": " + message;
    }
    else {
      return "Enter the valid path!";
    }
  }
}
class CounterMain {
  public static void main(String[] args) throws IOException {
      if(args.length == 0){
          System.out.println("Missing port number! Try any number between 1024 to 49151");
          return;
      }
      int port = Integer.parseInt(args[0]);
      Server.start(port, new Handler());
    }
  }
}
