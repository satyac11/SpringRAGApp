# SpringRAGApp

SpringRAGApp is a Java-based application designed to demonstrate Retrieval-Augmented Generation (RAG) techniques using the robust Spring ecosystem. This project showcases how to integrate retrieval-based knowledge with generative AI models, providing an end-to-end example suitable for experimentation, learning, and extension.

## Features

- **Retrieval-Augmented Generation (RAG):** Combines information retrieval with generative AI to provide contextually rich responses.
- **Spring Boot:** Leverages the Spring Boot framework for rapid development and deployment.
- **Modular Architecture:** Clean separation of concerns for easy extension and maintenance.
- **RESTful API:** Exposes endpoints for querying and interacting with the RAG pipeline.
- **Pluggable Connectors:** Easily integrate different data sources or LLMs.

## Getting Started

### Prerequisites

- Java 17 or newer
- Maven 3.6+
- Docker
- OLLAMA

### Clone the Repository

```bash
git clone https://github.com/satyac11/SpringRAGApp.git
cd SpringRAGApp
```

### Build & Run

#### Using Maven

```bash
mvn clean install
mvn spring-boot:run
```

#### Using Docker

```bash
docker build -t spring-rag-app .
docker run -p 8080:8080 spring-rag-app
```

### Configuration

All major configuration values can be set in `src/main/resources/application.properties`.

## API Endpoints

- `POST /api/rag/query`  
  Submit a query and receive a RAG-generated response.

Example request body:
```json
{
  "query": "What is Retrieval-Augmented Generation?"
}
```

## Project Structure

```text
src/
 └── main/
      ├── java/
      │    └── com/
      │         └── satyac11/
      │              └── springragapp/
      └── resources/
           └── application.properties
```

## Customization

- **Data Sources:** Plug in new knowledge sources by implementing the retrieval interfaces.
- **LLM Integration:** Swap out the generative model
- **UI:** Extend with a web frontend or chatbot interface.

## Contributing

Contributions, issues, and feature requests are welcome!  
Feel free to check the [issues page](https://github.com/satyac11/SpringRAGApp/issues).

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Author

[Satyac11](https://github.com/satyac11)

---

*Built with Spring Boot and a passion for AI innovation!*
