public class RunRecipes {
    private Recipes recipes;

    public static void main(String[] args) {
        new RunRecipes().run();
    }

    private void run() {
        System.out.println("\nHello and welcome to the digital recipe book menu");
        recipes = new Recipes();
        recipes.StandartRecipes();
        recipes.mainMenu();
    }
}

//TO-DO

//tilføj tilberadnings måde
//Tilføj String tilberedningsMåde til Recipe() i class Recipe og lav getTilberadningsMåde() i class Recipe ikke til toString
//Tilføj metode få tilberadningsMåde() i class Recipes der kalder på getTilberadningsMåde() fra Recipe
//tilføj tilberadningsMåde til mainMenu(9) i class Recipes
//tilføj String variable tilberedningsmåde alle nødvendige steder så objectet Recipe kan oprettetes uden problemr fx starndartRecipe() i class Recipes
//Altså tilføj det som String variable til Recipe objecter men gør det usynligt udover når user ber om det med getTilberadningsMåde()