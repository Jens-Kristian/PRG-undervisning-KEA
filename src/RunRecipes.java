public class RunRecipes {
    private Recipes recipes;

    public static void main(String[] args) {
        new RunRecipes().run();
    }

    private void run() {
        System.out.println("Hello and welcome to the digital recipe book menu");
        recipes = new Recipes();
        recipes.StandartRecipes();
        recipes.mainMenu();
    }
}

