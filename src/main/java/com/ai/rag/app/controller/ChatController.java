package com.ai.rag.app.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ChatController {

    private ChatModel chatModel;
    private VectorStore vectorStore;

    public ChatController(ChatModel chatModel, VectorStore vectorStore) {
        this.chatModel = chatModel;
        this.vectorStore = vectorStore;
    }

    @PostMapping("/msg")
    private String chat(@RequestBody String msg) {
        return ChatClient.builder(chatModel)
                .build()
                .prompt()
                .advisors(new QuestionAnswerAdvisor(vectorStore))
                .user(msg)
                .call()
                .content();
    }
}
