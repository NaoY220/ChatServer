import java.io.IOException;
import java.net.URI;

class Counter implements URLHandler {
  int num = 0;
  public String handleRequest(URI url) {
    System.out.println(url);
    if (url.getPath().equals("/")) { return String.format("Number: %d", num); }
    // FILL in the block below to match the behavior in the browser below!
    else if (url.getPath().equals("/count")) {

    } else {
      return "Don't know what to do with that path!";
    }
  }
}
class CounterMain {
  public static void main(String[] args) throws IOException {
    int port = Integer.parseInt(args[0]);
    // We wrote Server; it is a very short class (you can see it in Server.java in lab 2)
    Server.start(port, new Counter());
  }
}
