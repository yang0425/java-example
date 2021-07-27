package yang.example.dto;

public class HelloWorldDto {

  private final String message;

  public HelloWorldDto(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
