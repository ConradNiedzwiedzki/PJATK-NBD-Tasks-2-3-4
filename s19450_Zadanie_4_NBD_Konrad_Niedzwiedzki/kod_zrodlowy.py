#!/usr/bin/python
# -*- coding: UTF-8 -*-

import riak
client = riak.RiakClient(port=8090)
myBucket = client.bucket("s19450")

def DodajNowy(klucz, wartosc):
    myBucket.new(klucz, data=wartosc).store()      
def Pobierz(klucz):
    print(myBucket.get(klucz).data)
def Zmodyfikuj(klucz, wartosc):
    film = myBucket.get(klucz)
    film.data = wartosc
    film.store()
def Usun(klucz):
    myBucket.get(klucz).delete()

rodzaj = "film"
nazwa = "Magnezja"
rok = 2020
czyWKinach = True
film = {"rodzaj": rodzaj, "nazwa": nazwa, "rok": rok, "czyWKinach": czyWKinach}
DodajNowy("film", film)

print("Dodano nowy rekord. Pobieram dodany rekord:")

Pobierz("film")
rodzaj = "serial"
film = {"rodzaj": rodzaj, "nazwa": nazwa, "rok": rok}
Zmodyfikuj("film", film)

print("Rekord zostal zmodyfikowany. Pobieram zmodyfikowany rekord:")

Pobierz("film")
Usun("film")

print("Usunieto rekord. Probuje pobrac usuniety rekord:")

Pobierz("film")