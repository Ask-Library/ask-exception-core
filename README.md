<div align="center">

# Ask Exception Core

<img src="https://img.shields.io/badge/Java-21-F89820?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java Support" />
<img src="https://img.shields.io/jitpack/v/github/Ask-Library/ask-exception-core?style=for-the-badge&label=JitPack&color=663399" alt="JitPack Version" />
<img src="https://img.shields.io/badge/License-Apache_2.0-1F6FEB?style=for-the-badge" alt="License" />

**Ask Exception Core** is a lightweight Java library that simplifies exception handling by eliminating boilerplate code and automatically binding clean exceptions to centralized error catalogs via Convention over Configuration.

</div>
---

## Key Features

### 1. Convention over Configuration
Automatically binds exception classes to an error catalog. For an exception named `ResourceNotFoundException`, the library looks for a `RESOURCE_NOT_FOUND` entry in the associated catalog enum. This eliminates manual mapping and reduces boilerplate.

### 2. Centralized Error Catalogs
Define all your application's errors in centralized `enum` catalogs that implement `BaseExceptionCatalog`. This provides a single source of truth for error codes, messages, and HTTP statuses.

### 3. Clean, Annotation-Driven Exceptions
Create custom exception classes by extending `BaseException` and annotating them with `@ExceptionDef`. The library handles the rest, populating the exception's properties from the catalog.

### 4. Dynamic Exception Building
A powerful `Builder` allows you to override catalog-defined properties at runtime, providing flexibility for dynamic error messages or statuses.

---

## Prerequisites

*   **Java:** 21 or higher
*   **Build Tool:** Gradle or Maven

---

## Installation

This library is hosted on [JitPack](https://jitpack.io/#Ask-Library/ask-exception-core), making it easy to include in your projects.

### Gradle (Kotlin DSL)

**1. Add the JitPack repository:**
In your `settings.gradle.kts` or `build.gradle.kts`:

```kotlin
repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}
```

**2. Add the dependency:**

```kotlin
dependencies {
    implementation("com.github.Ask-Library:ask-exception-core:{current-version}")
}
```

### Maven

**1. Add the JitPack repository:**
In your `pom.xml`:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

**2. Add the dependency:**

```xml
<dependency>
    <groupId>com.github.Ask-Library</groupId>
    <artifactId>ask-exception-core</artifactId>
    <version>{current-version}</version>
</dependency>
```

---

## Quick Usage Examples

### 1. Create an Error Catalog
Define an `enum` that implements `BaseExceptionCatalog` to store your error definitions.

```java
import pe.ask.exception.core.catalog.BaseExceptionCatalog;
import java.util.Map;

public enum BusinessExceptionCatalog implements BaseExceptionCatalog {
    
    USER_NOT_FOUND("ERR-BIZ-404", "User not found", 404),
    INVALID_INPUT("ERR-BIZ-400", "Invalid input provided", 400);

    private final String errorCode;
    private final String message;
    private final int status;

    BusinessExceptionCatalog(String errorCode, String message, int status) {
        this.errorCode = errorCode;
        this.message = message;
        this.status = status;
    }

    @Override public String getErrorCode() { return errorCode; }
    @Override public String getExceptionName() { return name(); }
    @Override public String getMessage() { return message; }
    @Override public int getStatus() { return status; }
    @Override public Map<String, String> getErrors() { return null; }
}
```

### 2. Define a Custom Exception
Create a class that extends `BaseException` and link it to your catalog with `@ExceptionDef`. The class name `UserNotFoundException` will automatically map to the `USER_NOT_FOUND` enum constant.

```java
import pe.ask.exception.core.annotation.ExceptionDef;
import pe.ask.exception.core.model.BaseException;

@ExceptionDef(BusinessExceptionCatalog.class)
public class UserNotFoundException extends BaseException {
    // No constructor or fields needed!
}
```

### 3. Throw the Exception
Now you can throw your custom exception without any boilerplate.

```java
public User findUserById(String id) {
    return userRepository.findById(id)
        .orElseThrow(UserNotFoundException::new);
}

// When thrown, the exception will have:
// errorCode: "ERR-BIZ-404"
// message: "User not found"
// status: 404
```

### 4. Use the Builder for Dynamic Messages
Override catalog properties at runtime using the builder.

```java
import pe.ask.exception.core.model.BaseException;
import java.util.Map;

public void validateInput(String input) {
    if (input == null || input.isBlank()) {
        throw new BaseException.Builder<>(InvalidInputException.class)
            .withMessage("The input field cannot be empty.")
            .withErrors(Map.of("fieldName", "The value is required."))
            .build();
    }
}

@ExceptionDef(BusinessExceptionCatalog.class)
public class InvalidInputException extends BaseException {}
```

---

## Contributing

We welcome contributions! If you have suggestions for new features or find a bug, please open an issue or submit a pull request.

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/amazing-feature`).
3. Commit your changes (`git commit -m 'Add some amazing feature'`).
4. Push to the branch (`git push origin feature/amazing-feature`).
5. Open a Pull Request.

---

## License

This project is open-sourced under the terms of the **[Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.txt)**.

## Author

**Allan Sagastegui**
*   Email: [allxn.sxh@gmail.com](mailto:allxn.sxh@gmail.com)
*   GitHub: [@AllanSagastegui](https://github.com/AllanSagastegui)
* Instagram: [@_ask.dev](https://www.instagram.com/_ask.dev/)
