# Spring Security Architecture

![alt text](<Spring Security Architecture.png>)

# OAuth2 Login Architecture

![alt text](<OAuth2 Login Architecture.png>)

# Annotations of Spring Security

## 1. @EnableWebSecurity - 
@EnableWebSecurity enables Spring Security’s web security infrastructure and allows custom security configuration by registering the necessary security filter chain and components in the application context.
It allows developers to customize security configurations by defining beans such as SecurityFilterChain, authentication providers, password encoders, and other security-related components.
In Spring Boot, you usually do NOT need to explicitly use @EnableWebSecurity because it is automatically configured when when we added the spring security’s dependency “spring-boot-starter-security”. You only use it when you want to provide custom security configuration.

## 2. @EnableMethodSecurity -
@EnableMethodSecurity is a Spring Security annotation that enables method-level security in your application.

## 3. @PreAuthorize -
Check access before method execution

## 4. @PostAuthorize -
Check access after method execution (based on result)

## 5. @PreFilter -
Filter's method input before execution. Used on collection parameters.

## 6. @PostFilter -
Filter's method output after execution. Used when method returns collection.