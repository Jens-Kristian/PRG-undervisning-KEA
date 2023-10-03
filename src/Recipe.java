public class Recipe {
    private final String name;
    private final String ingredients;
    private final int estimatedTime;
    private int rating;
    private String comment;

    public Recipe(String recipeName, String recipeIngredients, int recipeEstimatedTime, int recipeRating, String recipeComment) {
        this.name = recipeName;
        this.ingredients = recipeIngredients;
        this.estimatedTime = recipeEstimatedTime;
        this.rating = recipeRating;
        this.comment = recipeComment;
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
    public String getComment(){
        return comment;
    }

    public void setRating(int newRating) {
        if (newRating >= 1 && newRating <= 10) {
            this.rating = newRating;
        } else {
            System.out.println("Invalid rating. Please enter a value between 1 and 10.");
        }
    }
    public void addComment(String newComment){
        this.comment = newComment;
    }

    public String toString() {
        return "Recipe name: " + name +
                "\nIngredients: " + ingredients +
                "\nEstimated Time: " + estimatedTime +
                "\nRating: " + rating +
                "\nComment: "+comment +
                "\n------------------------------";
    }
}
