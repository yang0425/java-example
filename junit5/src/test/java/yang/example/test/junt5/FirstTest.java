package yang.example.test.junt5;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class FirstTest {

  @Test
  void assert_equals() {
    First first = new First();
    assertNotNull(first);
  }
}