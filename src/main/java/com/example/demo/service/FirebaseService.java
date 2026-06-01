package com.example.demo.service;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class FirebaseService {
    public void setValue(
            String path,
            Object value
    ) {

        FirebaseDatabase
                .getInstance()
                .getReference(path)
                .setValueAsync(value);
    }

    public <T> T getValue(
            String path,
            Class<T> clazz
    ) {

        CompletableFuture<T> future =
                new CompletableFuture<>();

        FirebaseDatabase.getInstance()
                .getReference(path)
                .addListenerForSingleValueEvent(
                        new ValueEventListener() {

                            @Override
                            public void onDataChange(
                                    DataSnapshot snapshot
                            ) {

                                future.complete(
                                        snapshot.getValue(clazz)
                                );
                            }

                            @Override
                            public void onCancelled(
                                    DatabaseError error
                            ) {

                                future.completeExceptionally(
                                        error.toException()
                                );
                            }
                        });

        try {

            return future.get();

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }
}
