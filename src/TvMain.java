import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class TvMain {
    private ArrayList<TvSeries> shows = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public TvMain() {
        readFromFile();

        while (true) {
            System.out.println("Vad vill du göra");
            System.out.println("(1) Skapa en ny serie");
            System.out.println("(2) Redigera en serie");
            System.out.println("(3) Visa serier");
            System.out.println("(4) Avsluta");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                createShow();

            }else if (choice == 2) {
                editShow();
            }else if (choice == 3) {
                for (TvSeries series : shows) {
                    System.out.println();
                    series.printInfo();
                }
            }

            else if (choice == 4) {
                return;
            }
            else {
                System.out.println("Fel input");
            }
        }
    }


    public void write2File() {
        try {
            FileOutputStream fileOut = new FileOutputStream("ser.ser"); //The stream writing to the file
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut); //The stream describing the object

            //Write to the file
            objectOut.writeObject(shows);

            //Close the streams
            objectOut.close();
            fileOut.close();

            System.out.println("I have WRITTEN!");
        } catch (IOException error) {
            System.out.println("couldn't write to file");
        }
    }

    public void readFromFile() {

        try {
            FileInputStream fileIn = new FileInputStream("ser.ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            //read from file
            shows = (ArrayList<TvSeries>) objectIn.readObject();


            //close the streams
            fileIn.close();
            objectIn.close();

        } catch (Exception error) {
            System.out.println("Could not read from file");
        }
    }

    private void createShow() {
        System.out.println("Vad heter showen?");
        System.out.print(">>> ");
        String showName = sc.nextLine();
        TvSeries series = new  TvSeries(showName);

        System.out.println("Vad har serien för rating?");
        System.out.print(">>> ");
        int rating = sc.nextInt();
        sc.nextLine();
        series.changeRating(rating);
        shows.add(series);
        write2File();
    }
    private void editShow(){
    }
}
