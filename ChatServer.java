import java.io.IOException;
import java.net.URI;

//Lab report 2 Chat Server
//If I enter like ".../add-message?s=<string>&user=<string>", the message will be displayed like : "string(user): string(s)"


class Counter implements URLHandler {
  int num = 0;
  public String handleRequest(URI url) {
    System.out.println(url);
    if (url.getPath().equals("/add-message")){ 
      String username;
      String message;
      if(url.contain("s=")){
        username = url.substring(url.indexOf("s=")+2, url.indexOf("&"));
      }
      if(url.contain("&user="){
        username = url.substring(url.indexOf("user=")+5, url.length()-1);
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
    int port = Integer.parseInt(args[0]);
    Server.start(port, new Counter());
  }
}
