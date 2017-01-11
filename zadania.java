package wypisz2;

class Wypisz2 {
	// zbiór kilku operacji na wektorach, nie robilem za kazdym razem nowego
	// tylko operowałem na tym samym, nie chcialo mi sie co
	// chwila generować

	public static void main(String Args[]) {
		// zmienna typu int ktora zostanie uzyta jako jako długość wektora
		int ilw = 50;
		// inicjalizacja wektora o długości naszej zmiennej ilw podanej powyzej
		int[] wek = new int[ilw];
		// zmienna pomocnicze
		int i;

		// opis pentli na http://javastart.pl/static/podstawy-jezyka/petle/
		for (i = 0; i < ilw; i++) {
			// dla kazdej kolejnej wartosci wek[1],wek[2],wek[3]... jest
			// generowana losowa wartość z zakresu 0-50 z funkcji math.random
			wek[i] = (int) (50 * Math.random() + 1);
		}

		// to w sumie nie wiem czy bylo w zadaniach :D, wyswietlanie wektora
		// zapisujaca tylko po 15 elementow w wierszu
		// efekt koncowy wyglada tak
		// Wektor:
		// 1 3 9 35 29 47 49 46 2 44 3 25 32 26 21
		// 44 17 20 3 24 20 40 45 20 4 22 15 17 36 2
		// 19 9 14 7 47 48 42 15 19 4 48 2 24 11 4
		// 9 34 24 5 9

		// kolejna zmienna pomocnicza tylko ze teraz od razu przypisuje do niej
		// wartosc 0
		int licznik = 0;

		// wyswietlamy tekst na konsole --- System.out.println (warto pamietac
		// ze System.out.println -- wyswietla nowa linie a
		// System.out.print dopisuje do biezacej lini)
		System.out.println("Wektor:");

		// rozpoczynamy pętle for ktora ma przeiterować się po wszystkich
		// elementach wektora wyświetlając po 15 elementów w kazdej z lini
		for (i = 0; i < ilw; i++) {
			// wyswietl wartosc wek od i, plus dodaj spacje po kazdej wartosci
			System.out.print(wek[i] + "  ");

			// dodaj do zmiennej pomocnicznej licznik w kazdej
			// iteracji/przejsciu przez petle 1
			licznik = licznik + 1;

			// jezeli licznik osiagnie wartosc 15 wejdz w ten warunek i wykonaj
			// System.out.println(); czyli dodaj nowa linie oraz wyzeruj licznik
			if (licznik == 15) {
				System.out.println();
				licznik = 0;
			}
		}

		// Obliczanie sumy parzystych i niepatrzystych
		// zmienne pomocnicze
		int sumapar = 0;
		int sumaniepar = 0;

		// start pętli iterujacej sie przez wszystkie elementy wektora
		for (i = 0; i < ilw; i++) {
			// jezeli liczba jest jest podzielna przez dwa to dodaj ja do sumy
			// parzystych
			if ((wek[i] % 2) == 0) {
				sumapar = sumapar + wek[i];
				// jezeli nie no to dodaj ja do sumy nieparzystych
			} else {
				sumaniepar = sumaniepar + wek[i];
			}
		}
		// wyswietlamy waartosci wraz z komentarzem efekt:
		// Suma parzystych = 576
		// Suma nieparzystych = 707

		System.out.println();
		System.out.println("Suma parzystych = " + sumapar);
		System.out.println("Suma nieparzystych = " + sumaniepar);

		// suma co drugi element wektora. Wszystko odbywa sie analogicznie do
		// poprzednich pentli tylko ze tutaj
		// przy kazdym przejsciu do i nie jest dodawany 1 tylko 2 "i += 2"
		// wek[0], wek[2],wek[4]... itd itd
		// kolejna zmienna pomocnicza
		int sumacodwa = 0;
		for (i = 0; i < ilw; i += 2) {
			sumacodwa = sumacodwa + wek[i];
		}
		System.out.println("Suma co drugiego elementu to: " + sumacodwa);

		// to samo co powyzej tylko ze teraz jest co 3 element, wiec do i
		// dodawana jest 3 "i += 3"
		int sumacotrzy = 0;
		// Suma co trzeciego elementu
		for (i = 0; i < ilw; i += 3) {
			sumacotrzy = sumacotrzy + wek[i];
		}
		System.out.println("Suma co trzeciego elementu to: " + sumacotrzy);

		// wyswietlenie najpierw liczb parzystych a potem nieparzystych
		// ma potrzeby tego potrzebujemy kolejny pusty wektor o takiej samej
		// dlugosci jak wektor wek
		// utworzenie wektora
		int[] nwek = new int[ilw];
		// zmienna pomocnicza
		int j = 0;
		// zmienna pomocnicza o wartosci o 1 mniejszej niz dlugosc wektora, ze
		// wzgledu na to ze java zawsze liczy od 0
		// wiec wektor nie ma zmiennych od wek[1] do wek[50] tylko od wek[0] do
		// wek[49]
		// mozna by na sztywno wpisać 49 ale w takim podjesciu jak teraz
		// zmieniajac ilw na 100 na początku kodu, wszystko powinno przejsc
		// gladko
		int k = ilw - 1;
		// nowa pętla
		for (i = 0; i < ilw; i++) {
			// jezeli liczba jest parzysta to przypisz do wek[j] wartosć wek[i]
			// i dodaj do j wartosc 1
			if (wek[i] % 2 == 0) {
				nwek[j] = wek[i];
				j++;
				// w przeciwnym wypadku czyli jezeli liczba jest nieparzysta
				// przypisz ja do konca wektora i odejmij od k wartosc 1
			} else {
				nwek[k] = wek[i];
				k--;
			}
		}
		// przyklad
		// jest wektor 2,5,3,2,7
		// zmienna i=5 k=4 j=0
		// pierwsza iteracja wek[0]=2
		// wiec przypisz do wartosci wek[j] gdzie w tym momencie j wynosi 0
		// wartosc 2 i nastepnie dodaj do i wartosc 1
		// wpadamy w kolejna iteracje i=1 wek[1]=5 wiec nie wpadnie w if tylko
		// do elsa
		// wiec przypisz do wartosci nwek[4] bo j=4 wartosc 5 oraz odejmij od j
		// wartosc 1
		// teraz wektor nwek wyglada tak 2,null,null,null,5
		// trzecia iteracja wek[2]=3 wiec wpada w else, wiec przypisz do wek[j]
		// gdzie teraz j=3 wartosc 3.
		// wektor teraz wygladalby 2,null,null,3,5 itd itd az uzpelni wszystkie
		// wartosci

		// wypisuje wektor wynikowy
		System.out.println("Wektor wynikowy:");
		for (i = 0; i < ilw; i++)
			System.out.print(nwek[i] + "  ");

		System.out.println();

		// wyswietlanie nowego podzielonego juz na parzyste i nieparzyste
		// wektora, z tym warunkiem ze nieparzyste maja byc od nowej lini

		int temp = 0;
		for (i = 0; i < ilw; i++) {
			if (temp == 0) {
				// caly czas wyswietla wartosci jezeli liczby sa podzielne przez
				// 2 jezeli nie
				if (nwek[i] % 2 == 0) {
					System.out.print(nwek[i] + "  ");
				}
				// to wpadnie tutaj i wyswietli pusta linie i nowa wartosc a
				// nastepnie ze zmienna temp bedzie wynosila
				// 1 to juz nie bedzie walidował czy liczba jest parzysta
				else {
					System.out.println();
					System.out.print(nwek[i] + "  ");
					temp = 1;
				}
				// tylko wpadnie tutaj i bedzie wyswietlał wartosci
			} else {
				System.out.print(nwek[i] + "  ");
			}
		}

		System.out.println();
		System.out.println("Sortowanie przez proste wstawianie ");
		// zmienna logiczna przyjmujaca wartość logiczna True lub false
		boolean szuk_miejsca;
		// sortowania jest od metra w sieci wiec https://youtu.be/Bd5CBA4QRb4
		// http://www.algorytm.org/algorytmy-sortowania/sortowanie-przez-wstawianie-insertionsort.html
		int pom;
		// sortowanie
		for (i = 0; i < ilw - 1; i++) {
			pom = wek[i + 1];
			szuk_miejsca = (wek[i] > pom);
			j = i;
			while (szuk_miejsca) {
				wek[j + 1] = wek[j];
				j--;
				if (j >= 0)
					szuk_miejsca = (wek[j] > pom);
				else
					szuk_miejsca = false;
			}
			wek[j + 1] = pom;
			// wypisywanie kolejnych faz

		}
		// wypisuje posortowany wektor
		System.out.println("Wektor posortowany   : ");
		for (i = 0; i < ilw; i++)
			System.out.print(wek[i] + "  ");
		System.out.println();

		// zadanie 10

		System.out.println();
		System.out.println("Generuje unikalny 15 elementowy wektor z 40 elementow");

		// nowy wektor i nowe zmienne pomocnicze
		int ilw2 = 15;
		int[] wek2 = new int[ilw2];
		int u;
		int x;

		for (u = 0; u < ilw2; u++) {
			// generuje liczbe z losowa liczbe z zakresu 1-40
			wek2[u] = (int) (40 * Math.random() + 1);
			// i teraz za kadzym razem sprawdzam czy wartosc ta juz nie
			// wystapiła w wektorze
			// ten print ponizej dobrze przestawia zasade dzialania
			// przykladowy output
			// wartosc 18 miejsce w wektorze wek2 0
			// wartosc 4 miejsce w wektorze wek2 1
			// wartosc 16 miejsce w wektorze wek2 2
			// wartosc 30 miejsce w wektorze wek2 3
			// wartosc 38 miejsce w wektorze wek2 4
			// wartosc 28 miejsce w wektorze wek2 5
			// wartosc 7 miejsce w wektorze wek2 6
			// wartosc 26 miejsce w wektorze wek2 7
			// wartosc 30 miejsce w wektorze wek2 8
			// wartosc 17 miejsce w wektorze wek2 8
			// wartosc 21 miejsce w wektorze wek2 9
			// wartosc 5 miejsce w wektorze wek2 10
			// wartosc 27 miejsce w wektorze wek2 11
			// wartosc 33 miejsce w wektorze wek2 12
			// wartosc 39 miejsce w wektorze wek2 13
			// wartosc 17 miejsce w wektorze wek2 14
			// wartosc 40 miejsce w wektorze wek2 14
			// widac ze wartosc 30 pojawila sie na miejscu 3 wiec nie mogla
			// zostac wpisana na miejsce 8 dlatego zostala wylosowana jeszcze
			// raz, jednak ten sposob nie zadziala w kazdym języku
			System.out.println("wartosc " + wek2[u] + " miejsce w wektorze wek2  " + u);
			for (x = 0; x < u; x++) {
				if (wek2[x] == wek2[u]) {
					u--;
				}
			}
		}

		for (u = 0; u < ilw2; u++) {
			System.out.print(wek2[u] + "  ");
		}

	}// main
}// Wypiszn

