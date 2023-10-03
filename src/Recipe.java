public class Recipe {
    private final String name;
    private final String ingredients;
    private final int estimatedTime;
    private int rating;

    public Recipe(String recipeName, String recipeIngredients, int recipeEstimatedTime, int recipeRating) {
        this.name = recipeName;
        this.ingredients = recipeIngredients;
        this.estimatedTime = recipeEstimatedTime;
        this.rating = recipeRating;
    }

    public String getName() {
        return name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int newRating) {
        if (newRating >= 1 && newRating <= 10) {
            this.rating = newRating;
        } else {
            System.out.println("Invalid rating. Please enter a value between 1 and 10.");
        }
    }

    public String toString() {
        return "Recipe name: " + name +
                "\nIngredients: " + ingredients +
                "\nEstimated Time: " + estimatedTime +
                "\nRating: " + rating +
                "\n------------------------------";
    }
}
