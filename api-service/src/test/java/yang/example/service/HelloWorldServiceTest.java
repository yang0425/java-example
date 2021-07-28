package yang.example.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import yang.example.dto.HelloWorldDto;
import yang.example.entity.HelloWorld;
import yang.example.repository.HelloWorldRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class HelloWorldServiceTest {

    @Mock
    private HelloWorldRepository helloWorldRepository;

    @InjectMocks
    private HelloWorldService helloWorldService;

    @Test
    void shouldGetMessageFromRepository() {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setMessage("Hello World Test");
        given(helloWorldRepository.getHelloWorld()).willReturn(helloWorld);

        HelloWorldDto helloWorldDto = helloWorldService.getHelloWorld();

        assertThat(helloWorldDto.getMessage()).isEqualTo("Hello World Test");
    }
}