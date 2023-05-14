package org.example.model;
/**
 * Clasa Bill reprezinta o tabela din baza de date
 * Aceasta clasa este creata folosind Java Record, este o clasa imudabila si este
 * folosita pentru crearea sau citirea bonurilor/facturilor
 */
public final record Bill(int billID, int orderID, String firstName, String lastName, String productName, int quantity, double price) {

}