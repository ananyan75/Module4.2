package com.caseflow.caseflow.controller;
import com.caseflow.caseflow.entity.Document;
import com.caseflow.caseflow.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/api/v1/documents")
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @PostMapping
    public ResponseEntity<Document> upload(
            @RequestBody Document doc){
    return ResponseEntity.ok(
            documentService.uploadDocument(doc));
    }
    @GetMapping("/case/{caseId}")
    public ResponseEntity<List<Document>> getByCase(
            @PathVariable Integer caseId){
        return ResponseEntity.ok(
                documentService.getDocumentsByCase(caseId));
    }
    @PostMapping("/{documentId}/verify")
    public ResponseEntity<Document> verify(
            @PathVariable Integer documentId,
            @RequestParam String status,
            @RequestParam Integer clerkId){
     return ResponseEntity.ok(
             documentService.verifyDocument(documentId,status,clerkId));
    }

}
