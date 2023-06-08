package com.pluralsight.bdd.loyalty_cards;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class SuperSmoothieStepDef {

    private DrinkCatalog drinkCatalog = new DrinkCatalog();
    private SuperSmoothieSchema superSmoothieSchema =new SuperSmoothieSchema(drinkCatalog);

    private MorningFreshnessMember oskar;

    @Given("the following drink categories:")
    public void the_following_drink_categories(List<Map<String,String>> drinkCategories) {
        drinkCategories.stream().forEach(
                drinkCategory -> {
                    String drink = drinkCategory.get("Drink");
                    String category = drinkCategory.get("Category");
                    Integer points = Integer.parseInt(drinkCategory.get("Points"));

                    drinkCatalog.addDrink(drink, category);
                    superSmoothieSchema.setPointsPerCategory(category, points);


                }
        );
    }

    @Given("^(.*) is Morning Freshness Member$")
    public void oskar_is_a_Morning_Freshness_Member(String name){
        oskar = new MorningFreshnessMember(name,superSmoothieSchema);

    }

    @When("^(.*) purchases (\\d+) (.*) drinks?")
    public void oskar_purchases_Apple_and_Kale_drinks(String name, Integer amount, String drink){
        oskar.orders(amount, drink);
    }

    @Then("he should earn {int} points")
    public void he_should_earn_points(Integer expectedPoints){
        assertThat(oskar.getPoints()).isEqualTo(expectedPoints);

    }

}
