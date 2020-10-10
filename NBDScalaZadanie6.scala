object NBDScalaZadanie6 {
  def Zadanie1(): Unit = {
    println("Zadanie 1:")

    val dniTygodnia = List(
      "Poniedzialek",
      "Wtorek",
      "Sroda",
      "Czwartek",
      "Piatek",
      "Sobota",
      "Niedziela"
    )

    println("Zadanie 1. a):")
    for (dzien <- dniTygodnia) {
      println(dzien)
    }
    println("---")

    println("Zadanie 1. b):")
    for (dzien <- dniTygodnia if dzien(0) == 'P') {
      println(dzien)
    }
    println("---")

    println("Zadanie 1. c):")
    dniTygodnia.foreach(dzien => println(dzien))
    println("---")

    println("Zadanie 1. d):")
    var i = 0
    while (i < dniTygodnia.length) {
      println(dniTygodnia(i))
      i += 1
    }
    println("---")

    println("Zadanie 1. e):")
    def wypiszDniTygodnia(listaDni: List[Any]): Unit = {
      if (!listaDni.isEmpty) {
        println(listaDni.head)
        wypiszDniTygodnia(listaDni.tail)
      }
    }
    wypiszDniTygodnia(dniTygodnia)
    println("---")

    println("Zadanie 1. f):")
    def wypiszDniTygodniaOdKonca(listaDni: List[Any]): Unit = {
      if (!listaDni.isEmpty) {
        println(listaDni.last)
        wypiszDniTygodniaOdKonca(listaDni.init)
      }
    }
    wypiszDniTygodniaOdKonca(dniTygodnia)
    println("---")

    println("Zadanie 1. g):")
    println(dniTygodnia.foldLeft("")(_ + _ + "\n"))
    println("---")
    println(dniTygodnia.foldRight("")(_ + "\n" + _))
    println("---")

    println("Zadanie 1. h):")
    print(dniTygodnia.filter(_.startsWith("P")).foldLeft("")(_ + _ + "\n"))
    println("-----")
  }

  def Zadanie2(): Unit = {
    println("Zadanie 2:")

    val produkty =
      Map("Bulka" -> 15, "Jogurt" -> 60, "Mleko" -> 180, "Czekolada" -> 200)
    println("Produkty bez znizki:")
    produkty.foreach(produkt => println(produkt))

    val produktyZeZnizka = produkty.view.mapValues(_ * 0.9)

    println("Produkty ze znizka:")
    produktyZeZnizka.foreach(produkt => println(produkt))

    println("-----")
  }

  def Zadanie3(): Unit = {
    println("Zadanie 3:")

    def wypiszTypy(typy: (Any, Any, Any)): Unit = {
      if (typy._1.getClass == typy._2.getClass || typy._1.getClass == typy._3.getClass || typy._2.getClass == typy._3.getClass) {
        println("Podane typy nie sa od siebie rozne.")
        return
      }
      typy.productIterator.foreach(typ => println(typ + " - " + typ.getClass))
    }
    val przyklad1 = Tuple3(0, 1, 2)
    val przyklad2 = Tuple3(0, true, 'a')

    println("Sprawdzam typy dla: 0, 1, 2")
    wypiszTypy(przyklad1)
    println("Sprawdzam typy dla: 0, true, 'a'")
    wypiszTypy(przyklad2)

    println("-----")
  }

  def Zadanie4(): Unit = {
    println("Zadanie 4:")

    val produkty =
      Map("Bulka" -> 15, "Jogurt" -> 60, "Mleko" -> 180, "Czekolada" -> 200)
    println("Cena bulki: " + produkty.get("Bulka"))
    println("Czy bulki sa dostepne w sklepie?")
    println(produkty.get("Bulka").isEmpty)

    println("Czy chleb jest dostepny w sklepie?")
    println(produkty.get("Chleb").isEmpty)

    println("Jezeli nie ma chleba, proponujemy wybrac bulki:")
    println(produkty.get("Chleb").getOrElse("Bulka"))

    println("-----")
  }

  def Zadanie5(): Unit = {
    def sprawdzDzienTygodnia(dzien: String): String = dzien.toLowerCase match {
      case "poniedzialek" | "wtorek" | "sroda" | "czwartek" | "piatek" =>
        "Praca"
      case "sobota" | "niedziela" => "Weekend"
      case _                      => "Nie ma takiego dnia"
    }

    val dniDoSprawdzenia = List(
      "Poniedzialek",
      "Wtorek",
      "Sroda",
      "Czwartek",
      "Piatek",
      "Sobota",
      "Niedziela",
      "Czwardzialek"
    )
    dniDoSprawdzenia.foreach(dzien => println(sprawdzDzienTygodnia(dzien)))

    println("-----")
  }

  def Zadanie6(): Unit = {
    println("Zadanie 6:")

    class KontoBankowe() {
      private var _stanKonta = 0.0

      def stanKonta: Double = _stanKonta

      def this(stanKonta: Double) {
        this()
        _stanKonta = stanKonta
      }

      def wplata(wartosc: Double): Unit = {
        _stanKonta = _stanKonta + wartosc
      }

      def wyplata(wartosc: Double): Unit = {
        val nowyStanKonta = _stanKonta - wartosc
        if (nowyStanKonta < 0) {
          println("Za malo srodkow na koncie.")
        } else {
          _stanKonta = nowyStanKonta
        }
      }
    }

    val kontoBankowe = new KontoBankowe(1000.0)
    println("Stan konta: " + kontoBankowe.stanKonta)

    println("Wplacam na konto 1000 zl.")
    kontoBankowe.wplata(1000.0)
    println("Stan konta: " + kontoBankowe.stanKonta)

    println("Wyplacam z konta 1500 zl.")
    kontoBankowe.wyplata(1500.0)
    println("Stan konta: " + kontoBankowe.stanKonta)

    println("-----")
  }

  def Zadanie7(): Unit = {
    println("Zadanie 7:")

    case class Osoba(var imie: String, var nazwisko: String)

    def przywitaj(osoba: Osoba): String = {
      osoba match {
        case Osoba("Jan", "Kowalski") => "Dzien dobry, Janie!"
        case Osoba("Adrian", "Nowak") => "Hej, Adrian!"
        case _                        => "Czesc!"
      }
    }

    val jan = Osoba("Jan", "Kowalski")
    val adrian = Osoba("Adrian", "Nowak")
    val ela = Osoba("Ela", "Iksinska")

    println("Wlasnie przybyl Jan: " + przywitaj(jan))
    println("Wlasnie przybyl Adrian: " + przywitaj(adrian))
    println("Wlasnie przybyla Ela: " + przywitaj(ela))

    println("-----")
  }

  def Zadanie8(): Unit = {
    println("Zadanie 8:")

    def usunZera(listaWartosci: List[Int]): List[Int] = {
      if (listaWartosci.isEmpty) {
        List()
      } else {
        if (listaWartosci.head == 0) {
          usunZera(listaWartosci.tail)
        } else {
          listaWartosci.head :: usunZera(listaWartosci.tail)
        }
      }
    }

    val listaWartosciDoTestu = List(0, 1, 2, 0, 3, 4, 0, 0, 5, 6, 0)
    println("Poczatkowa lista wartosci: " + listaWartosciDoTestu.toString())
    println(
      "Lista wartosci po usunieciu zer: " + usunZera(listaWartosciDoTestu)
        .toString()
    )

    println("-----")
  }

  def Zadanie9(): Unit = {
    println("Zadanie 9:")

    def zwiekszOJeden(list: List[Int]): List[Int] = list.map(_ + 1)

    val listaWartosciDoTestu = List(0, 1, 2, 0, 3, 4, 0, 0, 5, 6, 0)
    println("Poczatkowa lista wartosci: " + listaWartosciDoTestu.toString())
    println(
      "Lista wartosci po zwiekszeniu kazdej z liczb o jeden: " + zwiekszOJeden(
        listaWartosciDoTestu
      ).toString()
    )

    println("-----")
  }

  def Zadanie10(): Unit = {
    println("Zadanie 10:")

    def wybierzLiczbyZPrzedzialu(list: List[Double]): List[Double] = {
      list.filter(liczba => liczba >= (-5) && liczba <= 12).map(Math.abs)
    }

    val listaWartosciDoTestu =
      List(0, 1, -5.1, -4.9, 11.9, 12, -5, -6, 13, 12.1)
    println("Poczatkowa lista wartosci: " + listaWartosciDoTestu.toString())
    println(
      "Lista wartosci z przedzialu <-5,12> z poczatkowej listy: " + wybierzLiczbyZPrzedzialu(
        listaWartosciDoTestu
      ).toString()
    )

    println("-----")
  }

  def main(args: Array[String]): Unit = {
    Zadanie1
    Zadanie2
    Zadanie3
    Zadanie4
    Zadanie5
    Zadanie6
    Zadanie7
    Zadanie8
    Zadanie9
    Zadanie10
  }
}
