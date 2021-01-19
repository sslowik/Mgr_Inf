namespace FactoryPattern.AbstractFactory
{
    using FactoryPattern.Model;

    public class MeatMeal : GenericSingleton<MeatMeal>, IItalianCuisine
    {
        private MeatMeal()
        {
        }

        public APizza MakePizza()
        {
            return new Capriciosa() { Sauce = APizza.SauceType.Garlic};
        }

        public APasta MakePasta()
        {
            return new BologneseSpaghetti();
        }
    }
}
