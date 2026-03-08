import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SistemaTickets sistema = new SistemaTickets();

        int opcion;

        do {

            System.out.println("\n=== SISTEMA DE TICKETS ===");
            System.out.println("1. Menú Usuario");
            System.out.println("2. Menú Administrador");
            System.out.println("3. Salir");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    menuUsuario(sc, sistema);
                    break;

                case 2:
                    menuAdmin(sc, sistema);
                    break;

            }

        } while (opcion != 3);

        System.out.println("Sistema finalizado.");
    }

    public static void menuUsuario(Scanner sc, SistemaTickets sistema) {

        int op;

        do {

            System.out.println("\n--- MENÚ USUARIO ---");
            System.out.println("1. Crear ticket");
            System.out.println("2. Buscar ticket resuelto");
            System.out.println("3. Volver");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {

                case 1:

                    System.out.println("Nombre completo:");
                    String nombre = sc.nextLine();

                    System.out.println("Descripción del problema:");
                    String descripcion = sc.nextLine();

                    sistema.crearTicket(descripcion, nombre);

                    break;

                case 2:

                    System.out.println("Ingrese ID del ticket:");
                    int id = sc.nextInt();

                    sistema.buscarTicketResuelto(id);

                    break;
            }

        } while (op != 3);
    }

    public static void menuAdmin(Scanner sc, SistemaTickets sistema) {

        int op;


        do {

            System.out.println("\n--- MENÚ ADMIN ---");
            System.out.println("1. Ver ticket pendiente");
            System.out.println("2. Resolver ticket");
            System.out.println("3. Volver");

            op = sc.nextInt();

            switch (op) {

                case 1:
                    sistema.verTicketPendiente();
                    break;

                case 2:
                    sistema.resolverTicket();
                    break;

            }

        } while (op != 3);
    }
}