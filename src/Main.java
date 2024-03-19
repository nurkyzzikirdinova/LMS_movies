import models.Actor;
import models.Genre;
import models.Movie;
import models.Producer;
import service.Impl.ImplMovieFindableService;
import service.Impl.ImplMovieSortableService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ***** Main де кайсыл иш аракетти аткаргыбыз келсе ошол метод switch case аркылуу чакырылып иштесин.
 * <p>
 * Бардык маалыматтар туура жана так болуп консольго чыксын.
 */

public class Main {
    public static void main(String[] args) {

        Actor actor1 = new Actor("Smith Light", "Jek");
        Actor actor2 = new Actor("Sami Ulo", "Mister Bin");
        List<Actor> actors = new ArrayList<>();
        actors.add(actor1);
        actors.add(actor2);


        Producer producer1 = new Producer("Alim", "Sari");
        Producer producer2 = new Producer("Sum", "Kin");
        List<Producer> producers = new ArrayList<>();
        producers.add(producer1);
        producers.add(producer2);


        Movie movie1 = new Movie("Titanic", LocalDate.of(2022, 2, 2), Genre.TRAGEDY, producer1, actors);
        Movie movie2 = new Movie("Rapunzel", LocalDate.of(2002, 2, 1), Genre.MELODRAMA, producer2, actors);
        List<Movie> movies = new ArrayList<>();
        movies.add(movie1);
        movies.add(movie2);

        ImplMovieFindableService implMovieFindableService = new ImplMovieFindableService(movies);
        ImplMovieSortableService implMovieSortableService = new ImplMovieSortableService(movies);
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("""
                    1. Get all movies
                    2. Find movie by name (part/full)
                    3. Find movie by actor name
                    4. Find movie by year
                    5. Find movie by producer
                    6. Find movie by genre
                    7. Find movie by role
                    8. Sort movie by name
                    9. Sort movie by year
                    10.Sort movie by producer
                    0. Exit
                    """);
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("All movies: ");
                    for (Movie allMovie : implMovieFindableService.getAllMovies()) {
                        System.out.println(allMovie);
                    }break;
                case 2:
                    System.out.println("Find movie by full name or part name: ");

                    String movieName = scanner.next();
                    Movie foundMoviem = implMovieFindableService.findMovieByFullNameOrPartName(movieName);
                    System.out.println(foundMoviem);
                    if (foundMoviem != null) {
                        System.out.println("models.models.Movie is found: ");
                    } else {
                        System.out.println("models.models.Movie not found.");
                    }
                    break;
                case 3:
                    System.out.println("Write: ");
                    String actorName = new Scanner(System.in).nextLine();
                    Movie foundActor = implMovieFindableService.findMovieByActorName(actorName);
                    if (foundActor != null) {
                        System.out.println("models.models.Movie is found: " + foundActor.getActors());
                    } else {
                        System.out.println("models.models.Movie not found.");
                    }

                    break;

                case 4:
                    System.out.println("Write year: ");
                    LocalDate year1 = LocalDate.of(scanner.nextInt(),  scanner.nextInt(), scanner.nextInt());
                    Movie d =  implMovieFindableService.findMovieByYear(year1);
                    if(d!= null){
                        System.out.println(d);
                    }else{
                        System.out.println("models.models.Movie not found.");
                    }
                    break;
                case 5:
                    System.out.println("Write name producer: ");
                    String producer = new Scanner(System.in).nextLine();
                    Movie pr = implMovieFindableService.findMovieByProducer(producer);
                    if (pr!=null){
                        System.out.println(pr);
                    }else{
                        System.out.println("models.models.Movie not found.");
                    }

                    break;
                case 6:
                    System.out.println("Write genre: ");
                    String genre = new Scanner(System.in).nextLine();
                    Movie gen = implMovieFindableService.findMovieByGenre(Genre.valueOf(genre));
                    if(gen!=null){
                        System.out.println(gen);
                    }else{
                        System.out.println("models.models.Movie not found.");
                    }
                    break;
                case 7:
                    System.out.println("Write role: ");
                    String role = new Scanner(System.in).nextLine();
                    Movie rol = implMovieFindableService.findMovieByRole(role);
                    if(rol!=null){
                        System.out.println(rol);
                    }else{
                        System.out.println("Not found");
                    }
                    break;
                case 8 :
                    System.out.print("Sort movies by name: ");
                    String orderByName = scanner.next();
                  implMovieSortableService.sortMovieByName(orderByName);
                    System.out.println("Movies sorted by name:");
                    for (Movie movie : movies) {
                        System.out.println(movie.getName());
                    }
                    break;
                case 9 :
                    System.out.println("Movies sorted by year:");
                   String choose = new Scanner(System.in).nextLine();
                    implMovieSortableService.sortByYear(choose);
                    for (Movie movie : movies) {
                        System.out.println(movie.getName() + " (" + movie.getYear() + ")");
                    }
                    break;
                case 10:
                    System.out.println("Movies sorted by producer's name:");
                    String choose1 = new Scanner(System.in).nextLine();
                    implMovieSortableService.sortByProducer(choose1);
                    for (Movie movie : movies) {
                        System.out.println("Name of producer: "+movie.getName() + " <" + movie.getProducer().getFirstName() + ">");
                    }
                    break;

                case 0:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 0);

        scanner.close();
    }

}

