package yang.example.dto;

public class HelloWorldDTO {

  private final String message;

  public HelloWorldDTO(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
