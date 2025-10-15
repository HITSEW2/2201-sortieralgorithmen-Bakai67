import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] namen = {
                "Anna", "Ben", "Clara", "David", "Emma", "Felix", "Greta", "Hannah", "Jonas", "Laura",
                "Lukas", "Mia", "Noah", "Olivia", "Paul", "Sophie", "Tim", "Lea", "Jan", "Marie",
                "Leon", "Lena", "Nico", "Sarah", "Tom", "Julia", "Max", "Elena", "Fabian", "Mila",
                "Moritz", "Lisa", "Elias", "Johanna", "Simon", "Nina", "Philipp", "Amelie", "Samuel", "Clara",
                "Jonathan", "Isabella", "Tobias", "Emily", "Sebastian", "Franziska", "Matteo", "Charlotte", "Liam", "Luisa"

        };

        buubleSort(namen); //kann geändert werden

        System.out.println("Sortierte Liste mit buubleSort: ");
        for (String naman : namen) {
            System.out.println(naman);
        }

        System.out.println(" ");

        System.out.println("Geben sie an welchen Namen sie Suchen möchten: ");
        String eingabe = sc.nextLine();

        int position = binaeresuche(namen, eingabe);

        if (position == -1) {
            System.out.println(eingabe + " nicht gefunden");
        } else {
            System.out.println(eingabe + " an Position " + position + " gefunden");
        }
    }

    public static void buubleSort(String[] namen) {

        for (int i = 0; i < namen.length - 1; i++) {
            for (int j = 0; j < namen.length - i - 1; j++) {
                if (namen[j].compareTo(namen[j + 1]) > 0) {
                    String temp = namen[j];
                    namen[j] = namen[j + 1];
                    namen[j + 1] = temp;

                }
            }
        }
    }

    public static void selectionSort(String[] namen) {
        for (int i = 0; i < namen.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < namen.length; j++) {
                if (namen[j].compareTo(namen[min]) < 0) {
                    min = j;
                }
            }

            String temp = namen[i];
            namen[i] = namen[min];
            namen[min] = temp;
        }
    }


    public static int binaeresuche(String[] namen, String suche) {

        int links = 0;
        int rechts = namen.length - 1;

        while (links <= rechts) {
            int mitte = (links + rechts) / 2;
            int vergleich = namen[mitte].toLowerCase().compareTo(suche.toLowerCase().trim());

            if (vergleich == 0) {
                return mitte;
            } else if (vergleich < 0) {
                links = mitte + 1;
            } else {
                rechts = mitte - 1;
            }
        }

        return -1;
    }

    //Binaeresuche habe ich bisschen mithilfe von ChatGPT und hauptsächlich mit Jonas gemacht und durchbesprochen
}
