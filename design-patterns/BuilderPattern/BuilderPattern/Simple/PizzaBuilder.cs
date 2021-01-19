namespace Simple
{
    using System.Collections.Generic;

    public class PizzaBuilder
    {
        private List<string> ingredients = new List<string>();

        public PizzaBuilder WithMushrooms()
        {
            this.ingredients.Add("delicious mushrooms");
            return this;
        }

        public PizzaBuilder WithChicken()
        {
            this.ingredients.Add("fresh chicken breasts");
            return this;
        }

        public PizzaBuilder WithBecon()
        {
            this.ingredients.Add("crunchy becon");
            return this;
        }

        public PizzaBuilder WithSalami()
        {
            this.ingredients.Add("aged salami");
            return this;
        }

        public PizzaBuilder WithOlives()
        {
            this.ingredients.Add("juicy olives");
            return this;
        }

        public PizzaBuilder WithTomatoSauce()
        {
            this.ingredients.Add("yummy tomato sauce");
            return this;
        }

        public PizzaBuilder WithGarlicSauce()
        {
            this.ingredients.Add("aromatic garlic sauce");
            return this;
        }

        public Pizza Build()
        {
            var drink = new Pizza();
            foreach (var ingredient in this.ingredients)
            {
                drink.Ingredients.Add(ingredient.Clone() as string);
            }

            return drink;
        }

        public static implicit operator Pizza(PizzaBuilder builder)
        {
            return builder
                .WithMushrooms()
                .WithChicken()
                .WithOlives()
                .WithTomatoSauce()
                .WithGarlicSauce()
                .WithBecon()
                .Build();
        }
    }
}
