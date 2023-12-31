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
        shopingList = new ArrayList<>();
    }

    public void StandartRecipes() {
        Recipe pancake = new Recipe("Pancake", "Flour, Eggs, Milk", 15, 10,"Mix 1 cup flour, 2 eggs, and 1 cup milk to form a batter; cook on a hot pan until golden.","No comment");
        recipeList.add(pancake);
        dessert.add(pancake);

        Recipe salad = new Recipe("Salad", "Lettuce, Tomato, Cucumber", 10, 4,"Chop lettuce, tomato, and cucumber; toss together for a fresh salad.","No comment");
        recipeList.add(salad);
        lunch.add(salad);

        Recipe spaghetti = new Recipe("Spaghetti", "Pasta, Tomato Sauce", 30, 7,"Boil pasta until al dente; drain and mix with heated tomato sauce.","No comment");
        recipeList.add(spaghetti);
        dinner.add(spaghetti);

        Recipe englishBreakfast = new Recipe("English breakfast", "Beans, eggs, bacon", 30, 2,"Fry bacon until crisp, scramble eggs, and heat beans; serve together for a classic English breakfast.","No comment");
        recipeList.add(englishBreakfast);
        breakfast.add(englishBreakfast);
        }

    public void mainMenu() {
        System.out.println("\nWould you like to:\n");
        System.out.println("See the hole Recipe Collection. Type '1'");
        System.out.println("Search after a recipe. Type '2'");
        System.out.println("Create your own recipe. Type '3'");
        System.out.println("Delete one of the recipes. Type '4'");
        System.out.println("Add Recipe To category. Type '5'");
        System.out.println("Access digital Shopping list. Type '6'");
        System.out.println("Change rating off recipe. Type '7'");
        System.out.println("Add/change recipe comment. Type '8'");
        System.out.println("See Method of Preparation. Type '9' ");
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
            case 8 -> addcomment();
            case 9 -> getPreparationRecipe();
            case 0 -> {
                System.out.println("exting....");
                System.exit(0);
            }
        }
    }

    public void menuIntro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to our Recipe Collection!");
        System.out.println("------------------------------");
        for (Recipe recipe : recipeList) {
            System.out.println(recipe);
        }
        System.out.println("\nBack To Main Menu. TYPE '1'");
        int i = scanner.nextInt();
        if (i == 1) {
            mainMenu();
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
            case 1 -> {
                System.out.println("Enter the name of the recipe:");
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
            }
            case 2 -> {
                System.out.println("Enter the ingredient:");
                String ingredient = scanner.nextLine();
                boolean foundByIngredient = false;
                for (Recipe recipe : recipeList) {
                    String[] ingredients = recipe.getIngredients().split(", ");
                    for (String ing : ingredients) {
                        if (ing.equalsIgnoreCase(ingredient)) {
                            System.out.println(recipe);
                            foundByIngredient = true;
                            break;
                        }
                    }
                }
                if (!foundByIngredient) {
                    System.out.println("No recipes found with the ingredient: " + ingredient);
                    mainMenu();
                }
            }
            case 3 -> {
                System.out.println("Choose a Category:");
                System.out.println("1. Breakfast\n2. Lunch\n3. Dinner\n4. Dessert");
                int categoryChoice = scanner.nextInt();
                scanner.nextLine();  // scanner bug
                switch (categoryChoice) {
                    case 1 -> {
                        for (Recipe recipe : breakfast) {
                            System.out.println(recipe);
                        }mainMenu();
                    }
                    case 2 -> {
                        for (Recipe recipe : lunch) {
                            System.out.println(recipe);
                        }mainMenu();
                    }
                    case 3 -> {
                        for (Recipe recipe : dinner) {
                            System.out.println(recipe);
                        }mainMenu();
                    }
                    case 4 -> {
                        for (Recipe recipe : dessert) {
                            System.out.println(recipe);
                        }mainMenu();
                    }
                    default -> System.out.println("Invalid category choice.");

                }
            }
            case 4 -> mainMenu();
            default -> {
                System.out.println("Invalid choice!");
                mainMenu();
            }
        }
        mainMenu();
    }

    public void createRecipe() {
        Scanner scanner = new Scanner(System.in);
        String newName="no name found";
        System.out.println("What's the name off the recipe?");
        String mabyeNewName = scanner.nextLine();
        for (Recipe recipe : recipeList)
            if (recipe.getName().equalsIgnoreCase(mabyeNewName)){
            System.out.println("Duplicate name");
            createRecipe();
        }else{
                newName = mabyeNewName;
        }
        System.out.println("Whats is the ingredients? fx (tomato, bananas, cucumber)");
        String ingredients = scanner.nextLine();
        System.out.println("Whats the recipes estimated time? fx (60) in minutes");
        int estimatedtime = scanner.nextInt();
        System.out.println("What would you rate this dish? from 1-10");
        int rating = scanner.nextInt();
        scanner.nextLine(); //scanner bug
        System.out.println("How do you prepare the recipe? (1 line String)");
        String prepareRecipe = scanner.nextLine();
        System.out.println("Do you have any comments?");
        String comment = scanner.nextLine();
        Recipe newRecipe = new Recipe(newName, ingredients, estimatedtime, rating, prepareRecipe, comment);
        recipeList.add(newRecipe);
        System.out.println("Successful");
        System.out.println("Recipe name: " + newName +
                "\nIngredients: " + ingredients +
                "\nEstimated Time: " + estimatedtime +
                "\nRating: " + rating +
                "\nHow to Prepare: "+prepareRecipe+
                "\nComment: "+comment +
                "\n------------------------------");
        System.out.println("\nBack To Main Menu. TYPE '1'\nCreate another Recipe. TYPE '2'");
        int i = scanner.nextInt();
        if (i == 1) {
            mainMenu();
        }else if(i==2){
            createRecipe();
        }else {
            System.out.println("Not valid, back to main menu");
            mainMenu();
        }
    }

    public void deleteRecipe() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the recipe you want to delete:");
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
                    breakfast.remove(recipe);
                    lunch.remove(recipe);
                    dinner.remove(recipe);
                    dessert.remove(recipe);
                    System.out.println("Successful deletion");
                    mainMenu();
                }System.out.println("Deletion failed");mainMenu();
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
        System.out.println("Enter the name of the recipe you want to Categorise:");
        String dishName = scanner.nextLine();
        boolean foundByName = false;
        for (Recipe recipe : recipeList) {
            if (recipe.getName().equalsIgnoreCase(dishName)) {
                System.out.println(recipe);
                foundByName = true;
                System.out.println("What category do you want to add "+recipe.getName()+" to? [breakfast, lunch, dinner, dessert]");
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
        System.out.println("1. Add recipe ingredients to shopping cart");
        System.out.println("2. See shopping cart");
        System.out.println("3. Empty shopping cart");
        System.out.println("4. Main menu");
        int option = scanner.nextInt();
        scanner.nextLine(); // Scanner bug

        switch (option) {
            case 1 -> {
                System.out.println("Enter name of recipe:");
                String dishName = scanner.nextLine();
                boolean foundByName = false;
                for (Recipe recipe : recipeList) {
                    if (recipe.getName().equalsIgnoreCase(dishName)) {
                        System.out.println(recipe);
                        foundByName = true;
                        shopingList.add(recipe.getIngredients());
                        System.out.println("Success");
                    }
                }
                if (!foundByName) {
                    System.out.println("No recipes found with the name: " + dishName);
                }
                shoppingListSettings();
            }
            case 2 -> {
                System.out.println("Your shopping cart contains:\n");
                for (String ingredient : shopingList) {
                    System.out.println(ingredient);
                }
                System.out.println(" ");
                shoppingListSettings();
            }
            case 3 -> {
                shopingList.clear();
                System.out.println("Shopping cart emptied.");
                shoppingListSettings();
            }
            case 4 -> mainMenu();
            default -> {
                System.out.println("Invalid, try again.");
                shoppingListSettings();
            }
        }
    }

    public void rateRecipe() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the recipe you want to recipe:");
        String dishName = scanner.nextLine();
        boolean foundByName = false;
        for (Recipe recipe : recipeList) {
            if (recipe.getName().equalsIgnoreCase(dishName)) {
                System.out.println(recipe);
                foundByName = true;
                System.out.println("What do you want to rate this recipe? 1-10");
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
    public void getPreparationRecipe(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the recipe to see Method of Preparation:");
        String dishName = scanner.nextLine();
        boolean foundByName = false;
        for (Recipe recipe : recipeList) {
            if (recipe.getName().equalsIgnoreCase(dishName)) {
                System.out.println("\nIngredients\n");
                System.out.println(recipe.getIngredients());
                System.out.println("------------------------------");
                foundByName = true;
                System.out.println("Method of Preparation\n");
                System.out.println(recipe.getPreparation());
                System.out.println("------------------------------");

                System.out.println("You have the following options");
                System.out.println("1. Change Method of preparation");
                System.out.println("2. See Method of preparation for different recipe");
                System.out.println("3. Back to main menu");
                int option = scanner.nextInt();
                scanner.nextLine(); //scanner bug

                switch (option){
                    case 1->{
                        System.out.println("What is the Method of preparation (1 line)");
                        String newMethodPreparation = scanner.nextLine();
                        recipe.addPreparation(newMethodPreparation);
                        System.out.println("Success");
                        System.out.println(recipe);
                        getPreparationRecipe();
                    }
                    case 2-> getPreparationRecipe();
                    case 3-> mainMenu();
                }
            }
        }
        if (!foundByName) {
            System.out.println("No recipes found with the name: " + dishName);
            mainMenu();
        }
    }
    public void addcomment(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the recipe you want to comment:");
        String dishName = scanner.nextLine();
        boolean foundByName = false;
        for (Recipe recipe : recipeList) {
            if (recipe.getName().equalsIgnoreCase(dishName)) {
                System.out.println(recipe);
                foundByName = true;
                System.out.println("What is your comment?");
                String newComment = scanner.nextLine();
                recipe.addComment(newComment);
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