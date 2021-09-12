package com.ocbchackit.booking.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class FirebaseInitializer {

    @PostConstruct
    private void initDB() throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream("./booking-47948-firebase-adminsdk-2dd7y-b3e589f6a4.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://booking-47948.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(options);

    }


}
