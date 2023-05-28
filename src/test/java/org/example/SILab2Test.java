package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.example.SILab2.function;
import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {
    @Test
    void userNullException() // Koga imame objekt od klasata User koj sto e null
    {
        User korisnik = null;
        List<User> korisnici = new ArrayList<>();
        assertThrows(RuntimeException.class,()->{
           SILab2.function(korisnik,korisnici);
        });
    }

    @Test
    void validUserEmptyUserList() //Koga imame korisnik koj ne e null i prazna lista na korisnici
    {
        User korisnik = new User("Angel","angel!2314#","angeld@hotmail.com");
        List<User> korisnici = new ArrayList<>();
        assertEquals(false,function(korisnik,korisnici));
    }
    @Test
    void uniquePassShorterThanEight() // Koga lozinkata e razlicna i e pokratka od 8 karakteri
    {
        List<User> korisnici = new ArrayList<>();
        User korisnik = new User("Trajko","traj4e","trajkos@yahoo.com");
        korisnici.add(new User("Angel","@34asdfafg","damcheskia@gmail.com"));

        assertEquals(false,SILab2.function(korisnik,korisnici));
    }
    @Test
    void samePasswordLongerThanEight() //Koga lozinkata e identicna no e podolga od 8 karakteri
    {
        List<User> korisnici = new ArrayList<>();
        User korisnik = new User("AngeL","damcheski!","angeld@yahoo.com");
        korisnici.add(new User("Trajko","traj4e","traj3@gmail.com"));
        assertEquals(true,SILab2.function(korisnik,korisnici));
    }
    @Test
    void passwordContainsEmptySpace()//Koga lozinkata sodrzi prazno mesto
    {
        List<User> korisnici = new ArrayList<>();
        User korisnik = new User("Angel","angel d","angeldam@gmail.com");
        korisnici.add(new User("Trajko","trajkopetreski","trajkop@gmail.com"));
        assertEquals(false,SILab2.function(korisnik,korisnici));
    }

    @Test
    void passwordDoesNotContainSpecialChar() // Koga lozinkata ne sodrzi specijalen karakter
    {
        List<User> korisnici = new ArrayList<>();
        User korisnik = new User("Angel","angeldamcheskibest","damcheskia@gmail.com");
        korisnici.add(new User("Stojce","strojcebest","stojan@gmail.com"));
        assertEquals(false,SILab2.function(korisnik,korisnici));

    }

    @Test
    void emailNull() // Koga email-ot e nepostoecki
    {
        List<User> korisnici = new ArrayList<>();
        User korisnik = new User("Angel","angeld","");
        korisnici.add(new User("Trajko","trajkothebest","trajkos@gmail.com"));
        assertEquals(false,SILab2.function(korisnik,korisnici));
    }

    @Test
    void passwordNull() //Koga lozinkata e nepostoecka
    {
        List<User> korisnici = new ArrayList<>();
        User korisnik = new User("Angel","","angeld@gmail.com");
        korisnici.add(new User("Trajko","asldkj","trajkostoj@gmail.com"));
        assertEquals(false,SILab2.function(korisnik,korisnici));

    }

    @Test
    void passwordAndEmailAreNull() // Koga i lozinkata i email adresata se null
    {
        List<User> korisnici = new ArrayList<>();
        User korisnik = new User("Angel","","");
        korisnici.add(new User("Trajko","trajce","trajkos@gmail.com"));
        assertEquals(false,SILab2.function(korisnik,korisnici));
    }

    @Test
    void korisnickaListaPrazna() // Koga user list e prazna
    {
        List<User> korisnici = new ArrayList<>();
        User korisnik = new User("Angel","angeld","angeld@gmail.com");
        assertEquals(false, SILab2.function(korisnik,korisnici));
    }

    @Test
    void invalidEmail() // Koga email adresata e nevalidna
    {
        List<User> korisnici = new ArrayList<>();
        User korisnik = new User("Angel","angeld123","angeld@gmail.com");
        assertFalse(SILab2.function(korisnik,korisnici));
    }

    @Test
    void longPassword()//Koga lozinkata e predolga
    {
        List<User> korisnici = new ArrayList<>();
        User korisnik = new User("Angel","angeldamcheskithebest1234#@#","angeldamcheski@gmail.com");
        assertEquals(false,SILab2.function(korisnik,korisnici));
    }
}
