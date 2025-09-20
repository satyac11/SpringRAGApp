package com.ai.rag.app.ingestion;


import org.springframework.ai.document.Document;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DocumentIngestionService implements CommandLineRunner {

    @Value("classpath:/documents/budget_speech.pdf")
    private Resource resource;
    private VectorStore vectorStore;

    public DocumentIngestionService(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    @Override
    public void run(String... args) throws Exception {
        //Read the document
        System.out.println("Reading the document: "+resource.getFilename());
        TikaDocumentReader docReader = new TikaDocumentReader(resource);
        
        //Split the PDF into chunks
        System.out.println("Spliting the document");
        TextSplitter textSplitter = new TokenTextSplitter();
        List<Document> documents = textSplitter.split(docReader.read());

        //Save data to vector data base
        System.out.println("Storing the chunks into db");
        vectorStore.accept(documents);
        System.out.println("stored given document into vector db");
    }
}
