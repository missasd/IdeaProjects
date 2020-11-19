package com.example.test_crud;

        import org.mybatis.spring.annotation.MapperScan;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.example.test_crud.mapper")
@SpringBootApplication
public class TestCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestCrudApplication.class, args);
    }

}
