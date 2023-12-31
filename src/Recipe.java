public class Recipe {
    private final String name;
    private final String ingredients;
    private final int estimatedTime;
    private int rating;
    private String preparation;
    private String comment;

    public Recipe(String recipeName, String recipeIngredients, int recipeEstimatedTime, int recipeRating,String recipePreparation, String recipeComment) {
        name = recipeName;
        ingredients = recipeIngredients;
        estimatedTime = recipeEstimatedTime;
        rating = recipeRating;
        preparation = recipePreparation;
        comment = recipeComment;
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
    public String getPreparation(){return preparation;}
    public String getComment(){return comment;}

    public void setRating(int newRating) {
        if (newRating >= 1 && newRating <= 10) {
            rating = newRating;
        } else {
            System.out.println("Invalid rating. Please enter a value between 1 and 10.");
        }
    }
    public void addPreparation(String newPredparation){
        preparation = newPredparation;
    }
    public void addComment(String newComment){
        comment = newComment;
    }

    public String toString() {
        return "Recipe name: " + name +
                "\nIngredients: " + ingredients +
                "\nEstimated Time: " + estimatedTime +
                "\nRating: " + rating +
                "\nPreparation: "+preparation+
                "\nComment: "+comment +
                "\n------------------------------";
    }
}
