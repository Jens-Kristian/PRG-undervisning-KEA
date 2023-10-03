import java.util.ArrayList;
import java.util.Scanner;

public class Recipes {
    private final ArrayList<Recipe> recipeList;
    private final ArrayList<String> shopingList;
    private final ArrayList<Recipe> breakfast;
    private final ArrayList<Recipe> lunch;
    private final ArrayList<Recipe> dinner;
    private final ArrayList<Recipe> dessert;


    public Recipes() {
        recipeList = new ArrayList<>();
        breakfast = new ArrayList<>();
        lunch = new ArrayList<>();
        dinner = new ArrayList<>();
        dessert = new ArrayList<>();
        shopingList = new ArrayList<String>();
    }

    public void initializeRecipes() {
        addRecipe("Pancake", "Flour, Eggs, Milk", 15, 5);
        addRecipe("Salad", "Lettuce, Tomato, Cucumber", 10, 4);
        addRecipe("Spaghetti", "Pasta, Tomato Sauce", 30, 4);
    }

    public void addRecipe(String name, String ingredients, int time, int rating) {
        Recipe newRecipe = new Recipe(name, ingredients, time, rating);
        recipeList.add(newRecipe);
    }


    public void mainMenu() {
        System.out.println("Hello and welcome to the digital recipe book menu\nWould you like to:\n");
        System.out.println("See the hole Recipe Collection. Type '1'");
        System.out.println("Search after a recipe. Type '2'");
        System.out.println("Create your own recipe. Type '3'");
        System.out.println("Delete one of the recipes. Type '4'");
        System.out.println("Add To category. Type '5'");
        System.out.println("Shopping list settings. Type '6'");
        System.out.println("Rate a recipe. Type '7'");
        System.out.println("Exit the recipe book. Type '0'");
        menu();
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        switch (i) {
            case 1 -> menuIntro();
            case 2 -> search();
            case 3 -> createRecipe();
            case 4 -> deleteRecipe();
            case 5 -> addToCategory();
            case 6 -> shoppingListSettings();
            case 7 -> rateRecipe();
            case 0 -> {
                System.out.println("exting....");
                System.exit(0);
            }


        }
    }

