public class Zadania {

	// zadanie z skokami ostatnie na jakim bylem

	public static void main(String[] args) {
		// zmienne plus wektor z wartosciami
		int i;
		int ilosc_skokow = 310;
		int[] skoki = { 436, 571, 569, 435, 550, 494, 409, 484, 531, 469, 413, 423, 419, 403, 486, 583, 401, 491, 463,
				489, 492, 410, 458, 458, 480, 495, 471, 590, 461, 564, 419, 506, 555, 598, 441, 455, 517, 531, 438, 517,
				446, 549, 505, 543, 496, 577, 404, 551, 405, 524, 540, 421, 535, 582, 598, 419, 441, 551, 491, 565, 466,
				472, 582, 405, 574, 556, 431, 590, 526, 479, 424, 409, 405, 437, 545, 506, 596, 429, 440, 507, 424, 562,
				435, 595, 566, 450, 464, 551, 430, 491, 554, 516, 420, 506, 442, 576, 484, 520, 558, 432, 452, 560, 552,
				450, 584, 462, 596, 566, 404, 558, 449, 534, 467, 436, 509, 579, 527, 439, 433, 576, 536, 496, 567, 575,
				573, 568, 546, 429, 507, 475, 525, 527, 504, 402, 589, 590, 585, 458, 405, 535, 534, 568, 468, 566, 571,
				482, 402, 500, 492, 579, 463, 469, 480, 456, 516, 433, 505, 566, 423, 428, 496, 510, 513, 581, 420, 438,
				485, 433, 447, 567, 600, 581, 534, 470, 518, 601, 406, 542, 437, 440, 464, 509, 494, 464, 414, 563, 471,
				536, 529, 413, 582, 496, 538, 419, 585, 453, 469, 509, 568, 439, 437, 435, 488, 429, 481, 479, 597, 483,
				471, 564, 419, 436, 579, 470, 445, 449, 522, 518, 578, 486, 488, 428, 514, 409, 547, 506, 485, 560, 454,
				460, 550, 527, 453, 416, 461, 558, 583, 419, 487, 523, 498, 405, 433, 483, 504, 512, 418, 570, 417, 527,
				471, 441, 557, 538, 490, 404, 471, 578, 441, 472, 507, 545, 523, 468, 426, 569, 588, 405, 582, 519, 550,
				482, 451, 424, 444, 531, 437, 491, 496, 428, 546, 503, 459, 516, 441, 474, 565, 569, 489, 549, 558, 521,
				490, 422, 560, 494, 517, 460, 423, 562, 549, 414, 531, 578, 524, 490, 501, 488, 508, 469 };

		// wypisuje wszystkie skoki
		System.out.print("Wszystkie skoki:  ");
		for (i = 0; i < ilosc_skokow; i++)
			System.out.print(skoki[i] + "  ");

		System.out.println();

		int seria = 0;
		int seria_ponad_3 = 0;
		// Ile Mateusz miał pozytywnych serii treningowych dłuższych niż 3 dni?

		for (i = 0; i < ilosc_skokow; i++) {
			// ten if (i >= 1) jest spowodowany bledem
			// Exception in thread "main"
			// java.lang.ArrayIndexOutOfBoundsException: -1
			// at zadania.Zadania.main(Zadania.java:40)
			// ktory wystepuje w nastepnym kroku kiedy jest sprawdzana wartosc
			// skoki[i - 1] na samym poczatku mamy i=0 wiec 0-1 daje -1 i sie
			// wykrzacza
			if (i >= 1) {
				// sprawdzdam czy obecny skok jest lepszy od poprzedniego jezeli
				// tak to dodajemy do zmiennej seria +1 jezeli nie
				// to przechodzimy do else gdzie sprawdzane jest czy seria jest
				// wieksza od 3
				if (skoki[i] > skoki[i - 1]) {
					seria++;
				} else {
					// System.out.println("skok numer "+ i + " " + "dlugosc
					// skoku " + skoki[i] + " seria to " + seria);
					if (seria > 3) {
						// jezeli tak to jest seria ktora szukamy w sensie ze
						// trwała dluzej niz 3 dni
						seria_ponad_3++;
						seria = 0;
					} else {
						// jezeli nie przypisujemy do zmiennej seria wartosc 0
						// :(
						seria = 0;
					}
				}
			}
		}
		// polecam odpalenie tego i odkomentowanie "System.out.println(i + " " +
		// skoki[i] + " seria to " +
		// seria);"
		// wtedy ladnie to widac
		System.out.println("Ilosci serii ponad 3 dni  wynosi " + seria_ponad_3);

		// 2. Ile wynoszš długoci najdłuższego oraz najkrótszego skoku
		// Mateusza? Podaj, które to były wyniki, liczšc od poczštku prowadzenia
		// dziennika.
		// przpisuje do zmiennych max i min wartosc 1 skoku/skoki[0]
		int max = skoki[0];
		int min = skoki[0];
		// tworze zmienne w ktorych zapisze ktorego dnia czyli przy jakim i
		// został wykonany skok
		int kiedymax = 0;
		int kiedymin = 0;
		// pętla
		for (i = 0; i < ilosc_skokow; i++) {
			// jezeli skok obecny czyli skoki[i] jest wiekszy od max to zapisz
			// to jako wartosc maksymalna oraz zapisz dzien czyli numer i
			if (skoki[i] > max) {
				max = skoki[i];
				kiedymax = i;
			}
			// jezeli skok obecny czyli skoki[i] jest mniejeszy od min to zapisz
			// to jako wartosc minimalna oraz zapisz dzien czyli numer i
			if (skoki[i] < min) {
				min = skoki[i];
				kiedymin = i;
			}
		}
		// roznca skoków
		int roznica = max - min;
		System.out.println("najlduzszy skok to " + max + " był on " + kiedymax + " dnia" + " najkrotszy to " + min
				+ " odbyl sie " + kiedymin + " dnia" + " roznica skoku wynosi " + roznica);

		// Podaj, z ilu dni składała się jego najdłuższa pozytywna seria
		// treningowa
		// oraz o ile centymetrów poprawił w jej trakcie swój wynik.
		// analogicznie jak w 1 zadaniu tylko ze tutaj staram sie znalesc
		// maksymalna serie
		seria = 0;
		int seriamax = 0;
		int koniecserii = 0;
		for (i = 0; i < ilosc_skokow; i++) {
			if (i >= 1) {
				// sprawdzam czy jest to seria czyli czy wartosc obecna jest
				// wieszka od poprzedniej
				if (skoki[i] > skoki[i - 1]) {
					seria++;
					// jezeli tak to sprawdzam czy jest wieksza od maksymalnej
					if (seria > seriamax) {
						// jezeli tak to przypisuje ja jako maksymalna i
						// zapisuje kiedy koniec serii nastąpił przyda sie do
						// okreslenia dni
						seriamax = seria;
						koniecserii = i;
					}
				} else {
					seria = 0;
				}

			}

		}
		System.out
				.println("Maksymalna seria wynosiła " + (seriamax + 1) + " ,seria skonczyła sie w dniu " + koniecserii);
		System.out.println("Roznica w tej serii wynosiła " + (skoki[koniecserii] - skoki[(koniecserii - seriamax)]));

	}

}

