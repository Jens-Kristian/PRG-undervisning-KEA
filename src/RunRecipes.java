public class RunRecipes {

    public static void main(String[] args) {
        new RunRecipes().run();
    }

    private void run() {
        System.out.println("\nHello and welcome to the digital recipe book menu");
        Recipes recipes = new Recipes();
        recipes.StandartRecipes();
        recipes.mainMenu();
    }
}