package com.desafio.url.services;

import com.desafio.url.model.Url;
import com.desafio.url.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    public String shortenUrl(String originalUrl){
        String shortUrl = generateShortUrl();
        // Verifica se o shortUrl já existe no banco
        while (urlRepository.findByShortUrl(shortUrl).isPresent()) {
            shortUrl = generateShortUrl(); // Gera outro até ser único
        }
        Url url = new Url();
        url.setOriginalUrl(originalUrl);
        url.setShortUrl(shortUrl);
        url.setExpirationDate(LocalDateTime.now().plusDays(30));
        urlRepository.save(url);
        return shortUrl;
    }

    public Optional<Url> getOriginalUrl(String shortUrl){
        Optional<Url> urOptional = urlRepository.findByShortUrl(shortUrl);
        if(urOptional.isPresent()){
            Url url = urOptional.get();
            if(url.getExpirationDate().isAfter(LocalDateTime.now())){
                return Optional.of(url);
            }
            else{
                urlRepository.delete(url);
            }
        }
        return Optional.empty();
    }

    private String generateShortUrl(){
        String characteres = "ABCDEFGHIJKLMOPQRSTUVWXYZabcdefghijlmnopqrstuvwxyz";
        StringBuilder shortUrl = new StringBuilder();
        Random ranom = new Random();
        int length = 5 + ranom.nextInt(6);
        for (int i = 0; i < length ; i++){
            shortUrl.append(characteres.charAt(ranom.nextInt(characteres.length())));
        }
        return shortUrl.toString();
    }
}
