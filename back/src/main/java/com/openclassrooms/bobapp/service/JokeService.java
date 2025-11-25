package com.openclassrooms.bobapp.service;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.openclassrooms.bobapp.data.JsonReader;
import com.openclassrooms.bobapp.model.Joke;

@Service
public class JokeService {
    
    private final JsonReader jsonReader;
    // fix from Sonar Cloud about Random usage
    private final Random random = new Random();

    JokeService(JsonReader jsonReader) {
        this.jsonReader = jsonReader;
    }

    public Joke getRandomJoke() {
        List<Joke> jokes = this.jsonReader.getJokes();
        int randomIndex = random.nextInt(jokes.size());
        return jokes.get(randomIndex);
    }
}