    public void menuIntro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to our Recipe Collection!");
        for (Recipe recipe : recipeList) {
            System.out.println(recipe);
        }
        System.out.println("\nBack To Main Menu. TYPE '1'");
        int i = scanner.nextInt();
        switch (i) {
            case 1 -> mainMenu();
        }
    }

    public void search() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("search by : ");
        System.out.println("Name. Type '1'");
        System.out.println("Ingredient. Type '2'");
        System.out.println("Category. Type '3'");
        System.out.println("Back to main menu '4'");

        int choice = scanner.nextInt();
        scanner.nextLine(); //scanner bug

        switch (choice) {
            case 1:
                System.out.println("Enter the name of the Dish:");
                String dishName = scanner.nextLine();
                boolean foundByName = false;
                for (Recipe recipe : recipeList) {
                    if (recipe.getName().equalsIgnoreCase(dishName)) {
                        System.out.println(recipe);
                        foundByName = true;
                        mainMenu();
                    }
                }
                if (!foundByName) {
                    System.out.println("No recipes found with the name: " + dishName);
                    mainMenu();
                }
                break;

            case 2:
                System.out.println("Enter the ingredient:");
                String ingredient = scanner.nextLine();
                boolean foundByIngredient = false;
                for (Recipe recipe : recipeList) {
                    String[] ingredients = recipe.getIngredients().split(", ");
                    for (String ing : ingredients) {
                        if (ing.equalsIgnoreCase(ingredient)) {
                            System.out.println(recipe);
                            foundByIngredient = true;
                            mainMenu();
                            break;
                        }
                    }
                }
                if (!foundByIngredient) {
                    System.out.println("No recipes found with the ingredient: " + ingredient);
                    mainMenu();
                }
                break;

            case 3:
                System.out.println("Choose a Category:");
                System.out.println("1. Breakfast\n2. Lunch\n3. Dinner\n4. Dessert");
                int categoryChoice = scanner.nextInt();
                scanner.nextLine();  // scanner bug

                switch (categoryChoice) {
                    case 1:
                        for (Recipe recipe : breakfast) {
                            System.out.println(recipe.getName());
                        }
                        break;
                    case 2:
                        for (Recipe recipe : lunch) {
                            System.out.println(recipe.getName());
                        }
                        break;
                    case 3:
                        for (Recipe recipe : dinner) {
                            System.out.println(recipe.getName());
                        }
                        break;
                    case 4:
                        for (Recipe recipe : dessert) {
                            System.out.println(recipe.getName());
                        }
                        break;
                    default:
                        System.out.println("Invalid category choice.");
                }
                break;
            case 4:
                mainMenu();
                break;

            default:
                System.out.println("Invalid choice!");
                mainMenu();
                break;


        }
    }

    public void createRecipe() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What's the name off the recipe?");
        String name = scanner.nextLine();
        System.out.println("Whats is the ingredients? IMPORTANT TO USE CSV FORMAT!!!!");
        String ingredients = scanner.nextLine();
        System.out.println("Whats the recipes estimated time? fx (60) in minutes");
        int estimatedtime = scanner.nextInt();
        System.out.println("What would you rate this dish? from 1-10");
        int rating = scanner.nextInt();
        addRecipe(name, ingredients, estimatedtime, rating);
        System.out.println("Successful");
        System.out.println("Recipe name: " + name +
                "\nIngredients: " + ingredients +
                "\nEstimated Time: " + estimatedtime +
                "\nRating: " + rating +
                "\n------------------------------");
        System.out.println("\nBack To Main Menu. TYPE '1'");
        int i = scanner.nextInt();
        switch (i) {
            case 1 -> mainMenu();
        }
    }

    public void deleteRecipe() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the Dish you want to delete:");
        String dishName = scanner.nextLine();
        boolean foundByName = false;
        for (Recipe recipe : recipeList) {
            if (recipe.getName().equalsIgnoreCase(dishName)) {
                System.out.println(recipe);
                foundByName = true;
                System.out.println("Are you sure you want to delete dish? y/n");
                String yesNO = scanner.nextLine();
                if (yesNO.equalsIgnoreCase("y")) {
                    recipeList.remove(recipe);
                    System.out.println("Successful deletion");
                    mainMenu();
                }
            }
        }
        if (!foundByName) {
            System.out.println("No recipes found with the name: " + dishName);
            mainMenu();
        }
        mainMenu();
    }

    public void addToCategory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the Dish you want to Categorise:");
        String dishName = scanner.nextLine();
        boolean foundByName = false;
        for (Recipe recipe : recipeList) {
            if (recipe.getName().equalsIgnoreCase(dishName)) {
                System.out.println(recipe);
                foundByName = true;
                System.out.println("What category do you want to add? [breakfast, lunch, dinner, dessert]");
                String category = scanner.nextLine().toLowerCase();
                switch (category) {
                    case "breakfast" -> {
                        breakfast.add(recipe);
                        System.out.println("Success");
                    }
                    case "lunch" -> {
                        lunch.add(recipe);
                        System.out.println("Success");
                    }
                    case "dinner" -> {
                        dinner.add(recipe);
                        System.out.println("Success");
                    }
                    case "dessert" -> {
                        dessert.add(recipe);
                        System.out.println("Success");
                    }
                    default -> System.out.println("Invalid category.");
                }
                mainMenu();
            }
        }
        if (!foundByName) {
            System.out.println("No recipes found with the name: " + dishName);
        }
        mainMenu();
    }

    public void shoppingListSettings() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have the following options:");
        System.out.println("1. Add to shopping cart");
        System.out.println("2. See shopping cart");
        System.out.println("3. Empty shopping cart");
        System.out.println("4. Main menu");
        int option = scanner.nextInt();
        scanner.nextLine(); // Scanner bug

        switch (option) {
            case 1:
                System.out.println("Enter the name of the Dish:");
                String dishName = scanner.nextLine();
                boolean foundByName = false;
                for (Recipe recipe : recipeList) {
                    if (recipe.getName().equalsIgnoreCase(dishName)) {
                        System.out.println(recipe);
                        foundByName = true;
                        shopingList.add(recipe.getIngredients());
                    }
                }
                if (!foundByName) {
                    System.out.println("No recipes found with the name: " + dishName);
                }
                shoppingListSettings();
                break;
            case 2:
                System.out.println("Your shopping cart contains:");
                for (String ingredient : shopingList) {
                    System.out.println(ingredient);
                }
                shoppingListSettings();
                break;
            case 3:
                shopingList.clear();
                System.out.println("Shopping cart emptied.");
                shoppingListSettings();
                break;
            case 4:
                mainMenu();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                shoppingListSettings();
                break;
        }
    }
    public void rateRecipe() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the Dish you want to Rate:");
        String dishName = scanner.nextLine();
        boolean foundByName = false;
        for (Recipe recipe : recipeList) {
            if (recipe.getName().equalsIgnoreCase(dishName)) {
                System.out.println(recipe);
                foundByName = true;
                System.out.println("What do you want to rate this dish? 1-10");
                int rating = scanner.nextInt();
                recipe.setRating(rating);
                System.out.println("Rating updated!");
                mainMenu();
            }
        }
        if (!foundByName) {
            System.out.println("No recipes found with the name: " + dishName);
            mainMenu();
        }
    }

}