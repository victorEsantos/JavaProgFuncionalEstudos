import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {

        //consumer
        var listaNomes = asList("João", "Maria", "José");
        percorrerNomesAndPrint(listaNomes, System.out::println);


        //predicate
        var listaNumeros = asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        var listaNumerosPares = percorrerNumeros(listaNumeros, (Integer numero) -> numero % 2 == 0);
        System.out.println(listaNumerosPares);

        //function
        var listaNumerosDobrados = percorrerNumerosParaDobrar(listaNumeros, (numero) -> numero * 2);
        System.out.println("Dobrados: " + listaNumerosDobrados);




    }

    private static List<Integer> percorrerNumerosParaDobrar(List<Integer> listaNumeros, IntFunction<Integer> function) {
        var listaNumerosDobrados = new ArrayList<Integer>();

        for (Integer numero : listaNumeros) {
            listaNumerosDobrados.add(function.apply(numero));
        }

        return listaNumerosDobrados;
    }

    //Poderia tbm utilizar o intPredicate
    private static List<Integer> percorrerNumeros(List<Integer> listaNumeros, Predicate<Integer> predicate) {
        List<Integer> listaNumerosPares = new ArrayList<>();
        for (Integer numero : listaNumeros) {
            if (predicate.test(numero)) {
                listaNumerosPares.add(numero);
            }
        }
        return listaNumerosPares;
    }

    public static void percorrerNomesAndPrint(List<String> lista, Consumer<String> consumer) {
        for (var nome : lista) {
            consumer.accept(nome);
        }
    }
    
}