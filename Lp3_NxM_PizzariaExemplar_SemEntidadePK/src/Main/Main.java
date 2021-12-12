package Main;

import DAOs.DAOIngrediente;
import DAOs.DAOPizza;
import Entidades.Ingrediente;
import Entidades.Pizza;
import java.util.List;

/**
 *
 * @author radames
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DAOIngrediente daoIngrediente = new DAOIngrediente();
        List<Ingrediente> listaIngrediente = daoIngrediente.list();
        for (Ingrediente atividade : listaIngrediente) {
            System.out.println(atividade.getIdIngrediente() + "-" + atividade.getNomeIngrediente());
        }

        //Insert
        Ingrediente ingrediente = new Ingrediente();
        List<Pizza> listaDePizzasQueTemOIngrediente = ingrediente.getPizzaList();

//        ingrediente.setIdIngrediente(9);
//        ingrediente.setNomeIngrediente("Frango");
//        daoIngrediente.inserir(ingrediente);
//        Insert na tabela relacional
//        ingrediente = daoIngrediente.obter(1);
//        listaDePizzasQueTemOIngrediente.add(new DAOPizza().obter(4));
//        
//        ingrediente.setPizzaList(listaDePizzasQueTemOIngrediente);
//        daoIngrediente.atualizar(ingrediente);
//        Update na tabela relacional
//        Remover o ingrediente(5 - milho) da pizza (2 - marguerita)

        ingrediente = daoIngrediente.obter(5);
        listaDePizzasQueTemOIngrediente = ingrediente.getPizzaList();
        System.out.println("Ingrediente " + ingrediente.getIdIngrediente() + " - " + ingrediente.getNomeIngrediente());
        for (Pizza pizza : listaDePizzasQueTemOIngrediente) {
            System.out.println("Pizza " + pizza.getIdPizza() + " - " + pizza.getNomePizza());
        }

        listaDePizzasQueTemOIngrediente.remove(new DAOPizza().obter(2));
        System.out.println(" ---- após remover a lista fica assim ----");
        for (Pizza pizza : listaDePizzasQueTemOIngrediente) {
            System.out.println("Pizza " + pizza.getIdPizza() + " - " + pizza.getNomePizza());
        }

        ingrediente.setPizzaList(listaDePizzasQueTemOIngrediente);
        daoIngrediente.atualizar(ingrediente);
        
        //quais pizzas tem o ingrediente?
        ingrediente = daoIngrediente.obter(5);
        listaDePizzasQueTemOIngrediente = ingrediente.getPizzaList();
        System.out.println("Ingrediente " + ingrediente.getIdIngrediente() + " - " + ingrediente.getNomeIngrediente());
        for (Pizza pizza : listaDePizzasQueTemOIngrediente) {
            System.out.println("Pizza " + pizza.getIdPizza() + " - " + pizza.getNomePizza());
        }
        

        //Select
//        ingrediente = daoIngrediente.obter(1);
//        System.out.println("\n\nPizzas que tem o ingrediente >> " + ingrediente.getNomeIngrediente() + "<<");
//        listaDePizzasQueTemOIngrediente = ingrediente.getPizzaList();
//        for (Pizza pizza : listaDePizzasQueTemOIngrediente) {
//            System.out.println(pizza.getNomePizza());
//        }
        //Delete
    }
}
