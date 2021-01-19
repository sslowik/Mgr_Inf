package com.designpatterns.mgrinf;

public class DesignPatternsApp {
    public static void main(String[] args){
        System.out.println("Starting GUI");
        GUIBuilder guiBuilder = new GUIBuilder();
        guiBuilder.buildGUI();

        TestRunner testRunner = new TestRunner(guiBuilder);
        guiBuilder.setTestRunner(testRunner);
    }
}

/* Rodzaje wzorców
> Kreacyjne / Konstrukcyjne – opisujące proces tworzenia nowych obiektów.
  Ich zadaniem jest tworzenie, inicjalizacja oraz konfiguracja obiektów, klas oraz innych typów danych.
 * Budowniczy,
 * Fabryka,
 * Prototyp,
 * Singleton.

>> Strukturalne – opisujące struktury powiązanych ze sobą obiektów.
 * Adapter,
 * Dekorator,
 * Fasada,
 * Kompozyt,
 * Most,
 * Pełnomocnik,
 * Pyłek.

>>> Czynnościowe / Behawioralne / Operacyjne – opisujące zachowanie i odpowiedzialność współpracujących ze sobą obiektów.
 * Łańcuch odpowiedzialności,
 * Polecenie,
 * Interpreter,
 * Iterator,
 * Mediator,
 * Pamiątka,
 * Metoda szablonowa,
 * Obserwator,
 * Stan,
 * Strategia,
 * Odwiedzający.
*/
